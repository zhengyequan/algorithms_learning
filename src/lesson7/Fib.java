package lesson7;

public class Fib {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(fib(50));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	/** 法一：递归 */
	public static int fib(int n) {
		return n <= 1 ? n : fib(n - 1) + fib(n - 2);
	}

	/** 法二：动态规划 */
	public static long fib2(long n) {
		long num1 = 0;
		long num2 = 1;
		while (0 < --n) {
			num2 = num1 + num2;
			num1 = num2 - num1;
		}
		return num2;
	}
}
