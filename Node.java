package graphExploration;

import java.util.ArrayList;

public class Node {
	
	int myIndexNumber;
	String color;
	Integer predecessor;
	int distance;
	int startTimeStamp;
	int endTimeStamp;
	boolean flag[];
	ArrayList<Arc> adjacencyList = new ArrayList<Arc>();
	
	Node(int n){
		myIndexNumber = n;
	}

}
