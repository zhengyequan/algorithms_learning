package lesson9;

import java.util.Stack;

/**
 * 二叉搜索树
 */
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

		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insert(5);
		tree.insert(12);
		tree.insert(7);
		tree.insert(8);
		tree.insert(3);
		tree.insert(13);
		tree.insert(2);
		tree.insert(4);
		tree.insert(1);
		tree.traversePre(tree.getRoot());
		tree.delete(7);
		System.out.println();
		tree.traversePre(tree.getRoot());
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

	public boolean delete(T data) {
		if (root == null) {
			throw new IllegalArgumentException("the tree is empty");
		}

		Node<T> node = root.get(root, data);
		if (node == null) {
			return false;
		}

		if (node == root) {
			if (root.getRight() != null) {
				Node<T> right = root.getRight();
				Node<T> left = root.getLeft();
				root = right; // 根节点右孩子

				Node<T> temp = right;
				while (temp.getLeft() != null) {
				}
				temp.setLeft(left); // 将原根节点的左孩子添加到原根节点的右孩子的最左下方
				return true;
			}

			if (root.getLeft() != null) {
				root = root.getLeft();
				return true;
			}
			root = null; // 只有根节点的情况
			return true;
		}

		if (node.getParent().getData().compareTo(data) >= 0) {
			if (node.getRight() != null) {
				node.getParent().setLeft(node.getRight());
				Node<T> temp = node.getRight();
				while (temp.getLeft() != null) {
					temp = temp.getLeft();
				}
				temp.setLeft(node.getLeft());
				return true;
			}
			node.getParent().setLeft(node.getLeft());
		} else {
			if (node.getLeft() != null) {
				node.getParent().setRight(node.getLeft());
				Node<T> temp = node.getLeft();
				while (temp.getRight() != null) {
					temp = temp.getRight();
				}
				temp.setRight(node.getRight());
				return true;
			}
			node.getParent().setRight(node.getRight());
		}
		node = null;
		return true;
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

		node.setParent(this);
		return data;
	}

	public Node<T> get(Node<T> from, T data) {
		if (from == null) {
			return null;
		}

		if (from.getData() == null && data == null || from.getData().compareTo(data) == 0) {
			return from;
		}

		if (from.getData().compareTo(data) >= 0) {
			return get(from.getLeft(), data);
		}

		if (from.getData().compareTo(data) < 0) {
			return get(from.getRight(), data);
		}

		return null;
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
