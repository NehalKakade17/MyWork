//============================================================================
// Name        : Friend.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

class Demo1
{
private:
	int Num3;
public:
	int Num1;
	void ShowData()
	{
		cout<<"Num1:	"<<this->Num1<<endl;
		cout<<"Num3:	"<<this->Num3<<endl;
	}
friend void Ritesh();
};

void Ritesh()
{
	Demo1 d3;
	d3.Num3=300;
	d3.ShowData();
}


//Syntax class DerviedClassName: AccessModifier BaseClassName

class Demo2:public Demo1		//By Default mode of inheritance is private
{
public:
	int Num2;
	void ShowPrint()
	{
		cout<<"Num2:	"<<this->Num2<<endl;
	}
};

class ABC
{
	friend void Ritesh();
};

int main()
{

	Demo2 d;
	d.Num1=100;
	d.Num2=200;
	d.ShowData();			//ShowData is the method base class being called by object of derived class
	Ritesh();
	return 0;
}
