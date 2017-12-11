package lesson5;

import java.util.Random;

/**
 * @author zhengyequan 计数排序
 */
public class CountingSort {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(100);
		}

		printArray(arr);
		int[] b = countingSort(arr, 100);
		printArray(b);
	}

	public static int[] countingSort(int[] a, int k) {
		int[] b = new int[a.length];
		int[] c = new int[k];

		for (int i = 0; i < a.length; i++) {
			c[a[i]]++;
		}

		for (int i = 1; i < c.length; i++) {
			c[i] = c[i] + c[i - 1];
		}

//		for (int i = a.length - 1; i >= 0; i--) {
//			b[c[a[i]] - 1] = a[i];
//			c[a[i]] = c[a[i]] - 1;
//		}

		for (int i = 0; i < a.length; i++) {
			b[c[a[i]] - 1] = a[i];
			c[a[i]] = c[a[i]] - 1;
		}
		return b;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}

}
