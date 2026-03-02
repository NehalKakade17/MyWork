//============================================================================
// Name        : Exception.cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

class ArithmaticException
{
private:
	string Message;
	int lineNumber;
	string FunctionName;
	string FileName;
public:
	ArithmaticException(string Message, int lineNumber, string FunctionName, string FileName):Message(Message),lineNumber(lineNumber),FunctionName(FunctionName),FileName(FileName)
	{

	}
	string GetMessage()
	{
		return this->Message;
	}
	void printStackTrace()
	{
		cout<<this->Message<<" in "<<this->FileName<<" in Function "<<this->FunctionName<<" at line number "<<this->lineNumber<<endl;
	}

};



int main()
{

	int Num1=100;
	int Num2=0;

	int Res=0;
	try
	{
		if(Num2==0)
		{
			throw ArithmaticException("Divide by Zero exception",__LINE__+2,__FUNCTION__,__FILE__);
		}
	Res=Num1/Num2;
	}
	catch(ArithmaticException &ex)
	{
		cout<<"Exception Occurred:"<<ex.GetMessage()<<endl;
		//ex.GetMessage();
		ex.printStackTrace();
	}

	cout<<"Res:	"<<Res;
	return 0;
}
