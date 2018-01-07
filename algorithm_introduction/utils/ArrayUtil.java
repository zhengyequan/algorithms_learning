package utils;

import java.util.Random;

public class ArrayUtil {

	/**
	 * @param count
	 *            数组元素的个数
	 * @param maxNumber
	 *            数组元素的最大值（不含）
	 */
	public static int[] generateArray(int count, int maxNumber) {
		int[] array = new int[count];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(maxNumber);
		}

		return array;
	}

	/**
	 * 交换数组的两个元素位置
	 */
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * 输出数组所有元素
	 */
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
	}

}
