//============================================================================
// Name        : Template.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

//template<typename T>
//template<class T>
template<class Malkeet>
Malkeet Add(Malkeet Num1, Malkeet Num2)
{
	return Num1+Num2;
}

int main()
{
	int Num1=100;
	int Num2=200;

	int Res=Add<int>(Num1,Num2);
	cout<<"Sum of Two int is :	"<<Res<<endl;

	float Resf=Add<float>(100, 200.56f);
	cout<<"Sum of Two Float is :	"<<Resf<<endl;


	cout<<"Sum of Two Double is :	"<<Add<double>(345.90,789.90)<<endl;

}
