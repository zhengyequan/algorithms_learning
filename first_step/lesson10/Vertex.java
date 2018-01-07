package lesson10;

public class Vertex<T> {
	private T data; // 值
	private int inDegree; // 入度
	private int outDegree; // 出度
	private int parent; // 父节点
	private int priority; // 优先级
	private boolean visited;

	public Vertex(T data) {
		this.data = data;
		this.parent = -1;
		this.priority = Integer.MAX_VALUE;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getInDegree() {
		return inDegree;
	}

	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}

	public int getOutDegree() {
		return outDegree;
	}

	public void setOutDegree(int outDegree) {
		this.outDegree = outDegree;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return this.data + "";
	}
}
