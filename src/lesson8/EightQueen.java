package lesson8;

import java.util.Stack;

/**
 * @author zhengyequan 回溯法求解八皇后问题
 */
public class EightQueen {
	public static Stack<Queen> stack = new Stack<Queen>();
	public static int count = 0;

	public static void main(String[] args) {
		find(0);
		System.out.println(count);
	}

	/** 递归回溯法 */
	public static void find(int row) {
		if (row == 8) {
			System.out.println(stack);
			stack.pop(); // 如果八皇后的位置找好了，删除最后一个皇后，重新找位置
			count++;
		} else {
			for (int i = 0; i < 8; i++) {
				Queen queen = new Queen(row, i);
				boolean flag = stack.contains(queen);
				stack.push(queen); // 加入尝试
				if (!flag) { // 满足条件，则递归寻找下一个皇后的位置
					find(row + 1);
				} else {
					stack.pop(); // 不满足条件，继续寻找本皇后的位置
				}
			}

			if (stack.size() > 0) {
				stack.pop(); // 本行皇后的位置确定好了（或者压根没有找到位置），则（回溯）重新安排上一个皇后的位置
			}
		}
	}

}

class Queen {
	private int x;
	private int y;

	public Queen(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Queen)) {
			return false;
		}
		Queen queen = (Queen) obj;
		return this.x == queen.getX() || this.y == queen.getY() || this.y - queen.getY() == this.x - queen.getX()
				|| this.y - queen.getY() == queen.getX() - this.x;
	}

	public String toString() {
		return new StringBuilder("(").append(this.x).append(", ").append(this.y).append(")").toString();
	}

}