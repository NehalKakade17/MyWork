class Heap{
	void heapify(int[] arr,int n,int i){
		int largest =i;
		int l =2*i+1;
		int r = 2*i+2;
		if(l<n && arr[l] > arr[largest]){
			largest = l;
		}
		if(r<n && arr[r] > arr[largest]){
			largest = r;
		}
		if(largest !=i){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr,n,largest);
		}
	}
	void heapsort(int arr[]){
		int n = arr.length;
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,n,i);
		}
		for(int i=n-1;i>0;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr,i,0);
		}
	}
	void display(int arr[]){
		int n =arr.length;
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		Heap h = new Heap();
		int arr[] = {22,55,11,36,82,19};
		h.display(arr);
		h.heapsort(arr);
		h.display(arr);
	}
}