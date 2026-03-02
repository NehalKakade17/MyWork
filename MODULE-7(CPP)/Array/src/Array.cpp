//============================================================================
// Name        : Array.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;

int main3()
{



	int **ptr=new int*[2];

	ptr[0]=new int[3];
	ptr[1]=new int[3];

	for(int i=0;i<2;i++)
	{
		for(int j=0;j<4;j++)
		{
			cout<<"Enter element:	";
			cin>>ptr[i][j];
		}
	}
	cout<<"The Array is:"<<endl;
	for(int i=0;i<2;i++)
		{
			for(int j=0;j<4;j++)
			{
				cout<<ptr[i][j]<<"\t";
			}
			cout<<endl;
		}

	for(int i=0;i<2;i++)
	{
		delete[] ptr[i];
	}
	//delete[] ptr[0];
	//delete[] ptr[1];

	delete[] ptr;

	ptr=NULL;


	return 0;
}




int main2()
{
	int size=5;
	int *ptr=new int[size];		//Array of 3 int variables whose value will be GV

	for(int i=0;i<3;i++)
	{
		cout<<"Enter Element:"<<endl;
		cin>>ptr[i];
	}
	for(int i=0;i<3;i++)
	{
		cout<<ptr[i]<<"\t";
	}

	delete[] ptr;
	ptr=nullptr;
	return 0;
}




int main()
{
	//int *ptr=new int(3);		//Single int variable whose value will be 3


	int *ptr=new int[3];		//Array of 3 int variables whose value will be GV


	for(int i=0;i<3;i++)
	{
		cout<<ptr[i]<<endl;		//ptr[i]=*(ptr+i)
	}

	ptr[0]=90;
	cout<<"Address of Array:"<<ptr;
	cout<<"Value at 0th index of Array:"<<ptr[0];
	cout<<"Address of ptr:"<<&ptr;

	//delete ptr; Deallocation of of memory for single variable


	delete[] ptr;	//Deallocation of of memory for array

	ptr=NULL;

	return 0;
}
