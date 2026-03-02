package io;
import java.io.*;
public class ConsoleInputOutputDemo {
	public static void main(String args[]) throws IOException
	{	
		//InputStreamReader, BufferedReader
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		System.out.println("Please enter a double value: " );
		double dval = Double.parseDouble(br.readLine());
		System.out.println("Entered double value: " + dval);

		System.out.println("Please enter any string: ");
		String str = br.readLine();
		System.out.println("Entered string value: " + str);

		System.out.println("Enter any integer value: ");
		int ival = Integer.parseInt(br.readLine());
		System.out.println("Entered integer value: " + ival);

		System.out.println("Enter any boolean value: ");
		boolean bval = Boolean.parseBoolean(br.readLine());
		System.out.println("Entered boolean value: " + bval);

		isr.close();
	}
}
