package lesson2;

public class FindMaxSubArray {
	public static void main(String[] args) {
		// int[] arr = new int[] { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7,
		// 12, -5, -22, 15, -4, 7 };
		int[] arr = new int[] { 6, -4 };
		// System.out.println(findMaxSubArray(arr, 0, arr.length - 1));
		findMaxSubArray1(arr);
	}

	/** 法一：分治法 */
	public static int findMaxSubArray(int[] arr, int left, int right) {
		if (left == right) {
			return arr[left] > 0 ? arr[left] : 0;
		}

		int mid = (right - left) / 2 + left;
		int leftSum = 0, leftMaxBorder = 0;
		for (int i = mid; i >= left; i--) {
			leftSum += arr[i];
			if (leftSum > leftMaxBorder) {
				leftMaxBorder = leftSum;
			}
		}

		int rightSum = 0, rightMaxBorder = 0;
		for (int j = mid + 1; j <= right; j++) {
			rightSum += arr[j];
			if (rightSum > rightMaxBorder) {
				rightMaxBorder = rightSum;
			}
		}

		int leftMax = findMaxSubArray(arr, left, mid);
		int rightMax = findMaxSubArray(arr, mid + 1, right);
		return max(leftMax, rightMax, leftMaxBorder + rightMaxBorder);
	}

	public static int max(int x, int y, int z) {
		int max = x;
		if (y > max) {
			max = y;
		}

		if (z > max) {
			max = z;
		}
		return max;
	}

	/** 法二：朴素算法，时间复杂度为O(n) */
	public static void findMaxSubArray1(int[] arr) {
		int maxSum = 0;
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			temp += arr[i];
			if (temp <= 0) {
				temp = 0;
			}

			if (maxSum < temp) {
				maxSum = temp;
			}
		}
		System.out.println(maxSum);
	}

}
