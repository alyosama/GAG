package GraphDrawing;

public class Edge {
	
	private int source;
	private int destination;
	
	Edge(int source,int destination){
		this.setSource(source);
		this.setDestination(destination);
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}
}
