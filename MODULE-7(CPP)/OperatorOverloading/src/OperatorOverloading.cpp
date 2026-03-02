//============================================================================
// Name        : OperatorOverloading.cpp
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

	friend ostream& operator<<(ostream &cout, Test &t1);


};
ostream& operator<<(ostream &cout, Test &t1)
	{
		cout<<"Num1:	"<<t1.Num1<<endl;
		cout<<"Num2:	"<<t1.Num2<<endl;
		return cout;
	}


int main()
{
	Test t1(100,200);
	//t1.PrintData();
	cout<<t1;
	cout<<"------------------------------------"<<endl;
	Test t2(1000,2000);
	cout<<t2;
	return 0;
}
