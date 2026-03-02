package homework;
import java.util.*;
public class Intersection {

	public static void main(String[] args) {
		int [] arr1 = new int[5];
		int [] arr2 = new int[5];
		Scanner sc =new Scanner(System.in);
		System.out.println("For first Array:-");
		for(int i =0;i<arr1.length;i++) {
			System.out.print("Enter value for "+i+": ");
			arr1[i] =sc.nextInt();
		}
		System.out.println("For second Array:-");
		for(int i =0;i<arr2.length;i++) {
			System.out.print("Enter value for "+i+": ");
			arr2[i] =sc.nextInt();
		}
		int[] arr_f = arrIntersect(arr1,arr2);
		sc.close();
		System.out.println(Arrays.toString(arr_f));
		
	}
	public static int[] arrIntersect(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0, j = 0;
        int index = 0;
        int[] temp = new int[Math.min(arr1.length, arr2.length)];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                if (index == 0 || temp[index - 1] != arr1[i]) {
                    temp[index++] = arr1[i];
                }
                i++;
                j++;
            }
        }
        return Arrays.copyOf(temp, index);
    }

}
