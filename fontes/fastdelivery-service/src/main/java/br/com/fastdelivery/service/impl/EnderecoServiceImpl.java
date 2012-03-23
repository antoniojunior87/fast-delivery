package br.com.fastdelivery.service.impl;

import br.com.fastdelivery.entity.Endereco;
import br.com.fastdelivery.infra.service.GenericService;
import br.com.fastdelivery.service.EnderecoService;
import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 *
 * @author Junior
 */
@Named
public class EnderecoServiceImpl extends GenericService<Endereco> implements EnderecoService {

    @PostConstruct
    public void init() {
        super.init("enderecoDao");
    }
}