package program;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Materia implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="professor_id",nullable=true)
	private Professor professor;
	
	@ManyToMany
	@JoinTable(name="disciplinas_alunos",
				joinColumns = @JoinColumn(name = "disciplinaFK"),
				inverseJoinColumns = @JoinColumn(name = "alunoFK"))
	private List<Aluno> alunos;
	
	public Materia(Integer id, String nome, Professor professor) {
		super();
		this.id = id;
		this.nome = nome;
		this.professor = professor;
	}
	
	public Professor getProfessor() {
		return professor;
	}



	public void setProfessor(Professor professor) {
		this.professor = professor;
	}



	public Materia() {
		
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nome=" + nome + "]";
	}
	
	

}
