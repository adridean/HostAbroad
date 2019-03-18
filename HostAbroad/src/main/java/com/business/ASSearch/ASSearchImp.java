package com.business.ASSearch;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ASSearchImp implements ASSearch {
	
	@Override
	public TUser searchHostByName(String nickname) {
		TUser tUser = new TUser();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		try {
			String queryString = "SELECT user FROM User user WHERE user.nickname = :nickname";
			Query query = em.createQuery(queryString);
			query.setParameter("nickname", nickname);
			User user = null;
			try {
				user =  (User) query.getSingleResult();
			}
			catch (NoResultException ex) {
				System.out.println(e.getMessage());
			}
			if(user != null){
				tUser.setNickName(user.getNickname());
				tUser.setRating(user.getRating());
				tUser.setDescription(user.getDescription());
				tUser.setHost(user.getHost());
			}
		}
		catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
			
		return tUser;
	}


	@Override
	public List<TUser> searchHost() {
		List<TUser> lista = new List<TUser>();
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tr = em.getTransaction();
			tr.begin();

			String consulta = "SELECT user FROM User WHERE host = true ";
			Query query = em.createQuery(consulta);
			
			
			try {
				List<User> resultList = (List<User>) query.getResultList();
				for(User user : resultList){
					
					lista.add(new TUser(user.getNickname(),
										user.getRating(),
										user.getDescription(),
										user.getHost()));
				}
				tr.commit();
			}
			catch(NoResultException e){
				System.out.println(e.getMessage());
			}	
			
			em.close();
			emf.close();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return list;
	}

}
