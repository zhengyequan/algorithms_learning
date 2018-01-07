package lesson3;

public class MatrixMultiply {
	public static void main(String[] args) {
		int[][] arr1 = new int[10][10];
		int[][] arr2 = new int[10][10];

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				arr1[i][j] = 1;
			}
		}

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = 1;
			}
		}

		mutiply(arr1, arr2);
	}

	/** 法一：朴素算法 */
	public static int[][] mutiply(int[][] arr1, int[][] arr2) {
		int[][] arr3 = new int[10][10];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				for (int k = 0; k < arr3.length; k++) {
					arr3[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		return arr3;
	}

}
