package br.com.fastdelivery.infra.faces;

import br.com.fastdelivery.infra.spring.SpringUtil;
import java.io.Serializable;

/**
 * @author Junior
 */
public class BaseFaces implements Serializable{

    public <T> T getService(Class<T> pClass) {

        return SpringUtil.getService(pClass);
    }
}
