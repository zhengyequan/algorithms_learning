package lesson9;

import java.util.Stack;

public class BinaryTreeTest {
	public static void main(String[] args) {
		// BinaryTree<Integer> tree = new BinaryTree<Integer>();
		// tree.insert(8);
		// tree.insert(6);
		// tree.insert(5);
		// tree.insert(2);
		// tree.insert(3);
		// tree.insert(7);
		// tree.insert(1);
		// tree.insert(4);

		BinaryTree<String> tree = new BinaryTree<String>();
		tree.insert("5");
		tree.insert("6");
		tree.insert("7");
		tree.insert("8");
		tree.insert("3");
		tree.insert("2");
		tree.insert("4");
		tree.insert("1");
		tree.traverseMid(tree.getRoot());
		System.out.println();
		tree.iterateMid(tree.getRoot());
	}
}

class BinaryTree<T extends Comparable<T>> {

	private Node<T> root;

	public T insert(T data) {
		Node<T> node = new Node<T>();
		node.setData(data);
		if (root == null) {
			root = node;
		} else {
			root.insert(data);
		}
		return data;
	}

	public Node<?> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return root == null ? 0 : root.size();
	}

	public int height() {
		if (root == null) {
			return -1;
		}

		if (root.getLeft() == null && root.getRight() == null) {
			return 0;
		}

		return root.height();
	}

	/** 递归遍历--前序 */
	public void traversePre(Node<?> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getData() + ", ");
		traversePre(node.getLeft());
		traversePre(node.getRight());
	}

	/** 递归遍历--中序 */
	public void traverseMid(Node<?> node) {
		if (node == null) {
			return;
		}

		traverseMid(node.getLeft());
		System.out.print(node.getData() + ", ");
		traverseMid(node.getRight());
	}

	/** 递归遍历--后序 */
	public void traverseAfter(Node<?> node) {
		if (node == null) {
			return;
		}

		traverseAfter(node.getLeft());
		traverseAfter(node.getRight());
		System.out.print(node.getData() + ", ");
	}

	/** 迭代遍历--前序 */
	public void iteratePre(Node<?> root) {
		Stack<Node<?>> stack = new Stack<Node<?>>();
		if (root == null) {
			return;
		}

		stack.push(root);
		while (!stack.isEmpty()) {
			Node<?> item = stack.pop();
			System.out.print(item.getData() + ", ");
			if (item.getRight() != null) {
				stack.push(item.getRight());
			}
			if (item.getLeft() != null) {
				stack.push(item.getLeft());
			}
		}
	}

	public void iterateMid(Node<?> root) {
		Stack<Node<?>> stack = new Stack<Node<?>>();
		if (root == null) {
			return;
		}

		pushLeft2Stack(root, stack);
		Node<?> node = stack.pop();
		while (node != null) {
			System.out.print(node.getData() + ", ");
			pushLeft2Stack(node.getRight(), stack);
			if (stack.size() == 0) {
				break;
			}
			node = stack.pop();
		}
	}

	private void pushLeft2Stack(Node<?> node, Stack<Node<?>> stack) {
		while (node != null) {
			stack.push(node);
			node = node.getLeft();
		}
	}

}

class Node<T extends Comparable<T>> {
	/**
	 * 节点存储的数据
	 */
	private T data;

	/**
	 * 父节点
	 */
	private Node<T> parent;

	/**
	 * 左孩子节点
	 */
	private Node<T> left;

	/**
	 * 右孩子节点
	 */
	private Node<T> right;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T insert(T data) {
		Node<T> node = new Node<T>();
		node.setData(data);
		if (data == null) {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.insert(data);
			}
		} else if (this.data.compareTo(data) >= 0) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.insert(data);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.insert(data);
			}
		}

		return data;
	}

	/**
	 * 节点子树的规模
	 */
	public int size() {
		int size = 1;
		if (this.left != null) {
			size += this.left.size();
		}

		if (this.right != null) {
			size += this.right.size();
		}
		return size;
	}

	public int height() {
		int lHeight = this.left == null ? 0 : this.left.height() + 1;
		int rHeight = this.right == null ? 0 : this.right.height() + 1;
		return lHeight > rHeight ? lHeight : rHeight;
	}

}
