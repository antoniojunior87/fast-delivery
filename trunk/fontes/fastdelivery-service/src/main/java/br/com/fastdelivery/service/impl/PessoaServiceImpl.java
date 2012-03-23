package br.com.fastdelivery.service.impl;

import br.com.fastdelivery.entity.Pessoa;
import br.com.fastdelivery.infra.service.GenericService;
import br.com.fastdelivery.service.PessoaService;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Junior
 */
@Named
public class PessoaServiceImpl extends GenericService<Pessoa> implements PessoaService {

    @PostConstruct
    public void init() {
        super.init("pessoaDao");
    }

    @Transactional(readOnly = false)
    @Override
    public void inserirPessoa(Pessoa p) throws Exception {
        this.salvar(p);
    }

    @Transactional(readOnly = true)
    @Override
    public Pessoa obterPessoaPorId(Long pId) throws Exception {
        return this.carregarGet(pId);
    }
}
