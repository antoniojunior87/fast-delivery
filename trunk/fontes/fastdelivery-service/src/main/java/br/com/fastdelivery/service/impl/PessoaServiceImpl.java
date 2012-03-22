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
    private IDao<Pessoa> pessoaDao;

    @Transactional(readOnly = false)
    @Override
    public void inserirPessoa(Pessoa p) throws Exception {
        pessoaDao.salvar(p);
    }
    
    @Transactional(readOnly = true)
    @Override
    public Pessoa obterPessoaPorId(Long pId) throws Exception {
        return pessoaDao.carregarLoad(pId);
    }
}
