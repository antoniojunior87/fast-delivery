package br.com.fastdelivery.service.impl;

import br.com.fastdelivery.entity.Pessoa;
import br.com.fastdelivery.infra.dao.IDao;
import br.com.fastdelivery.service.PessoaService;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Junior
 */
@Named
public class PessoaServiceImpl implements PessoaService {

    @Inject
    private IDao<Pessoa> pessoaService;

    @Override
    public void inserirPessoa(Pessoa p) throws Exception {
        pessoaService.salvar(p);
    }
}
