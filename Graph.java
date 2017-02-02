package graphExploration;

public class Graph {
	
	int noOfVertex;
	Node[] node;

	Graph(int n ){
		noOfVertex = n;
		node = new Node[n];
		for(int i = 0; i < n; i++){
			node[i] = new Node(i);
			node[i].flag = new boolean[n];
		}
	}
}
