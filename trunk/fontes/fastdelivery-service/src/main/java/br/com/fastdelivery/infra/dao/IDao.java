package br.com.fastdelivery.infra.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

/**
 * @author Junior
 */
public interface IDao<T> {

    public void salvar(T objeto) throws Exception;

    public void salvarOuAtualizar(T objeto) throws Exception;

    public T carregarLoad(Integer id) throws Exception;

    public T carregarGet(Integer id) throws Exception;

    public T carregarLoad(Serializable id) throws Exception;

    public T carregarGet(Serializable id) throws Exception;
    
    public T findByIdAndLock(Serializable id) throws Exception;

    public List<T> listarTodos() throws Exception;

    public void atualizar(T objeto) throws Exception;

    public void remover(T objeto) throws Exception;

    public T buscarEntidadePorExemplo(final T exemplo) throws Exception;

    public List<T> buscarPorNamedQuery(String namedQuery) throws Exception;

    public List<T> buscarPorNamedQuery(String namedQuery, Map<String, Object> parametros) throws Exception;

    public List<T> buscarPorNativeQuery(String sql) throws Exception;

    public List<T> listarPorExemplo(final T exemplo) throws Exception;

    public List<T> listarPorExemplo(T objeto, MatchMode matchMode) throws Exception;

    public void executarNamedQuery(String namedQuery, Map<String, Object> parametros) throws Exception;

    public List<T> listarPorCriteria(DetachedCriteria detachedCriteria, Order... order) throws Exception;

    public T buscarPorCriteria(DetachedCriteria detachedCriteria) throws Exception;

    public T buscarEntidadePorNamedQuery(String namedQuery, Map<String, Object> parametros) throws Exception;

    void salvarEmLote(List<T> pLista) throws Exception;
}
