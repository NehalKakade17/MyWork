package selfstudy;
import java.util.Scanner;
class HashTable<K,V>{
	private static Integer key;
	private static String value;
	HashTable(){
		HashTable.key =null;
		HashTable.value =null;
	}
	HashTable(Integer key,String value){
		HashTable.key = key;
		HashTable.value = value;
	}
	public Integer getKey() {
		return HashTable.key;
	}
	public String getValue() {
		return HashTable.value;
	}
	public static void setKey(Integer key) {
		HashTable.key = key;
	}
	public static void setValue(String value) {
		HashTable.value = value;
	}
	
}
public class Hash_Prog {
	static HashTable<Integer,String> ht = new HashTable<>();
	private static int menuList() {
		System.out.println("Select:-");
		System.out.println("1.Enter Key and Value");
		System.out.println("2.Display Data");
		System.out.println("3.Exit");
		System.out.print("Enter the choice: ");
		int choice = sc.nextInt();
		return choice;
	}
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int choice;
		while((choice = Hash_Prog.menuList()) != 3) {
			switch(choice) {
			case 1:
				Hash_Prog.acceptRecord();
				break;
			case 2:
				Hash_Prog.printRecord();
				break;
			default:
				System.out.println("Invalid Choice!!");
				
			}
			
		}
		System.out.println("Exit");
	}
	public static void acceptRecord() {
		System.out.println("Enter Key:");
		Integer K = sc.nextInt();
		HashTable.setKey(K);
		sc.nextLine();
		System.out.println("Enter Value:");
		String V = sc.nextLine();
		HashTable.setValue(V);
	}
	public static void printRecord() {
		System.out.println("Key: "+ht.getKey());
		System.out.println("Value: "+ht.getValue());
	}

}
