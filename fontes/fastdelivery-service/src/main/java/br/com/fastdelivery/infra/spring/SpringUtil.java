package br.com.fastdelivery.infra.spring;

import br.com.fastdelivery.infra.dao.IDao;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Junior
 */
@Scope(value = "singleton")
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext pContext) throws BeansException {

        context = pContext;
    }

    public static <T> T getService(Class<T> pClass) {
        return context.getBean(pClass);
    }

    public static IDao getIDao(String beanName) {
        return context.getBean(beanName, IDao.class);
    }
}