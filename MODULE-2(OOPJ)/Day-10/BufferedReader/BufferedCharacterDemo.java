package io;
import java.io.*;
public class BufferedCharacterDemo {
	public static void main(String args[]) throws IOException
	{
		File inf = new File("Reader.txt");	//We can give absolute path and relative path
		File opf = new File("WriterOutput.txt");	//We can give absolute path and relative path

		if(!inf.exists())
		{
			System.out.println("File does not exist!!");
			return;
		}

		FileReader fr = new FileReader(inf);
		FileWriter fw = new FileWriter(opf);

		BufferedReader br = new BufferedReader(fr);		//one more method: readLine()
		BufferedWriter bw = new BufferedWriter(fw);
		
		/*int ch;	
		while((ch = br.read()) != -1)
		{
			System.out.print((char)ch);
			bw.write(ch);
		}*/

		String line = null;
		while((line = br.readLine()) != null)
		{
			System.out.println(line);
			bw.write(line+"\n");
		}

		fr.close();
		bw.flush();
		fw.close();
		System.out.println("Program executed successfully!!");

	}
}
