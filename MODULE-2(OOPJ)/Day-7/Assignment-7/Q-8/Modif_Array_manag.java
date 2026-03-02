package homework;
import java.util.*;
public class Modif_Array_manag {
	private int[] array;
    private int size; 
    public Modif_Array_manag(int size) {
        this.size = size;
        this.array = new int[size];
    }
    public int[] getArray() {
        return array;
    }
    public void setArray(int[] newArray) {
        if (newArray.length == size) {
            this.array = newArray;
        } else {
            System.out.println("Error: Array size does not match.");
        }
    }
    public void printArray() {
        System.out.print("Array elements: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method to test the functionality
    public static void main(String[] args) {
    	Modif_Array_manag manager= new Modif_Array_manag(5);
        Scanner sc = new Scanner(System.in);
        int[] userInputArray = new int[5];
        System.out.println("Enter " + 5 + " values for the array:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter value for index " + i + ": ");
            userInputArray[i] = sc.nextInt();
        }
        manager.setArray(userInputArray);
        manager.printArray();

        sc.close();
    }

}
