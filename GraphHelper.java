package graphExploration;

import java.util.LinkedList;
import java.util.Queue;

public class GraphHelper {
	
	static void addEdgeUndirected(int source, int dest, Graph g){
		
		// This function help in the addition of the edge from source to destination 
		// as well as the destination to the source
		if(checkEdge(source, dest, g)){
			return;
		}else{
		    Arc newArc = new Arc();
		    newArc.nodePtr = g.node[dest];
		    g.node[source].adjacencyList.add(newArc);
		    g.node[source].flag[dest] = true;
		    
		    Arc newArc2 = new Arc();
			newArc2.nodePtr = g.node[source];
			g.node[dest].adjacencyList.add(newArc2);
		}
	}
	
	static void addEdgeDirected(int source, int dest, Graph g){
		// This function help in the addition of the directed edge to the graph
		if(checkEdge(source, dest, g)){
			return;
		}else{
			Arc newArc = new Arc();
			newArc.nodePtr = g.node[dest];
			g.node[source].adjacencyList.add(newArc);
		}	
	}
	
	static void printGraph(Graph g){
		// This function is add for the printing the adjacency list of the graph
		for(int i = 0; i < g.noOfVertex; i++){
			System.out.print("Adjacency List of the node " + i + " is : ");
			for(int j = 0; j < g.node[i].adjacencyList.size(); j++){
				System.out.print(g.node[i].adjacencyList.get(j).nodePtr.myIndexNumber+ " ");
			}
			System.out.println();
		}
	}
	
	static boolean checkEdge(int source, int dest, Graph g){
		// return true if the edge exist between the source node and the destination node
		if(g.node[source].flag[dest])
			return true;
		return false;
	}

	static void removeUndirected(int source, int dest, Graph g){
		// remove an edge from an undirected graph by setting the flag to false and 
		// removing that from the adjacency list.
		int temp = scanAdj(source, dest, g);
		g.node[source].flag[g.node[source].adjacencyList.get(temp).nodePtr.myIndexNumber] = false;
		g.node[source].adjacencyList.remove(temp);
		temp = scanAdj(dest, source, g);
		g.node[dest].flag[g.node[dest].adjacencyList.get(temp).nodePtr.myIndexNumber] = false;
		g.node[dest].adjacencyList.remove(temp);
	}
	
	static int scanAdj(int source, int dest, Graph g){
		// return the index of the adjacency List of the source containing destination.
		for(int i = 0; i < g.node[source].adjacencyList.size();i++){
			if(g.node[source].adjacencyList.get(i).nodePtr.myIndexNumber == dest){
				return i;
			}
		}
		return 0;
	}
	
	static void removeDirected(int source, int dest, Graph g){
		// remove an edge from a directed graph.
		int temp = scanAdj(source, dest, g);
		g.node[source].flag[g.node[source].adjacencyList.get(temp).nodePtr.myIndexNumber] = false;
		g.node[source].adjacencyList.remove(temp);
	}

	static void BFS(Graph g, int source){
		
		// Initialize all the nodes with the initial distance as infinity
		// and the predecessor as nil and color as white
		
		initializeBFS(g, source);
		g.node[source].color = "Gray";
		g.node[source].distance = 0;
		g.node[source].predecessor = null;
		
		Queue<Node> myQueue = new LinkedList<Node>();
		myQueue.add(g.node[source]);
		
		while(myQueue.isEmpty() == false){
			Node temp = myQueue.poll();
			for(int i = 0; i < temp.adjacencyList.size(); i++){
				Node xTemp = temp.adjacencyList.get(i).nodePtr;
				if(xTemp.color.equals("White")){
					xTemp.color = "Gray";
					xTemp.distance = temp.distance+1;
					xTemp.predecessor = temp.myIndexNumber;
					myQueue.add(g.node[xTemp.myIndexNumber]);
				}
			}
			temp.color = "Black";
		}
	}
	
	static void initializeBFS(Graph g, int source){
		
		// Initialize all the nodes with the initial distance as infinity
		// and the predecessor as nil and color as white
		for(int i = 0; i < g.noOfVertex; i++){
			if(g.node[i].myIndexNumber == source)
				continue;
			g.node[i].color = "White";
			g.node[i].distance = (int) Double.POSITIVE_INFINITY;
			g.node[i].predecessor = null;
		}
	}

    static int DFS_visit(Node u, int time){
    	u.color = "Gray";
    	time = time + 1;
    	u.startTimeStamp = time;
    	for(int i = 0; i < u.adjacencyList.size(); i++){
    		Node temp = u.adjacencyList.get(i).nodePtr;
    		if(temp.color.equals("White")){
    			temp.predecessor = u.myIndexNumber;
    			time = DFS_visit(temp,time);
    		}
    	}
    	u.color = "Black";
    	time = time +1;
    	u.endTimeStamp = time;
    	return time;
    }

    static void printPath(Graph g, int source, int destination ){
    	
    	// This function is used to print the path between the source to destination
    	if(source == destination){
    		System.out.print(source);
    	}else{
    		if(g.node[destination].predecessor == null)
    			System.out.println("No path exist from "+ source + " to " + destination + " exist.");
    		else{
    			printPath(g,source, g.node[destination].predecessor);
    		    System.out.print(destination);
    		}
    	}
    	
    }

    static void DFS(Graph g){
    	initializeDFS(g);
    	int time = 0;
    	for(int i = 0; i < g.noOfVertex; i++){
    		if(g.node[i].color.equals("White")){
    			time = DFS_visit(g.node[i], time);
    		}
    	}
    }

    static void initializeDFS(Graph g){
    	for(int i = 0; i < g.noOfVertex; i++){
    		g.node[i].color = "White";
    		g.node[i].predecessor = null;
    	}
    }
    
    static Queue<Node> topologicalSort(Graph g){
    	Queue<Node> topSort = new LinkedList<Node>();
    	DFS(g,topSort);
    	return topSort;
    }
    
    static void DFS(Graph g, Queue<Node> topSort){
    	initializeDFS(g);
    	int time = 0;
    	for(int i = 0; i < g.noOfVertex; i++){
    		if(g.node[i].color.equals("White")){
    			time = DFS_visit(g.node[i], time, topSort);
    		}
    	}
    }
    
    static int DFS_visit(Node u, int time, Queue<Node> topSort){
    	u.color = "Gray";
    	time = time + 1;
    	u.startTimeStamp = time;
    	for(int i = 0; i < u.adjacencyList.size(); i++){
    		Node temp = u.adjacencyList.get(i).nodePtr;
    		if(temp.color.equals("White")){
    			temp.predecessor = u.myIndexNumber;
    			time = DFS_visit(temp,time,topSort);
    		}
    	}
    	u.color = "Black";
    	time = time +1;
    	u.endTimeStamp = time;
    	topSort.add(u);
    	return time;
    }

}
