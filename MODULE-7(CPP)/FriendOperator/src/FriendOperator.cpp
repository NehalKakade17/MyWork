//============================================================================
// Name        : FriendOperator.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

class Test
{
private:
	int Num1;
	int Num2;
public:
	Test()
	{
		this->Num1=0;
		this->Num2=0;
	}
	Test(int Num1, int Num2)
	{
		this->Num1=Num1;
		this->Num2=Num2;
	}
	void PrintData()
	{
		cout<<"Num1:	"<<this->Num1<<endl;
		cout<<"Num2:	"<<this->Num2<<endl;
	}

	/*
	bool operator>(Test &other)			//Operator overloading of > operator using Member Function
	{
		if(this->Num1>other.Num1 && this->Num2>other.Num2)
		{
			return true;
		}
		return false;
	}
	*/
	friend bool operator>(Test &o1, Test &o2);
};

bool operator>(Test &o1, Test &o2)		//<,>=,<=,==,!=
{
	if(o1.Num1>o2.Num1 && o1.Num2>o2.Num2)
	{
		return true;
	}
	return false;
}



int main()
{
	Test t1(100,200);
	Test t2(30,40);

	bool status=t1>t2;		//t1.operator(t1 to this,t2 to other) in case of Member Function

	if(status==1)
	{
		cout<<"t1 is greater than t2"<<endl;
	}
	else
	{
		cout<<"t2 is greater than t1"<<endl;
	}

	return 0;
}
