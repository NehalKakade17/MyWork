package com.cdac.pojos;

public enum Course {
//fixed set of self typed constants
	JAVA(75),REACT(80),FULL_STACK(85),SPRING_BOOT(78);
	private int minScore;

	private Course(int minScore) {
		//super(name,ordinal) //calls super cls's ctor : java.lang.Enum
		this.minScore = minScore;
	}

	public int getMinScore() {
		return minScore;
	}
	
	
}
