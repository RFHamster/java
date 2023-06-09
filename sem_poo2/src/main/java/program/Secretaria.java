package program;

import javax.persistence.Entity;

@Entity
public class Secretaria extends Gerentes{
	private String telefone;

	public Secretaria(String cpf, String sala, String telefone) {
		super(cpf, sala);
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
