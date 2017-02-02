package graphExploration;

import java.util.Queue;

public class DriverProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph(8);
		GraphHelper.addEdgeUndirected(0, 1, g);
		GraphHelper.addEdgeUndirected(0, 4, g);
		GraphHelper.addEdgeUndirected(1, 5, g);
		GraphHelper.addEdgeUndirected(5, 2, g);
		GraphHelper.addEdgeUndirected(5, 6, g);
		GraphHelper.addEdgeUndirected(2, 3, g);
		GraphHelper.addEdgeUndirected(6, 7, g);
		GraphHelper.addEdgeUndirected(3, 7, g);
		GraphHelper.addEdgeUndirected(6, 3, g);
		GraphHelper.addEdgeUndirected(2, 6, g);
		GraphHelper.printGraph(g);
		GraphHelper.BFS(g, 2);
		GraphHelper.printPath(g, 2, 7);
		
		Graph g1 = new Graph(6);
		GraphHelper.addEdgeDirected(0, 1, g1);
		GraphHelper.addEdgeDirected(0, 3, g1);
		GraphHelper.addEdgeDirected(1, 4, g1);
		GraphHelper.addEdgeDirected(4, 3, g1);
		GraphHelper.addEdgeDirected(3, 1, g1);
		GraphHelper.addEdgeDirected(2, 4, g1);
		GraphHelper.addEdgeDirected(2, 5, g1);
		GraphHelper.addEdgeDirected(5, 5, g1);
		GraphHelper.printGraph(g1);
		GraphHelper.DFS(g1);
		
		Graph g3 = new Graph(5);
		GraphHelper.addEdgeUndirected(0, 1, g3);
		GraphHelper.addEdgeUndirected(1, 2, g3);
		GraphHelper.addEdgeUndirected(2, 3, g3);
		GraphHelper.addEdgeUndirected(1, 3, g3);
		GraphHelper.addEdgeUndirected(1, 4, g3);
		GraphHelper.addEdgeUndirected(0, 4, g3);
		Queue<Node> myQueue = GraphHelper.topologicalSort(g3);
		for(Node node : myQueue)
			System.out.print(node.myIndexNumber+1+ " ");
		
	}
	
	// Comment Portion that has been used as the starting of the test program
	// and works fine until the start of the program
	
	/*GraphHelper.addEdgeUndirected(0, 1, g);
	GraphHelper.addEdgeUndirected(0, 1, g);
	GraphHelper.addEdgeUndirected(0, 4, g);
	GraphHelper.addEdgeUndirected(0, 3, g);
	GraphHelper.addEdgeUndirected(1, 2, g);
	GraphHelper.addEdgeUndirected(1, 3, g);
	GraphHelper.addEdgeUndirected(1, 4, g);
	GraphHelper.addEdgeUndirected(2, 3, g);
	GraphHelper.addEdgeUndirected(3, 4, g);
	
	GraphHelper.printGraph(g);
	
	GraphHelper.removeUndirected(1, 4, g);
	
	GraphHelper.printGraph(g);
	
	GraphHelper.addEdgeUndirected(1, 4, g);
	
	GraphHelper.printGraph(g);*/
	
	/* This is a sort of topological sort. This is correct.
	 * Queue<Node> myQueue = GraphHelper.topologicalSort(g3);
		for(Node node : myQueue)
			System.out.print(node.myIndexNumber+ " ");
	 */

}
