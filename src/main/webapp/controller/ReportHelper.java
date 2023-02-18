package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.FishWeightLocationRep;

public class ReportHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FishPopReportOnline");
	
	// From this point the 'rep' is a short hand for 'report'
	public void insertItem(FishWeightLocationRep rep) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(rep);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteItem(FishWeightLocationRep toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<FishWeightLocationRep>typeQuery = em.createQuery("select rep from FishWeightLocationRep rep where rep.fishName = :selectedFish and rep.fishWeight = :selectedWeight and rep.river = :selectedRiver", FishWeightLocationRep.class);
		typeQuery.setParameter("selectedFish", toDelete.getFishName());
		typeQuery.setParameter("selectedWeight", toDelete.getFishWeight());
		typeQuery.setParameter("selectedRiver", toDelete.getRiver());
		
		typeQuery.setMaxResults(1);
		
		FishWeightLocationRep result = typeQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<FishWeightLocationRep>showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<FishWeightLocationRep>allItems = em.createQuery("select i from FishWeightLocationRep i").getResultList();
		return allItems;
	}
	
	// Search for fish, weight, and river by the name of the fish
	public List<FishWeightLocationRep> searchForEnteryByFish(String fishName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<FishWeightLocationRep>typedQuery = em.createQuery("select rep from FishWeightLocationRep rep where rep.fishName = :selectedFish", FishWeightLocationRep.class);
		typedQuery.setParameter("selectedFish", fishName);
		List<FishWeightLocationRep>foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
	public List<FishWeightLocationRep> searchForEnteryByWeight(String fishWeight) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<FishWeightLocationRep>typedQuery = em.createQuery("select rep from FishWeightLocationRep rep where rep.fishWeight = :selectedWeight", FishWeightLocationRep.class);
		typedQuery.setParameter("selectedWeight", fishWeight);
		List<FishWeightLocationRep>foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
	public List<FishWeightLocationRep> searchForEnteryByRiver(String river) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<FishWeightLocationRep>typedQuery = em.createQuery("select rep from FishWeightLocationRep rep where rep.river = :selectedRiver", FishWeightLocationRep.class);
		typedQuery.setParameter("selectedRiver", river);
		List<FishWeightLocationRep>foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
	public FishWeightLocationRep searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		FishWeightLocationRep found = em.find(FishWeightLocationRep.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateItem(FishWeightLocationRep toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
