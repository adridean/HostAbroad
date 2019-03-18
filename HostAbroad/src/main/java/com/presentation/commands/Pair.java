package com.presentation.commands;


@SuppressWarnings("hiding")
public class Pair<Integer,Object>{
	
		  private final Integer left;
		  private final Object right;

		  public Pair(Integer left, Object right) {
		    this.left = left;
		    this.right = right;
		  }

		  public Integer getLeft() { return left; }
		  public Object getRight() { return right; }

		  @Override
		  public int hashCode() { 
			  return left.hashCode() ^ right.hashCode(); 
		  }

}

