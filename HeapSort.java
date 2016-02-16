/* Example of HeapSort algorithm implementation */

package sortingalgos;

public class HeapSort {

	private static int total;

	@SuppressWarnings("rawtypes")
	private static void swap(Comparable[] arr, int a, int b)
	{
		Comparable tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void heapify(Comparable[] arr, int i)
	{
		int lft = i * 2;
		int rgt = lft + 1;
		int grt = i;

		if(lft <= total && arr[lft].compareTo(arr[grt]) > 0) grt = lft;
		if(rgt <= total && arr[rgt].compareTo(arr[grt]) > 0) grt = rgt;

		if(grt != i){
			swap(arr, i, grt);
			heapify(arr, grt);
		}

	}

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] arr)
	{
		total = arr.length - 1;

		for(int i = total/2; i >=0; i--)
			heapify(arr, i);

		for(int i = total; i > 0; i--){
			swap(arr, 0, i);
			total--;
			heapify(arr, 0);
		}
	}

	public static void main(final String[] args){
		Integer[] arr = new Integer[] {3,2,1,5,4,6}; //Insert the array you want to sort

		System.out.println(java.util.Arrays.toString(arr));
		sort(arr);
		System.out.println(java.util.Arrays.toString(arr));
	}
}
