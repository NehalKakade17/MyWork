//============================================================================
// Name        : Student.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <vector>
using namespace std;

class Student
{
public:
	int RollNo;
	string Name;
	int Age;
	Student()
	{

	}
	Student(int r, string n, int a)
	{
		RollNo=r;
		Name=n;
		Age=a;
	}
	void PrintData()
	{
		cout<<"Roll No:"<<this->RollNo<<" : "<<this->Name<<endl;
	}
};
class StudentAdmin
{
public:
	vector<Student> vst;		//Association: Coupling

	StudentAdmin()
	{

		vst.push_back(Student(101,"Malkeet",34));
		vst.push_back(Student(102,"Ritesh",24));
		vst.push_back(Student(103,"Parthavi",22));
	}

	void GetAllStudens()
	{
		for(Student s:vst)
		{
			s.PrintData();
		}
	}
	void AddStudent()
	{
		Student s;
		cout<<"Enter RollNo:"<<endl;
		cin>>s.RollNo;
		cout<<"Enter Name:"<<endl;
		cin>>s.Name;
		cout<<"Enter Age:"<<endl;
		cin>>s.Age;

		vst.push_back(s);
	}
	void UpdateStudent()
	{
		int rn;
		cout<<"Enter RollNo to Update the Student:"<<endl;
		cin>>rn;
		bool flag=false;
		for(Student &s:vst)
		{
			if(s.RollNo==rn)
			{
				flag=true;
				cout<<"Enter Name:"<<endl;
				cin>>s.Name;
				cout<<"Enter Age:"<<endl;
				cin>>s.Age;
				cout<<"Record Updated Successfully"<<endl;
				break;
			}
		}
		if(flag!=true)
		{
			cout<<"Record Not Found"<<endl;
		}

	}
};

int main()
{

	StudentAdmin sad;

	sad.GetAllStudens();

	sad.AddStudent();
	sad.GetAllStudens();
	sad.UpdateStudent();
	sad.GetAllStudens();

}
