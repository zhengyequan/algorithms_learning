package lesson10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class GraphMatrix<T> {
	private List<Vertex<T>> vertexes; // 顶点表
	private List<Edge<T>> edges; // 边表
	private boolean directed; // 是否是有向图

	public GraphMatrix() {
		vertexes = new ArrayList<Vertex<T>>();
		edges = new ArrayList<Edge<T>>();
	}

	/** 顶点操作 */
	// 添加顶点
	public T addVertex(T data) {
		Vertex<T> v = new Vertex<T>(data);
		vertexes.add(v);
		return v.getData();
	}

	// 获取指定位置的边
	public Vertex<T> getVertex(int i) {
		return vertexes.get(i);
	}

	// 删除顶点v，注意删除顶点的同时，该顶点存在边，则边也要删除
	public boolean removeVertex(Vertex<T> v) {
		Iterator<Edge<T>> iterate = edges.iterator();
		while (iterate.hasNext()) {
			Edge<T> edge = iterate.next();
			if (edge.getFromVertex() == v || edge.getToVertex() == v) {
				iterate.remove();
			}
		}
		return vertexes.remove(v);
	}

	public List<Vertex<T>> getVertexes() {
		return vertexes;
	}

	public int getNumOfVertexes() {
		return vertexes.size();
	}

	/** 边操作 */
	// 添加边
	public void addEdge(Vertex<T> u, Vertex<T> v) {
		Edge<T> e = new Edge<T>(0, u, v);
		edges.add(e);
	}

	// 添加边
	public void addEdge(Edge<T> e) {
		edges.add(e);
	}

	// 获取指定位置的边
	public Edge<T> getEdge(Vertex<T> u, Vertex<T> v) {
		for (int i = 0; i < edges.size(); i++) {
			Edge<T> edge = edges.get(i);
			if (isDirected()) {
				if (edge.getFromVertex() == u && edge.getToVertex() == v) {
					edges.remove(i);
					return edge;
				}
			} else {
				if (edge.getFromVertex() == u && edge.getToVertex() == v
						|| edge.getFromVertex() == v && edge.getToVertex() == u) {
					edges.remove(i);
					return edge;
				}
			}
		}
		return null;
	}

	// 删除顶点u、v之间的边：区分有向图和无向图
	public boolean removeEdge(Vertex<T> u, Vertex<T> v) {
		for (int i = 0; i < edges.size(); i++) {
			Edge<T> edge = edges.get(i);
			if (isDirected()) {
				if (edge.getFromVertex() == u && edge.getToVertex() == v) {
					edges.remove(i);
					return true;
				}
			} else {
				if (edge.getFromVertex() == u && edge.getToVertex() == v
						|| edge.getFromVertex() == v && edge.getToVertex() == u) {
					edges.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	public List<Edge<T>> getEdges() {
		return edges;
	}

	public int getNumOfEdges() {
		return edges.size();
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	// 深度优先搜索
	public void DFSTraverse(Vertex<T> v) {
		if (v == null || v.isVisited()) {
			return;
		}

		v.setVisited(true);
		System.out.print(v.getData() + ", ");
		for (int i = 0; i < edges.size(); i++) {
			Edge<T> e = edges.get(i);
			if (e.getFromVertex() == v) {
				DFSTraverse(e.getToVertex());
			}

			if (!isDirected() && e.getToVertex() == v) {
				DFSTraverse(e.getFromVertex());
			}
		}
	}

	// 广度优先搜索
	public void BFSTraverse(Vertex<T> v) {
		if (v == null) {
			return;
		}

		Queue<Vertex<T>> queue = new LinkedBlockingQueue<Vertex<T>>();
		queue.offer(v);

		Iterator<Vertex<T>> it = queue.iterator();
		while (it.hasNext()) {
			Vertex<T> item = it.next();
			if (item.isVisited()) {
				continue;
			}

			System.out.print(item.getData() + ", ");
			item.setVisited(true);
			it.remove();
			BFS(item, queue);
			it = queue.iterator();
		}
	}

	private void BFS(Vertex<T> v, Queue<Vertex<T>> queue) {
		for (int i = 0; i < edges.size(); i++) {
			Edge<T> e = edges.get(i);
			if (e.getFromVertex() == v) {
				queue.offer(e.getToVertex());
			}

			if (!isDirected() && e.getToVertex() == v) {
				queue.offer(e.getFromVertex());
			}
		}
	}

	// 最小生成树
	@SuppressWarnings("unchecked")
	public List<Edge<T>> MST(Vertex<T> v) {
		List<Edge<T>> mstEdges = new ArrayList<Edge<T>>();
		List<Vertex<T>> mstVertexes = new ArrayList<Vertex<T>>();
		mstVertexes.add(v);
		v.setVisited(true);

		while (mstVertexes.size() < vertexes.size()) {
			int weight = Integer.MAX_VALUE;
			Edge<T> tempEdge = null;
			Vertex<T> tempVertex = null;
			for (Vertex<T> item : mstVertexes) {
				Map<String, Object> minWeight = getMinWeightEdge(item);
				Edge<T> minWeightEdge = (Edge<T>) minWeight.get("minWeightEdge");
				if (minWeightEdge == null) {
					continue;
				}

				if (minWeightEdge.getWeight() < weight) {
					weight = minWeightEdge.getWeight();
					tempEdge = minWeightEdge;
					tempVertex = (Vertex<T>) minWeight.get("minWeightVertex");
				}
			}

			if (tempEdge != null) {
				mstEdges.add(tempEdge);
			}

			if (tempVertex != null) {
				mstVertexes.add(tempVertex);
				tempVertex.setVisited(true);
			}
		}

		return mstEdges;
	}

	private Map<String, Object> getMinWeightEdge(Vertex<T> v) {
		int weight = Integer.MAX_VALUE;
		Edge<T> minWeightEdge = null;
		Vertex<T> minWeightVertex = null;
		for (int i = 0; i < edges.size(); i++) {
			Edge<T> e = edges.get(i);
			if (e.getFromVertex() == v && e.getWeight() < weight && !e.getToVertex().isVisited()) {
				minWeightVertex = e.getToVertex();
				minWeightEdge = e;
				weight = e.getWeight();
			}

			if (e.getToVertex() == v && e.getWeight() < weight && !e.getFromVertex().isVisited()) {
				minWeightVertex = e.getFromVertex();
				minWeightEdge = e;
				weight = e.getWeight();
			}
		}

		// 最短边的顶点和边
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("minWeightVertex", minWeightVertex);
		result.put("minWeightEdge", minWeightEdge);
		return result;
	}

	// 单源最短路径
	public void singleShortestPath(Vertex<T> v) {
		for (Vertex<T> item : vertexes) {
			if (item == v) {
				continue;
			}

			int shortestDis = innerShortestPath(v, item);
			System.out.println("distance (" + v.getData() + ", " + item.getData() + ") = " + shortestDis);
		}
	}

	private int innerShortestPath(Vertex<T> v1, Vertex<T> v2) {
		if (v2 == v1) {
			return 0;
		}

		// v1的邻接顶点距离终点v2的距离
		Map<Vertex<T>, Integer> map = new HashMap<Vertex<T>, Integer>();
		for (Edge<T> e : edges) {
			if (e.getFromVertex() == v1) {
				map.put(e.getToVertex(), innerShortestPath(e.getToVertex(), v2));
			}
		}

		// 如果v1没有邻接顶点能抵达终点v2，则v1距离终点v2也是无穷远
		if (map.isEmpty()) {
			return Integer.MAX_VALUE;
		}

		// 找出邻接顶点中距离终点最小的顶点
		int min = Integer.MAX_VALUE;
		Set<Vertex<T>> vertexSet = map.keySet();
		for (Vertex<T> item : vertexSet) {
			min = map.get(item) < min ? map.get(item) : min;
		}

		return min < Integer.MAX_VALUE ? (min + 1) : Integer.MAX_VALUE;
	}

	// 重置顶点为未曾被访问状态
	public void resetVertexStatus() {
		for (int i = 0; i < vertexes.size(); i++) {
			vertexes.get(i).setVisited(false);
		}
	}

}
