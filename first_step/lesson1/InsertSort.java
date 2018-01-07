package lesson1;

import java.util.Random;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = new int[100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(100000);
			System.out.print(arr[i] + ", ");
		}

		System.out.println();
		long start = System.currentTimeMillis();
		insertSort(arr);
		long end = System.currentTimeMillis();
		System.out.println("耗时:" + (end - start) + "ms");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	public static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (key < arr[j]) {
					arr[j + 1] = arr[j];
					arr[j] = key;
				}
			}
		}
	}

}
