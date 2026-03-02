//============================================================================
// Name        : Inheritance.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;


class A
{
public:
	int Num1;
};

class B: public A
{

};
class C: public A
{

};


class D: public B, public C
{
public:
	void ShowData()
	{
		cout<<"Num1 of B:"<<this->B::Num1<<endl;
		cout<<"Num1 of C:"<<this->C::Num1<<endl;
	}
};



int main()
{

	D d;
	d.B::Num1=100;
	d.C::Num1=200;
	d.ShowData();
	return 0;
}
