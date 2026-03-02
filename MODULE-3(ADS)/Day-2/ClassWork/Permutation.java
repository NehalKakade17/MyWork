import java.util.*;
class Permutation{
	public static void display(String str , String temp){
		if(str.length() == 0){
			System.out.println(temp);
			return;
		}
		for(int i=0; i<str.length();i++){
			char c = str.charAt(i);
			String f = str.substring(0,i)+str.substring(i+1);
			display(f,temp+c);
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String s = sc.nextLine();
		display(s," ");
	}
}