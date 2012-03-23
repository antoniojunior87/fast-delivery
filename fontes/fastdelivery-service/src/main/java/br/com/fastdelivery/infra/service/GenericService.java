package br.com.fastdelivery.infra.service;

import br.com.fastdelivery.infra.dao.IDao;
import br.com.fastdelivery.infra.spring.SpringUtil;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Junior
 */
public abstract class GenericService<T> implements IService<T> {

    private IDao<T> dao;

    public void init(String daoQualifier) {
        this.dao = SpringUtil.getIDao(daoQualifier);
    }

    public final IDao<T> getDao() {
        if (dao == null) {
            throw new RuntimeException("The service did not start properly. The IDao is a null reference. Try calling the init () method.");
        }
        return dao;
    }

    @Override
    @Transactional
    public void salvar(T objeto) throws Exception {
        getDao().salvar(objeto);
    }

    @Override
    @Transactional
    public void salvarOuAtualizar(T objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public T carregarLoad(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public T carregarGet(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public T carregarLoad(Serializable id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public T carregarGet(Serializable id) throws Exception {
        return getDao().carregarGet(id);
    }

    @Override
    @Transactional(readOnly = true)
    public T findByIdAndLock(Serializable id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional
    public void atualizar(T objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional
    public void remover(T objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public T buscarEntidadePorExemplo(T exemplo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> buscarPorNamedQuery(String namedQuery) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> buscarPorNamedQuery(String namedQuery, Map<String, Object> parametros) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> buscarPorNativeQuery(String sql) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> listarPorExemplo(T exemplo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> listarPorExemplo(T objeto, MatchMode matchMode) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional
    public void executarNamedQuery(String namedQuery, Map<String, Object> parametros) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> listarPorCriteria(DetachedCriteria detachedCriteria, Order... order) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public T buscarPorCriteria(DetachedCriteria detachedCriteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional(readOnly = true)
    public T buscarEntidadePorNamedQuery(String namedQuery, Map<String, Object> parametros) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional
    public void salvarEmLote(List<T> pLista) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}