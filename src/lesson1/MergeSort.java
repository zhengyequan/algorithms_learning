package lesson1;

import java.util.Random;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[9];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(100);
			System.out.print(arr[i] + ", ");
		}

		System.out.println();
		sort(arr, 0, arr.length / 2 - 1, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	public static void sort(int[] arr, int left, int mid, int right) {
		if (arr.length == 1) {
			return;
		}

		int[] arr1 = new int[mid - left + 1];
		int[] arr2 = new int[right - mid];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = arr[i];
		}

		for (int j = 0; j < arr2.length; j++) {
			arr2[j] = arr[j + mid + 1];
		}

		sort(arr1, 0, arr1.length / 2 - 1, arr1.length - 1);
		sort(arr2, 0, arr2.length / 2 - 1, arr2.length - 1);
		merge(arr, arr1, arr2);
	}

	public static void merge(int[] temp, int[] arr1, int[] arr2) {
		int i = 0, j = 0, cur = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j]) {
				temp[cur++] = arr1[i++];
			} else {
				temp[cur++] = arr2[j++];
			}
		}

		while (i < arr1.length) {
			temp[cur++] = arr1[i++];
		}

		while (j < arr2.length) {
			temp[cur++] = arr2[j++];
		}

	}

}
