package io;
import java.io.*;
@SuppressWarnings("serial")
class Student1 implements Serializable
{
	int roll;
	String name;
	double marks;

	Student1(){};
	Student1(int roll, String name, double marks)
	{
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	public String toString()
	{
		return "Student[roll = " + this.roll + ", name = " + this.name + ", marks = " + this.marks + "]";
	}
}

class DeserializationDemo
{
	public static void main(String args[]) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("serializefile1.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Student stud = (Student) ois.readObject();
		System.out.println("Object deserialized successfully!!");

		System.out.println("deserialized object is : ");
		System.out.println(stud);

		fis.close();
		ois.close();
	}
}