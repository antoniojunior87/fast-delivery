package br.com.fastdelivery.infra.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

/**
 * @author Junior
 */
public abstract class GenericSercice<T> implements IService<T> {

    public void salvar(T objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void salvarOuAtualizar(T objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public T carregarLoad(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public T carregarGet(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public T carregarLoad(Serializable id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public T carregarGet(Serializable id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public T findByIdAndLock(Serializable id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<T> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void atualizar(T objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remover(T objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public T buscarEntidadePorExemplo(T exemplo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<T> buscarPorNamedQuery(String namedQuery) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<T> buscarPorNamedQuery(String namedQuery, Map<String, Object> parametros) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<T> buscarPorNativeQuery(String sql) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<T> listarPorExemplo(T exemplo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<T> listarPorExemplo(T objeto, MatchMode matchMode) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void executarNamedQuery(String namedQuery, Map<String, Object> parametros) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<T> listarPorCriteria(DetachedCriteria detachedCriteria, Order... order) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public T buscarPorCriteria(DetachedCriteria detachedCriteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public T buscarEntidadePorNamedQuery(String namedQuery, Map<String, Object> parametros) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void salvarEmLote(List<T> pLista) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}