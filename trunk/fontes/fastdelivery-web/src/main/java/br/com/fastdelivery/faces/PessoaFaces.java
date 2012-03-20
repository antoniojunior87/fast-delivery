package br.com.fastdelivery.faces;

import br.com.fastdelivery.commons.entity.Pessoa;
import javax.faces.bean.ManagedBean;

/**
 * @author Junior
 */
@ManagedBean(name = "pessoaFaces")
public class PessoaFaces {

    private Pessoa pessoa = new Pessoa();
    
    public void limpar() {
        pessoa = new Pessoa();
    }
    
    public void salvar() {
        pessoa.setNome(pessoa.getNome() + " Salvo!");
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}