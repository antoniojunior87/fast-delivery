package br.com.fastdelivery.infra.faces;

import br.com.fastdelivery.infra.spring.SpringUtil;

/**
 * @author Junior
 */
public class BaseFaces {

    public <T> T getService(Class<T> pClass) {

        return SpringUtil.getService(pClass);
    }
}
