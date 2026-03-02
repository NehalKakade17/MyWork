import java.util.*;
class Array_DataStructure{
	public static int insert(int [] arr,int val,int size,int capacity){
		if(size >= capacity){
			System.out.println("ARRAY FULL");
			return size;
		}
		arr[size] = val;
		return size+1;
	}
	public static int search(int[] arr,int val,int size){
		for(int i=0;i<size;i++){
			if(arr[i] == val){
				System.out.println("Found");
				return i;
			}
		}
		return -1;	
			
	}
	public static int delete(int[] arr,int val,int size){
		int ele = search(arr,val,size);
		if(ele == -1){
			System.out.println("Not Found...Can't Delete");
			return size;
		}
		for(int i = ele;i<size;i++){
			arr[i] = arr[i+1];
		}
		return size-1;
	}
	public static int display(int [] arr,int size){
		for(int i =0;i<size;i++){
			System.out.print(arr[i]+" ");
			
		}
		return 0;
	}

	public static void main(String[] args){
		int capacity = 20;
		int[] arr = new int[capacity];
		int size = 10;
		arr[0] = 11;
		arr[1] = 12;
		arr[2] = 13;
		arr[3] = 14;
		arr[4] = 15;
		arr[5] = 16;
		arr[6] = 17;
		arr[7] = 18;
		arr[8] = 19;
		arr[9] = 20;
		display(arr,size);
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("Insert element: ");
		int val1 = sc.nextInt();
		int new_s = insert(arr, val1, size,capacity);
		for(int i=0;i<new_s;i++)
		{
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		System.out.println("************");
		System.out.print("Delete element: ");
		int val2 = sc.nextInt();
		delete(arr, val2, size);
		display(arr,size);
		System.out.println();
		System.out.print("Search element: ");
		int val3 = sc.nextInt();
		int found = search(arr, val3, size);
		if(found != -1)
			System.out.println("Found at "+found);
		else
			System.out.println("Not Found");
	}
}