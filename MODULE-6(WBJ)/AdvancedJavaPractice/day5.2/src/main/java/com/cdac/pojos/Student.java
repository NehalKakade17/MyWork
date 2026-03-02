package com.cdac.pojos;

public class Student {
	private String firstName;
	private String lastName;
	private Course course;
	private int score;
	private boolean admitted;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String firstName, String lastName, Course course, int score) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.score = score;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isAdmitted() {
		return admitted;
	}
	public void setAdmitted(boolean admitted) {
		this.admitted = admitted;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", course=" + course + ", score=" + score
				+ ", admitted=" + admitted + "]";
	}
	
	
	
}
