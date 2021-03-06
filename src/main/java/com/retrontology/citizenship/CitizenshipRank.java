package com.retrontology.citizenship;

public enum CitizenshipRank {
	VISITOR ("default", 0),
	CITIZEN ("citizen", 1),
	VETERAN ("veteran", 2);
	
	private String name;
	private int rank;
	
	CitizenshipRank(String name, int rank) {
		this.name = name;
		this.rank = rank;
	}
	
	public int getRank()
	{
		return this.rank;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String toString()
	{
		return this.name;
	}
}
