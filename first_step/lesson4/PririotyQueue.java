package lesson4;

import java.util.Random;

/**
 * @author zhengyequan 优先队列
 */
public class PririotyQueue {
	private static int heapSize = 0;

	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(100);
		}

		printArray(arr);

		heapSize = arr.length;
		for (int i = heapSize / 2; i >= 0; i--) {
			maxHeapify(arr, i);
		}

		printArray(arr);
		System.out.println(max(arr));
		System.out.println(extractMax(arr));
		printArray(arr);
	}

	public static int max(int[] arr) {
		return arr[0];
	}

	public static int extractMax(int[] arr) {
		int max = arr[0];
		arr[0] = arr[heapSize - 1];
		heapSize--;
		maxHeapify(arr, 0);
		return max;
	}

	public static void maxHeapify(int[] arr, int cur) {
		int left = cur * 2 + 1;
		int right = cur * 2 + 2;
		int largest = cur;
		if (left < heapSize && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < heapSize && arr[right] > arr[largest]) {
			largest = right;
		}

		if (cur != largest) {
			swap(arr, cur, largest);
			maxHeapify(arr, largest);
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
