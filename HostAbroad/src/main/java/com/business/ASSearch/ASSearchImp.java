package com.business.ASSearch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.business.TUser;
import com.business.User;

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
				System.out.println(ex.getMessage());
			}
			if(user != null){
				tUser.setNickname(user.getNickname());
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
	public ArrayList<TUser> searchHost() {
		ArrayList<TUser> list = new ArrayList<TUser>();
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tr = em.getTransaction();
			tr.begin();

			String consult = "SELECT * FROM User WHERE host = 1;";
			Query query = em.createNativeQuery(consult, User.class);
			
			
			try {
				List<User> resultList = query.getResultList();
				for(User user : resultList){
					
					list.add(new TUser(user.getNickname(),
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
