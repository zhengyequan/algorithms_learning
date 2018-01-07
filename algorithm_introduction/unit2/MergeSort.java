package unit2;

import java.util.Arrays;

import utils.ArrayUtil;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = ArrayUtil.generateArray(10, 100);
		ArrayUtil.printArray(arr);
		int[] result = mergeSort(arr, 0, arr.length - 1);
		ArrayUtil.printArray(result);
	}

	public static int[] mergeSort(int[] arr, int start, int end) {
		if (end == start) {
			return Arrays.copyOfRange(arr, start, end + 1);
		}

		int mid = (end + start) / 2;
		int[] left = mergeSort(arr, start, mid);
		int[] right = mergeSort(arr, mid + 1, end);
		return merge(left, right);
	}

	public static int[] merge(int[] left, int[] right) {
		int[] arr = new int[left.length + right.length];
		int cur = 0;
		int i = 0;
		int j = 0;
		while (i < left.length && j < right.length) {
			arr[cur++] = left[i] < right[j] ? left[i++] : right[j++];
		}

		while (i < left.length) {
			arr[cur++] = left[i++];
		}

		while (j < right.length) {
			arr[cur++] = right[j++];
		}

		return arr;
	}

}
