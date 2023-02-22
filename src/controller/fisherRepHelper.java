package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Fishers;

public class fisherRepHelper {
	
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FishPopReport");
	
	public void insertFishers(Fishers s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		}

	public List<Fishers> showAllFishers() {
		EntityManager em = emfactory.createEntityManager();
		List<Fishers> allFishers = em.createQuery("SELECT s FROM Fishers s").getResultList();
		return allFishers;
		}

	public Fishers findFisher(String fisherName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Fishers> typedQuery = em.createQuery("select sh from Fishers sh where sh.fisherName = :selectedName", Fishers.class);
		
		typedQuery.setParameter("selectedName", fisherName);
		typedQuery.setMaxResults(1);
		Fishers foundFishers;
		try {
		foundFishers = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
		foundFishers = new Fishers(fisherName);
		}
		em.close();
		return foundFishers;
	}

}
