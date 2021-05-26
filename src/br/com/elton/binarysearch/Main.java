package br.com.elton.binarysearch;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[] {1, 3, 9, 15, 23, 27, 29, 33, 34, 35, 36, 37 };
		System.out.println(binarySearch(array, 15, 0, array.length));
	}
	
	public static int binarySearch(int[] array, int value, int startIndex, int endIndex) {
		int middle = (startIndex + endIndex) / 2;
		
		if(array[middle] == value) {
			return middle;
		} else if(array[middle] > value) {
			return binarySearch(array, value, startIndex, middle-1);
		} else {
			return binarySearch(array, value, middle+1, endIndex);
		}
	}
}
