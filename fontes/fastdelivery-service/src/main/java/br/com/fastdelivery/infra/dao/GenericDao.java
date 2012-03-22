package br.com.fastdelivery.infra.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

/**
 * @author Junior
 */
@Repository
public class GenericDao<T> implements IDao<T>, Serializable {

    private static final long serialVersionUID = -5786630429581694776L;
    @PersistenceContext(name = "fastdeliveryPU")
    private EntityManager entityManager;
    private Class<T> persistentClass;
    private Session session;

    public GenericDao(Class<T> pPersistentClass, EntityManager pEntityManager) {
        this.entityManager = pEntityManager;
        this.persistentClass = pPersistentClass;
    }
    
    public GenericDao(Class<T> pPersistentClass) {
        this.persistentClass = pPersistentClass;
    }
    
    public GenericDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public EntityManager getEntityManager() throws Exception {
        return entityManager;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public Session getSession() throws Exception {
        if (session == null || !session.isOpen()) {
            if (entityManager.getDelegate() instanceof org.hibernate.ejb.HibernateEntityManager) {
                session = ((org.hibernate.ejb.HibernateEntityManager) entityManager.getDelegate()).getSession();
            } else {
                session = (org.hibernate.Session) entityManager.getDelegate();
            }
        }
        return session;
    }

    @Override
    public void salvar(T objeto) throws Exception {
        getSession().save(objeto);
        getSession().flush();
    }

    @Override
    public void salvarOuAtualizar(T objeto) throws Exception {
        getSession().saveOrUpdate(objeto);
        getSession().flush();
    }

    @Override
    public void salvarEmLote(List<T> pLista) throws Exception {
        for (T item : pLista) {
            getSession().saveOrUpdate(item);
        }
        getSession().flush();
    }

    @Override
    public T carregarLoad(Integer id) throws Exception {
        Session lSession = (Session) getEntityManager().getDelegate();
        return (T) lSession.load(getPersistentClass(), id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T carregarGet(Integer id) throws Exception {
        Session lSession = (Session) getEntityManager().getDelegate();
        return (T) lSession.get(getPersistentClass(), id);
    }

    @Override
    public T carregarLoad(Serializable id) throws Exception {
        Session lSession = (Session) getEntityManager().getDelegate();
        return (T) lSession.load(getPersistentClass(), id);
    }

    @Override
    public T carregarGet(Serializable id) throws Exception {
        Session lsession = (Session) getEntityManager().getDelegate();
        return (T) lsession.get(getPersistentClass(), id);
    }

    @Override
    public T findByIdAndLock(Serializable id) throws Exception {
        T entity = (T) getEntityManager().find(getPersistentClass(), id, LockModeType.WRITE);
        return entity;
    }

    @Override
    public List<T> listarTodos() throws Exception {
        Session lSession = (Session) getEntityManager().getDelegate();
        Criteria criteria = lSession.createCriteria(getPersistentClass());
        return criteria.list();
    }

    protected final Criteria criaCriteria(T objeto) throws Exception {
        Session lSession = (Session) getEntityManager().getDelegate();
        return lSession.createCriteria(objeto.getClass());
    }

    @Override
    public List<T> listarPorExemplo(T objeto) throws Exception {
        return listarPorExemplo(objeto, null);
    }

    @Override
    public List<T> listarPorExemplo(T objeto, MatchMode matchMode) throws Exception {
        Session lSession = (Session) getEntityManager().getDelegate();
        Example example;
        if (matchMode == null) {
            example = criaExemplo(objeto);
        } else {
            example = criaExemplo(objeto, matchMode);
        }
        Criteria criteria = lSession.createCriteria(objeto.getClass()).add(example);
        return (List) criteria.list();
    }

    @Override
    public T buscarEntidadePorExemplo(T objeto) throws Exception {
        Session lSession = (Session) getEntityManager().getDelegate();
        Example example = criaExemplo(objeto);
        Criteria criteria = lSession.createCriteria(objeto.getClass()).add(example);
        return (T) criteria.uniqueResult();
    }

    @Override
    public void atualizar(T objeto) throws Exception {
        getSession().update(objeto);
    }

    @Override
    public void remover(T objeto) throws Exception {
        objeto = entityManager.merge(objeto);
        getSession().delete(objeto);
    }

    @Override
    public List<T> buscarPorNamedQuery(String namedQuery) throws Exception {
        return buscarPorNamedQuery(namedQuery, null);
    }

    @Override
    public List<T> buscarPorNamedQuery(String namedQuery, Map<String, Object> parametros) throws Exception {
        if (parametros == null) {
            return getEntityManager().createNamedQuery(namedQuery).getResultList();
        } else {
            Query query = createQuery(namedQuery, parametros);
            try {
                List<T> result = query.getResultList();
                return result;
            } catch (NoResultException nre) {
                return null;
            }
        }
    }

    @Override
    public void executarNamedQuery(String namedQuery, Map<String, Object> parametros) throws Exception {
        if (parametros == null) {
            getEntityManager().createNamedQuery(namedQuery);
        } else {
            Query query = createQuery(namedQuery, parametros);
            query.executeUpdate();
        }
    }

    private Query createQuery(String namedQuery, Map<String, Object> parametros) {
        Iterator<String> it = parametros.keySet().iterator();
        Query query = entityManager.createNamedQuery(namedQuery);
        while (it.hasNext()) {
            String parametroIdentifier = it.next();
            query.setParameter(parametroIdentifier, parametros.get(parametroIdentifier));
        }
        return query;
    }

    protected final Example criaExemplo(T objeto, MatchMode matchMode) throws Exception {
        Example example = Example.create(objeto);
        example.enableLike(matchMode);
        example.excludeZeroes();
        example.ignoreCase();
        return example;
    }

    @Override
    public T buscarPorCriteria(DetachedCriteria detachedCriteria) throws Exception {
        return (T) detachedCriteria.getExecutableCriteria(getSession()).uniqueResult();
    }

    @Override
    public List<T> listarPorCriteria(DetachedCriteria detachedCriteria, Order... order) throws Exception {
        if (order != null) {
            for (Order ord : order) {
                detachedCriteria.addOrder(ord);
            }
        }
        return (List<T>) detachedCriteria.getExecutableCriteria(getSession()).list();
    }

    @Override
    public List<T> buscarPorNativeQuery(String sql) throws Exception {
        return entityManager.createNativeQuery(sql).getResultList();
    }

    protected final Example criaExemplo(T objeto) throws Exception {
        Example example = Example.create(objeto);
        example.enableLike(MatchMode.ANYWHERE);
        example.excludeZeroes();
        example.ignoreCase();
        return example;
    }

    @Override
    public T buscarEntidadePorNamedQuery(String namedQuery, Map<String, Object> parametros) throws Exception {
        Query query = createQuery(namedQuery, parametros);
        try {
            T result = (T) query.getSingleResult();
            return result;
        } catch (NoResultException nre) {
            return null;
        }
    }
}
