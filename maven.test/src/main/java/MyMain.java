import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import se.tepbit.Person;



public class MyMain {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tejpUnit");
		
		EntityManager em = emf.createEntityManager();
		
		Person tejp = new Person("Tejp", "Silver", 84);
		
		em.getTransaction().begin();
		
		em.persist(tejp);

		em.getTransaction().commit();
		
		// Person.class parametern är hur hibernate ska tolka resultatet från queryn
		CriteriaQuery<Person> criteria = emf.getCriteriaBuilder().createQuery(Person.class);
		
		// Här är person.class vilken tabell jag vill hämta från
		criteria.from(Person.class);
		
		Query q = em.createQuery(criteria);
		
		@SuppressWarnings("unchecked")
		List<Person> pList = (List<Person>)q.getResultList();
		
		System.out.println(pList  );
		
		Query tejpQuery = em.createNativeQuery(("SELECT * FROM person WHERE name = 'Tejp'"));
		
		for (Object obj : tejpQuery.getResultList()) {
			
			System.out.println(Arrays.toString(((Object[])obj)));
			
		}
		
		em.close();
		emf.close();
	}
}
