package unit2;

import java.util.Arrays;

import utils.ArrayUtil;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = ArrayUtil.generateArray(10, 100);
		ArrayUtil.printArray(arr);
		int[] result = insertSort2(arr);
		ArrayUtil.printArray(result);
	}

	/** 迭代 */
	public static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			while (j >= 0 && arr[i] < arr[j]) {
				ArrayUtil.swap(arr, i, j);
				i--;
				j--;
			}
		}
	}

	/** 递归 */
	public static int[] insertSort2(int[] arr) {
		if (arr.length == 1) {
			return new int[] { arr[0] };
		}

		int[] pre = insertSort2(Arrays.copyOfRange(arr, 0, arr.length - 1));
		int last = arr[arr.length - 1];
		int[] newArray = Arrays.copyOf(pre, pre.length + 1);

		newArray[newArray.length - 1] = last;
		int cur = newArray.length - 1;
		int j = cur - 1;
		while (j >= 0 && last < newArray[j]) {
			ArrayUtil.swap(newArray, cur, j);
			j--;
			cur--;
		}

		return newArray;
	}

}
