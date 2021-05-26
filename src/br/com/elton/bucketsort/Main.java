package br.com.elton.bucketsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	
	public static void main(String[] args) {
		int[] intArray = { 54, 46, 83, 66, 95, 92, 43 };
		
		bucketSort(intArray);
		
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
	}

	private static void bucketSort(int[] intArray) {

		List<Integer>[] buckets = new List[10];
		
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < intArray.length; i++) {
			buckets[hash(intArray[i])].add(intArray[i]);
		}
		
		for(List<Integer> bucket: buckets) {
			Collections.sort(bucket);
		}
		
		int j = 0;
		
		for(int i = 0; i < buckets.length; i++) {
			for(int value: buckets[i]) {
				intArray[j++] = value;
			}
		}
	}
	
	private static int hash(int value) {
		return value / 10;
	}
}
