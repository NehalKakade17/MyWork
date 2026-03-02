//============================================================================
// Name        : StaticCast.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <typeinfo>
using namespace std;


int main() {

	double Num1=900.89;

	//int Num=Num1;		//C

	int Num=static_cast<int>(Num1);		//C++ Style

	cout<<"Num:	"<<Num<<endl;
	return 0;
}
