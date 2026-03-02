//============================================================================
// Name        : MapEmployee.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
#include <typeinfo>
using namespace std;

class Employee
{
public:
	int EmpId;
	string Name;
	float Salary;
	int Age;
	string Dept;
	string Designation;
public:
	Employee()
	{

	}
	Employee(int EmpId, string Name, float Salary, int Age, string Dept, string Designation)
	{
		this->EmpId=EmpId;
		this->Name=Name;
		this->Salary=Salary;
		this->Age=Age;
		this->Dept=Dept;
		this->Designation=Designation;
	}

	bool operator<(const Employee &ref)const		//Sort by EmpId
	{
		return this->EmpId<ref.EmpId;
	}
	void ShowEmployee()const
	{
		cout<<"EmpId:   "<<this->EmpId<<" Name:   "<<this->Name<<" Salary:   "<<this->Salary<<" Age:   "<<this->Age<<" Dept:   "<<this->Dept<<" Designation:   "<<this->Designation<<endl;
	}

};
class Address
{
public:
	string City;
	string Country;
	Address()
	{
		this->City="";
		this->Country="";
	}
	Address(string City, string Country)
	{
		this->City=City;
		this->Country=Country;
	}

	void ShowAddress()
	{
		cout<<"City:	"<<this->City<<" Country:	"<<this->Country<<endl;
	}

};

int main()
{
	map<Employee,Address> ea;

	ea.insert({Employee(1001,"Malkeet",12345.89f,34,"CSE","ML"),Address("Mumbai","India")});

	ea[Employee(1002,"Varun",23345.89f,24,"ECGC","SPE")]=Address("Delhi","India");

	ea[Employee(999,"Abhi",23345.89f,24,"ECGC","SPE")]=Address("Berlin","Germany");

	for(auto &ref:ea)
	{
		//cout<<"Name:	"<<ref.first.Name<<" City:"<<ref.second.City<<endl;

		//ref.first.ShowEmployee();
		//ref.second.ShowAddress();
	}

	int EmpId=1002;

	for(auto &ref:ea)
	{
		if(ref.first.EmpId==EmpId)
		{
			ref.second.ShowAddress();
			//ea.erase(ref.first);
			break;
		}
	}

	//auto it=ea.find(1001);			//NOT OK
	auto it=ea.find(Employee(1001,"Malkeet",12345.89f,34,"CSE","ML"));

	if(it!=ea.end())
	{
		it->second.ShowAddress();
	}


	return 0;
}
