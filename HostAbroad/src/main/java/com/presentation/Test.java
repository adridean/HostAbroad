package com.presentation;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
/*
 * This class is just a testing. It will not be a part of the project. The idea of it is 
 * to represent how to create a new page of the web site.
 * Note: New page means localhost:8080/HostAbroad/NEW_PAGE
 * */
public class Test extends UI {

    @Override
    protected void init(VaadinRequest request) {
    	//addWindow(/*Window*/);
        //hola RObertitio2
    	addWindow(new Window(Cards));
    }
}
