package unit4;

public class MaxSubArray {

	public static void main(String[] args) {
		int[] array = new int[] { -6, -2, -3, -4, -5, };
		int maxSum = sumMaxSub(array);
		System.out.println(maxSum);
	}

	/** 最大子数组问题--迭代法 */
	public static int sumMaxSub(int[] array) {
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				result = array[i] > result ? array[i] : result;
				continue;
			}

			int sum = array[i];
			int j = i + 1;
			while (j < array.length) {
				if (array[j] < 0) {
					break;
				}

				sum += array[j];
				i++;
				j++;
			}

			result = sum > result ? sum : result;
		}
		return result;
	}

}
