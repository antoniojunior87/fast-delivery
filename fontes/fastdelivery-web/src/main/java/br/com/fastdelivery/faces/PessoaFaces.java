package br.com.fastdelivery.faces;

import br.com.fastdelivery.entity.Pessoa;
import br.com.fastdelivery.infra.faces.BaseFaces;
import br.com.fastdelivery.service.PessoaService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Junior
 */
@ManagedBean(name = "pessoaFaces")
@ViewScoped
public class PessoaFaces extends BaseFaces {

    private Pessoa pessoa = new Pessoa();

    public void limpar() {
        pessoa = new Pessoa();
    }

    public void salvar() throws Exception {
        PessoaService pessoaService = getService(PessoaService.class);
        pessoaService.inserirPessoa(pessoa);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
