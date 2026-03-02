//============================================================================
// Name        : Template2.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;
template<class T>
class MathOp
{
public:
	T Val1;
	T Val2;

	MathOp(T Val1, T Val2)
	{
		this->Val1=Val1;
		this->Val2=Val2;
	}
	void ComparateVal()
	{
		if(this->Val1>this->Val2)
		{
			cout<<"Val1 is Greater"<<endl;
		}
	}
};


int main()
{
	MathOp<double> obj(500.67,200.89);
	obj.ComparateVal();

}
