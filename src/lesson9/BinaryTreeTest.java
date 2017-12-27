package lesson9;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insert(8);
		tree.insert(6);
		tree.insert(5);
		tree.insert(2);
		tree.insert(3);
		tree.insert(7);
		tree.insert(1);
		tree.insert(4);
		System.out.println(tree.size());
		System.out.println(tree.height());
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
		}

		if (this.data.compareTo(data) >= 0) {
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
