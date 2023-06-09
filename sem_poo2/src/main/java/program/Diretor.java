package program;

import javax.persistence.Entity;

@Entity
public class Diretor extends Gerentes{
	private String formacao;

	public Diretor(String cpf, String sala, String formacao) {
		super(cpf, sala);
		this.formacao = formacao;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

}
