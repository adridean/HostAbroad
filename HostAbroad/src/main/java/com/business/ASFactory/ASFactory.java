package com.business.ASFactory;

import com.business.ASSearch.ASSearch;

public abstract class ASFactory {
	
	private static ASFactory asFactory;
	
	public static synchronized ASFactory getInstance() {
		if (asFactory == null) {
			asFactory = new ASFactoryImp();
		}
		return asFactory;
	}
	
	public abstract ASSearch createASSearch();

}
