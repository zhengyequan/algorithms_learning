package lesson1;

import java.util.Random;

public class SelectSort {
	public static void main(String[] args) {
		int[] arr = new int[100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(100000);
			System.out.print(arr[i] + ", ");
		}

		System.out.println();
		long start = System.currentTimeMillis();
		selectSort(arr);
		long end = System.currentTimeMillis();
		System.out.println("耗时:" + (end - start) + "ms");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = arr[i];
			int minIndex = i + 1;
			for (int j = minIndex; j <= arr.length - 1; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minIndex = j;
				}
			}

			if (arr[i] > min) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}
}
