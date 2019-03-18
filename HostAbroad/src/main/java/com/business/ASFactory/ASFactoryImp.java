package com.business.ASFactory;

import com.business.ASSearch.ASSearch;
import com.business.ASSearch.ASSearchImp;

public class ASFactoryImp extends ASFactory {	
	
	public ASSearch createASSearch() {
		return new ASSearchImp();
	}

}
