package com.presentation;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

public class SearchUI extends UI {

	private Window s;

	@Override
	protected void init(VaadinRequest request) {
		s = new Search();
		addWindow(s);
	}
}
