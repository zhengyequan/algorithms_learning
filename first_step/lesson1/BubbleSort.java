package lesson1;

import java.util.Random;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(100);
			System.out.print(arr[i] + ", ");
		}

		System.out.println();
		long start = System.currentTimeMillis();
		long end = System.currentTimeMillis();
		System.out.println("耗时:" + (end - start) + "ms");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1;) {
		}
	}
}
