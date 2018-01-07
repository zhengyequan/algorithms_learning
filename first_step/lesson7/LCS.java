package lesson7;

import java.util.Arrays;

public class LCS {
	public static void main(String[] args) {
		String str1 = "teach";
		String str2 = "sigtnalurfghmy";
		char[] a = Arrays.copyOf(str1.toCharArray(), str1.length() + 1);
		char[] b = Arrays.copyOf(str2.toCharArray(), str2.length() + 1);
		for (int i = a.length - 2; i >= 0; i--) {
			a[i + 1] = a[i];
		}

		for (int i = b.length - 2; i >= 0; i--) {
			b[i + 1] = b[i];
		}

		a[0] = ' ';
		b[0] = ' ';
		lcs1(a, b);
	}

	/** 法一：递归 */
	public static String lcs(char[] a, int aEnd, char[] b, int bEnd) {
		if (aEnd < 0 || bEnd < 0) {
			return "";
		}

		if (a[aEnd] == b[bEnd]) {
			return lcs(a, aEnd - 1, b, bEnd - 1) + a[aEnd];
		}

		String str1 = lcs(a, aEnd - 1, b, bEnd);
		String str2 = lcs(a, aEnd, b, bEnd - 1);

		return str1.length() > str2.length() ? str1 : str2;
	}

	/** 法二：动态规划 */
	public static void lcs1(char[] a, char[] b) {
		String[][] c = new String[a.length][b.length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = "";
			}
		}

		for (int i = 1; i < c.length; i++) {
			for (int j = 1; j < b.length; j++) {
				if (a[i] == b[j]) {
					c[i][j] = c[i - 1][j - 1] + a[i];
				} else if (c[i][j - 1].length() >= c[i - 1][j].length()) {
					c[i][j] = c[i][j - 1];
				} else {
					c[i][j] = c[i - 1][j];
				}
			}
		}
		System.out.println(c[c.length - 1][c[c.length - 1].length - 1]);
	}

}
