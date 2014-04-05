package GraphDrawing;

import java.util.ArrayList;

public class Graph {
	
	/*/////////////////////////////////////////////////////
	 *
	 *	this class is the Graph API for GAG.
	 *
	 *		_1___2___3__
	 *	1	|1	 1   1
	 *	2	|1	 0   0
	 *	3	|0	 1	 0
	 *
	 *	the graph is represented in an array like this.
	 *
	 *////////////////////////////////////////////////////

	private boolean[][] graph;
	private int noOfNodes;
	
	/**
	 * Instantiate a new graph.
	 * @param noOfNodes Number of Nodes in graph.
	 */
	Graph(int noOfNodes){
		this.noOfNodes=noOfNodes;
		graph = new boolean[noOfNodes][noOfNodes];
	}
	
	/**
	 * Get Neighbors of some Node.
	 * @param Node The node to find its neighbors.
	 * @return ArrayList with the neighbors of the given Node.
	 */
	public ArrayList<Integer> getNeighbours(int Node){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int i;
		for (i=0; i < noOfNodes; i++){
			if(graph[Node][i]==true)
				ret.add(i);
		}
		return ret;
	}
	
	/**
	 * add some edges.
	 * @param edges Array of Edges to add.
	 */
	public void addEdges(Edge[] edges){
		int i;
		
		for(i=0;i<edges.length;i++){
			/* error handling */
			graph[edges[i].getSource()][edges[i].getDestination()]=true;
		}
	}
	
	/**
	 * Remove some edges.
	 * @param edges
	 */
	public void removeEdges(Edge[] edges){
		int i;
		
		for(i=0;i<edges.length;i++){
			/* error handling */
			graph[edges[i].getSource()][edges[i].getDestination()]=false;
		}
	}
	
	/**
	 * Print the whole graph for debugging.
	 */
	public void printGraph(){
		int i,j;
		
		for (i = 0 ; i < noOfNodes ; i++) {
			for ( j = 0 ; j<noOfNodes ; j++)
				System.out.print(graph[i][j]+"\t");
			System.out.println("\n");
		}
	}
	
}
