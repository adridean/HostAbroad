package com.presentation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.business.User;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.Window;

public class Search extends Window {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2745222530131311340L;

	private GridLayout layout;

	private Button search;

	private CheckBox cbHosts;

	private CheckBox cbTravelers;
	
	private TextArea results;

	public Search() {
		layout = new GridLayout(2, 3);
		layout.setMargin(true);
		layout.setSpacing(true);
		search = new Button("Search");
		search.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				results.clear();
				if (cbHosts.getValue() == true && cbTravelers.getValue() == false) {
					List<User> hosts = readAllHosts();
					if(hosts.size() > 0) {
						for(User u : hosts) {
							results.setValue(results.getValue() + u.getNickName() + "\n");
						}
					}
					else {
						results.setValue("There are no hosts");
					}
				}
				else if (cbHosts.getValue() == false && cbTravelers.getValue() == true){
					List<User> travelers = readAllTravelers();
					if(travelers.size() > 0) {
						for(User u : travelers) {
							results.setValue(results.getValue() + u.getNickName() + "\n");
						}
					}
					else {
						results.setValue("There are no travelers");
					}
				}
				else {
					results.setValue("You have to choose between Hosts or Travelers to perform the search");
				}
			}

		});
		cbHosts = new CheckBox("Hosts");
		cbTravelers = new CheckBox("Travelers");
		results = new TextArea();
		results.setEnabled(false);
		layout.addComponent(cbHosts, 0, 0);
		layout.addComponent(cbTravelers, 0, 1);
		layout.addComponent(search, 0, 2);
		layout.addComponent(results, 1, 0, 1, 2);
		this.setContent(layout);
		this.setClosable(false);
		this.setWindowMode(WindowMode.MAXIMIZED);
		this.setResizable(false);
	}
	
	public List<User> readAllHosts(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<User> hosts = em.createNativeQuery("SELECT * FROM User WHERE Host = 1", User.class).getResultList();
        
        em.close( );
        emf.close( );
        
        return hosts;
	}
	
	public List<User> readAllTravelers(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<User> travelers = em.createNativeQuery("SELECT * FROM User WHERE Host = 0", User.class).getResultList();
        
        em.close( );
        emf.close( );
        
        return travelers;
	}

}
