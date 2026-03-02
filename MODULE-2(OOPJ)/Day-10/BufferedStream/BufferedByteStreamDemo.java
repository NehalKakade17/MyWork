package io;
import java.io.*;
class BufferedByteStreamDemo
{
	public static void main(String args[]) throws IOException
	{
		File inf = new File("demo.txt");	//We can give absolute path and relative path
//		File opf = new File("myoutfile.txt");	//We can give absolute path and relative path

		if(!inf.exists())
		{
			System.out.println("File does not exist!!");
			return;
		}

		FileInputStream fis = new FileInputStream(inf);
		//FileOutputStream fos = new FileOutputStream(opf);	//OK
		//FileOutputStream fos = new FileOutputStream("myoutfile.txt");	    //Will overwrite
		FileOutputStream fos = new FileOutputStream("demooutput.txt",true);  //Will append

		BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int ch;	
		while((ch = bis.read()) != -1)
		{
//			System.out.print((char)ch);
			bos.write(ch);
		}

		fis.close();
		bos.flush();
		fos.close();
		System.out.println("Program executed successfully!!");

	}
}
