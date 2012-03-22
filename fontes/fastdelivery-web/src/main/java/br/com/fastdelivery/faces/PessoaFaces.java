package br.com.fastdelivery.faces;

import br.com.fastdelivery.entity.Pessoa;
import br.com.fastdelivery.infra.faces.BaseFaces;
import br.com.fastdelivery.service.PessoaService;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Junior
 */
@ManagedBean(name = "pessoaFaces")
@ViewScoped
public class PessoaFaces extends BaseFaces implements Serializable {

    private Pessoa pessoa = new Pessoa();

    @PostConstruct
    public void init() {
        try {
            pessoa = getService().obterPessoaPorId(1L);
        } catch (Exception ex) {
            Logger.getLogger(PessoaFaces.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limpar() {
        pessoa = new Pessoa();
    }

    public void salvar() throws Exception {

        getService().inserirPessoa(pessoa);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public PessoaService getService() {
        return super.getService(PessoaService.class);
    }
}
