package com.presentation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.business.User;
import com.vaadin.server.UserError;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class Search extends Window {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2745222530131311340L;

	private GridLayout layout;

	private Button search;

	private RadioButtonGroup<String> rbGroup;

	private TextArea results;

	public Search() {
		HorizontalLayout hL = new HorizontalLayout();
		VerticalLayout vL = new VerticalLayout();
		rbGroup = new RadioButtonGroup<String>();
		rbGroup.setItems("Hosts", "Travelers");
		search = new Button("Search");
		search.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				System.out.println(rbGroup.getValue());
				results.clear();
				search.setComponentError(null);
				try {
					if (rbGroup.getValue().equals("Hosts")) {
						List<User> hosts = readAllHosts();
						if (hosts.size() > 0) {
							for (User u : hosts) {
								results.setValue(results.getValue() + u.getNickName() + "\n");
							}
						} else {
							results.setValue("There are no hosts");
							Notification.show("There are no hosts");
						}
					} else if (rbGroup.getValue().equals("Travelers")) {
						List<User> travelers = readAllTravelers();
						if (travelers.size() > 0) {
							for (User u : travelers) {
								results.setValue(results.getValue() + u.getNickName() + "\n");
							}
						} else {
							results.setValue("There are no travelers");
							Notification.show("There are no travelers");
						}
					} else if (!rbGroup.isSelected("Hosts") || !rbGroup.isSelected("Travelers")) {
						throw new Exception();
					}
				} catch (Exception e) {
					search.setComponentError(
							new UserError("You have to choose Hosts or Travelers to perform the search"));
				}
			}

		});
		results = new TextArea();
		results.setEnabled(false);
		results.setSizeFull();
		vL.setSizeUndefined();
		vL.addComponent(rbGroup);
		vL.addComponent(search);
		hL.setMargin(true);
		hL.setSizeFull();
		hL.addComponent(vL);
		hL.addComponent(results);
		this.setContent(hL);
		this.setClosable(false);
		this.setWindowMode(WindowMode.MAXIMIZED);
		this.setResizable(false);
	}

	public List<User> readAllHosts() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<User> hosts = em.createNativeQuery("SELECT * FROM User WHERE Host = 1", User.class).getResultList();

		em.close();
		emf.close();

		return hosts;
	}

	public List<User> readAllTravelers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<User> travelers = em.createNativeQuery("SELECT * FROM User WHERE Host = 0", User.class).getResultList();

		em.close();
		emf.close();

		return travelers;
	}

}
