package GraphDrawing;

import java.util.ArrayList;
import java.util.Iterator;

	public class TestingMain {
		public static void main(String [] args){
			Graph g = new Graph(5);
			Edge [] ed = new Edge[1];
			ed[0]=new Edge(1,3);
			g.addEdges(ed);
			ArrayList as = g.getNeighbours(1);
			Iterator it = as.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
		}
	}
}
