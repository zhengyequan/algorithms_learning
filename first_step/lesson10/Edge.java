package lesson10;

public class Edge<T> {
	private int weight; // 权重
	private Vertex<T> fromVertex; // 起始顶点
	private Vertex<T> toVertex; // 终止顶点

	public Edge(int weight, Vertex<T> fromVertex, Vertex<T> toVertex) {
		this.weight = weight;
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Vertex<T> getFromVertex() {
		return fromVertex;
	}

	public void setFromVertex(Vertex<T> fromVertex) {
		this.fromVertex = fromVertex;
	}

	public Vertex<T> getToVertex() {
		return toVertex;
	}

	public void setToVertex(Vertex<T> toVertex) {
		this.toVertex = toVertex;
	}

	@Override
	public String toString() {
		return "(" + fromVertex + ", " + toVertex + ")";
	}
}
