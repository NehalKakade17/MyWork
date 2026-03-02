package io;
import java.io.*;
public class FileMethodDemo {
	public static void main(String args[])
	{
		File f1 = new File("src");

		if(!f1.exists())
		{
			System.out.println("File does not exist");
		}

		if(f1.isDirectory() == true)
		{
			System.out.println("The given file is a directory");
			//List all the files in the directory
			String []fnames = f1.list();

			for(String fn : fnames)
			{
				System.out.println(fn);
			}
		}
	}
}
