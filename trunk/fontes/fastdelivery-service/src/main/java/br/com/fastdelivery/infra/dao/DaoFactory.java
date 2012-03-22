package br.com.fastdelivery.infra.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Junior
 */
public class DaoFactory {

    @PersistenceContext(name = "fastdeliveryPU")
    static EntityManager entityManager;

//    public GenericDao createDAO(InjectionPoint injectionPoint) throws Exception {
//        ParameterizedType type = (ParameterizedType) injectionPoint.getType();
//        Class classe = (Class) type.getActualTypeArguments()[0];
//        return new GenericDao(classe, entityManager);
//    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}