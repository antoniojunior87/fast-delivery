package br.com.fastdelivery.faces;

import br.com.fastdelivery.entity.Endereco;
import br.com.fastdelivery.entity.Pessoa;
import br.com.fastdelivery.infra.faces.BaseFaces;
import br.com.fastdelivery.service.EnderecoService;
import br.com.fastdelivery.service.PessoaService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Junior
 */
@ManagedBean(name = "pessoaFaces")
@ViewScoped
public class PessoaFaces extends BaseFaces implements Serializable {

    private Pessoa pessoa;
    private Endereco endereco;

    @PostConstruct
    public void init() {
        pessoa = new Pessoa();
        endereco = new Endereco();
    }

    public void limpar() {
        pessoa = new Pessoa();
        endereco = new Endereco();
    }

    public void salvar() throws Exception {

        getService().inserirPessoa(pessoa);
        getService(EnderecoService.class).salvar(endereco);
    }

    //<editor-fold defaultstate="collapsed" desc="get and set">
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    //</editor-fold>

    @Override
    public PessoaService getService() {
        return super.getService(PessoaService.class);
    }
}
