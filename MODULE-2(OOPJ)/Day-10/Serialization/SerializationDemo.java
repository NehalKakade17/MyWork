package io;
import java.io.*;
@SuppressWarnings("serial")
class Student implements Serializable
{
	int roll;
	String name;
	double marks;

	Student(){};
	Student(int roll, String name, double marks)
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

class SerializationDemo
{
	public static void main(String args[]) throws IOException
	{
		FileOutputStream fos = new FileOutputStream("serializefile1.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Student stud = new Student(1,"Nehal",95.8);
		oos.writeObject(stud);
		System.out.println("Object serialized successfully!!");

		System.out.println("Serialized object is: ");
		System.out.println(stud);

		fos.close();
		oos.close();
	}
}