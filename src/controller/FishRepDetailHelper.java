package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.FishReportDetails;

public class FishRepDetailHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FishPopReport");
	
	public void insertNewListDetails(FishReportDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
			
	public List<FishReportDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<FishReportDetails> allDetails = em.createQuery("SELECT d FROM FishReportDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteList(FishReportDetails listToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<FishReportDetails> typedQuery = em.createQuery("select detail from FishReportDetails detail where detail.id = :selectedId", FishReportDetails.class);
		
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", listToDelete.getId());
		
		// we only want one result
		typedQuery.setMaxResults(1);
		
		// get the result and save it into a new list item
		FishReportDetails result = typedQuery.getSingleResult();
		
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public FishReportDetails searchForListDetailsById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		FishReportDetails found = em.find(FishReportDetails.class, tempId);
		em.close();
		return found;
	}

	public void updateReport(FishReportDetails reportToUpdate) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(reportToUpdate);
		em.getTransaction().commit();
		em.close();
	}
}
