package lesson4;

import java.util.Random;

/**
 * @author zhengyequan 堆排序
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(100);
		}

		printArray(arr);
		int heapSize = arr.length;
		for (int i = arr.length / 2; i >= 0; i--) {
			maxHeapify(arr, i, heapSize);
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			swap(arr, 0, i);
			heapSize--;
			maxHeapify(arr, 0, heapSize);
		}
		printArray(arr);
	}

	public static void maxHeapify(int[] arr, int cur, int heapSize) {
		int left = cur * 2 + 1;
		int right = cur * 2 + 2;
		int largest = cur;
		if (left < heapSize && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < heapSize && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != cur) {
			swap(arr, cur, largest);
			maxHeapify(arr, largest, heapSize);
		}

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}
}
