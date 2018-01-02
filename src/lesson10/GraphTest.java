package lesson10;

import java.util.List;

public class GraphTest {
	public static void main(String[] args) {
		testSingleShortestPath();
	}

	public static void DFSTest() {
		GraphMatrix<String> g = new GraphMatrix<String>();
		g.setDirected(true);
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		g.addVertex("H");
		g.addVertex("I");

		g.addEdge(g.getVertex(0), g.getVertex(1));
		g.addEdge(g.getVertex(0), g.getVertex(5));
		g.addEdge(g.getVertex(1), g.getVertex(2));
		// g.addEdge(g.getVertex(1), g.getVertex(6));
		g.addEdge(g.getVertex(1), g.getVertex(8));
		g.addEdge(g.getVertex(2), g.getVertex(3));
		g.addEdge(g.getVertex(2), g.getVertex(8));
		g.addEdge(g.getVertex(3), g.getVertex(4));
		// g.addEdge(g.getVertex(3), g.getVertex(6));
		g.addEdge(g.getVertex(3), g.getVertex(7));
		g.addEdge(g.getVertex(3), g.getVertex(8));
		g.addEdge(g.getVertex(4), g.getVertex(5));
		g.addEdge(g.getVertex(4), g.getVertex(7));
		// g.addEdge(g.getVertex(5), g.getVertex(6));
		// g.addEdge(g.getVertex(6), g.getVertex(7));

		g.resetVertexStatus();
		for (int i = 0; i < g.getNumOfVertexes(); i++) {
			Vertex<String> v = g.getVertex(i);
			if (!v.isVisited()) {
				g.DFSTraverse(v);
			}
		}
	}

	public static void BFSTest() {
		GraphMatrix<String> g = new GraphMatrix<String>();
		g.setDirected(true);
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");

		g.addEdge(g.getVertex(0), g.getVertex(1));
		g.addEdge(g.getVertex(0), g.getVertex(3));
		g.addEdge(g.getVertex(0), g.getVertex(4));
		g.addEdge(g.getVertex(1), g.getVertex(2));
		g.addEdge(g.getVertex(1), g.getVertex(4));
		g.addEdge(g.getVertex(2), g.getVertex(4));
		g.addEdge(g.getVertex(4), g.getVertex(5));

		g.resetVertexStatus();
		for (int i = 0; i < g.getNumOfVertexes(); i++) {
			Vertex<String> v = g.getVertex(i);
			if (!v.isVisited()) {
				g.BFSTraverse(v);
			}
		}
	}

	public static void testMST() {
		GraphMatrix<String> g = new GraphMatrix<String>();
		g.setDirected(true);
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		g.addEdge(new Edge<String>(7, g.getVertex(0), g.getVertex(1)));
		g.addEdge(new Edge<String>(5, g.getVertex(0), g.getVertex(3)));
		g.addEdge(new Edge<String>(8, g.getVertex(1), g.getVertex(2)));
		g.addEdge(new Edge<String>(9, g.getVertex(1), g.getVertex(3)));
		g.addEdge(new Edge<String>(7, g.getVertex(1), g.getVertex(4)));
		g.addEdge(new Edge<String>(5, g.getVertex(2), g.getVertex(4)));
		g.addEdge(new Edge<String>(15, g.getVertex(3), g.getVertex(4)));
		g.addEdge(new Edge<String>(6, g.getVertex(3), g.getVertex(5)));
		g.addEdge(new Edge<String>(8, g.getVertex(4), g.getVertex(5)));
		g.addEdge(new Edge<String>(9, g.getVertex(4), g.getVertex(6)));
		g.addEdge(new Edge<String>(11, g.getVertex(5), g.getVertex(6)));

		List<Edge<String>> mstEdges = g.MST(g.getVertex(3));
		int weight = 0;
		for (Edge<String> e : mstEdges) {
			weight += e.getWeight();
		}
		System.out.println(mstEdges);
		System.out.println(weight);
	}

	public static void testSingleShortestPath() {
		GraphMatrix<String> g = new GraphMatrix<String>();
		g.setDirected(true);
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		g.addVertex("H");
		g.addVertex("I");

		g.addEdge(g.getVertex(0), g.getVertex(1));
		g.addEdge(g.getVertex(0), g.getVertex(5));
		g.addEdge(g.getVertex(1), g.getVertex(2));
		g.addEdge(g.getVertex(1), g.getVertex(6));
		g.addEdge(g.getVertex(1), g.getVertex(8));
		g.addEdge(g.getVertex(2), g.getVertex(3));
		g.addEdge(g.getVertex(2), g.getVertex(8));
		// g.addEdge(g.getVertex(3), g.getVertex(4));
		g.addEdge(g.getVertex(3), g.getVertex(6));
		g.addEdge(g.getVertex(3), g.getVertex(7));
		g.addEdge(g.getVertex(3), g.getVertex(8));
		// g.addEdge(g.getVertex(4), g.getVertex(5));
		// g.addEdge(g.getVertex(4), g.getVertex(7));
		g.addEdge(g.getVertex(5), g.getVertex(6));
		g.addEdge(g.getVertex(6), g.getVertex(7));

		g.singleShortestPath(g.getVertex(0));
	}
}
