package com.business.ASSearch;

public interface ASSearch {
	
	public abstract TUser searchHostByName(String nickname);
	
	public abstract List<TUser> searchHost();

}
