package lesson6;

import java.util.HashMap;
import java.util.Map;

public class DynProgramme {

	public static void main(String[] args) {
		int[] p = new int[] { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int q = memoizedCutRod(p, 4, map);
		System.out.println(q);
	}

	/** 递归法 */
	public static int cutRod(int[] p, int n) {
		if (n == 0) {
			return 0;
		}

		int q = -1;
		for (int i = 0; i < n; i++) {
			q = Math.max(q, p[i] + cutRod(p, n - i - 1));
		}
		return q;
	}

	/** 动态规划--自顶向下 */
	public static int memoizedCutRod(int[] p, int n, Map<Integer, Integer> map) {
		if (map.get(n) != null) {
			return map.get(n);
		}

		int q = -1;
		if (n == 0) {
			q = 0;
		} else {
			for (int i = 0; i < n; i++) {
				q = Math.max(q, p[i] + memoizedCutRod(p, n - i - 1, map));
			}
		}
		map.put(n, q);
		return q;
	}
}
