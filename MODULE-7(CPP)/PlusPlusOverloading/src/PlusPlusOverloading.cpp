//============================================================================
// Name        : PlusPlusOverloading.cpp
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

	friend void operator++(Test &ob);
	friend void operator++(Test &ob, int);
};

void operator++(Test &ob)
{
	ob.Num1++;
	ob.Num2++;
}
void operator++(Test &ob, int)
{
	ob.Num1++;
	ob.Num2++;
}

int main()
{
	Test t1(10,20);
	++t1;		//t1.operator++(&t1), in case of member function
				//operator++(t1), in case non-member function
	cout<<"------------------------------------"<<endl;
	t1++;
	t1.PrintData();
	//t1==t2;			//t1.operator(&t1,t2);
	//t1==t2;			//operator(t1,t2);
	return 0;
}
