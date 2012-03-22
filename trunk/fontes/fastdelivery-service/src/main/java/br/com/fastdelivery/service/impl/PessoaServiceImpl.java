package br.com.fastdelivery.service.impl;

import br.com.fastdelivery.entity.Pessoa;
import br.com.fastdelivery.infra.dao.IDao;
import br.com.fastdelivery.service.PessoaService;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Junior
 */
@Named
public class PessoaServiceImpl implements PessoaService {

    @Inject
    private IDao<Pessoa> pessoaService;

    @Transactional(readOnly = false)
    @Override
    public void inserirPessoa(Pessoa p) throws Exception {
        pessoaService.salvar(p);
    }
}
