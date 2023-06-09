package program;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Aluno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer matricula;
	private String nome;
	private String email;
	
	@ManyToMany(mappedBy = "alunos")
	private List<Materia> materia;
	
	public Aluno(Integer id, String nome, String email) {
		super();
		this.matricula = id;
		this.nome = nome;
		this.email = email;
	}
	
	public Aluno() {
		
	}

	public int getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + matricula + ", nome=" + nome + ", email=" + email + "]";
	}
	
}
