package program;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Programa {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("apresentacao-poo");
		EntityManager em = emf.createEntityManager();
		
		
		try {
		    em.getTransaction().begin();
		    //Escreva aqui o código para utilizar o banco
		    em.getTransaction().commit();
		} catch (Exception e) {
		    em.getTransaction().rollback();
		} finally {
		    em.close();
		    emf.close();
		}
		
		
		/*
		 * Inserir Professores
		Professor p1 = new Professor(null,"Carlos da Silva","cs12@gmail.com");
		Professor p2 = new Professor(null,"Morgana da Aparecida","apMORG@gmail.com");
		Professor p3 = new Professor(null,"Kleber Ferrari","klFerrari@gmail.com");
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		*/
		
		/*
		 * Inserindo uma matéria, buscando o professor Kleber Ferrari no banco e o associando com ela
		String jpql = "SELECT p FROM Professor p WHERE p.nome = :nome";
	    TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
	    query.setParameter("nome", "Kleber Ferrari");
	    List<Professor> resultado = query.getResultList();
	    System.out.println(resultado.get(0).toString());
	    em.persist(new Materia(null, "matematica",resultado.get(0)));
	    
	     * Conferindo a disciplina na lista do professor, ele add automaticamente
	    Professor p1 = em.find(Professor.class, 6);
		System.out.println(p1);
		System.out.println(p1.getDisciplinas().get(0));
		 */
		
		/*
		 * Alterando o email da professora Morgana (id 5), tabém poderia fazer a busca igual o ex acima
		 Professor professor = em.find(Professor.class, 5);
		 if (professor != null) {
	        professor.setEmail("morgAparecida@outlook.com");
	        System.out.println("Pronto!");
	     } else {
	        System.out.println("Não encontrado!");
	     }
		 */
		
		/*
		 * Removendo o Professor Carlos (id 7)
		 Professor professor = em.find(Professor.class, 7);
		 em.remove(professor);
		 */
		System.out.println("Pronto");
		
	}

}
