package br.com.elton.binarysearch;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[] {1, 3, 9, 15, 23, 27, 29, 33, 34, 35, 36, 37 };
		System.out.println(binarySearch(array, 15, 0, array.length));
		System.out.println(binarySearch(array, 27, 0, array.length));
		System.out.println(binarySearch(array, 37, 0, array.length));
		System.out.println(iterativeBinarySearch(array, 35));
	}
	
	public static int binarySearch(int[] array, int value, int startIndex, int endIndex) {
		int middle = (startIndex + endIndex) / 2;
		
		if(array[middle] == value) {
			return middle;
		} else if(array[middle] > value) {
			return binarySearch(array, value, startIndex, middle);
		} else {
			return binarySearch(array, value, middle+1, endIndex);
		}
	}
	
	public static int iterativeBinarySearch(int[] array, int value) {
		int start = 0;
		int end = array.length;
		
		while(start < end) {
			int midpoint = (start + end) / 2;
			
			if(array[midpoint] == value) {
				return midpoint;
			} else if(array[midpoint] < value) {
				start = midpoint + 1;
			} else {
				end = midpoint;
			}
		}
		return -1;
	}
}
