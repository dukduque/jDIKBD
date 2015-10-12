package Examples;

import java.util.Random;

import DIKBD.DIKBD;
import DIKBD.DIKBD_Graph;
import DIKBD.DIKBD_Vertex;

public class Main_DIKBD {

	public static void main(String[] args) {
		int numNodes = 100;
		int numArcs = numNodes*6;
		int source_node = 0;
		int last_node = numNodes-1;
		DIKBD_Graph G = genRandomGraph(numNodes, numArcs, source_node, last_node);
		// Run SP algorithm
		DIKBD spDist = new DIKBD(G, source_node);
		spDist.runAlgorithm();

		// System.out.println(G.toString());
		System.out.println("SP: " + G.getShortestPathValue(last_node));
		System.out.println("Path: " + G.getShortestPath(last_node));
//		System.out.println("All paths:\n" + G.getAllPaths());

	}

	private static DIKBD_Graph genRandomGraph(int numNodes, int numArcs,int source_node, int last_node) {
		int iniArcs = Math.max(5, (int) (0.01*numNodes));
		int range = Math.max(5, (int) (0.1*numNodes));
		Random r = new Random(0);
		// Creating a graph
		DIKBD_Graph G = new DIKBD_Graph(numNodes);
		// Adding vertexes
		for (int i = 0; i < numNodes; i++) {
			G.addVertex(new DIKBD_Vertex(i));
		}
		// Adding edges (tail, head, weight, id)
		int tail, head, weigth = 0;
		// Arcs starting at the source node
		for (int i = 0; i < iniArcs; i++) {

			tail = source_node;
			head = 1 + r.nextInt(iniArcs);
			weigth = 1 + r.nextInt(10);
			G.addWeightedEdge(G.getVertexByID(tail), G.getVertexByID(head),weigth, i);
		}
		// Random arcos
		for (int i = iniArcs; i < numArcs - iniArcs; i++) {
			tail = 1 + r.nextInt(numNodes - 1);
			head = Math.max(1,Math.min((int) (tail + Math.pow(-1, 1 + r.nextInt(2))*r.nextInt(range)), numNodes - 2));
			weigth = 1 + r.nextInt(10);
			G.addWeightedEdge(G.getVertexByID(tail), G.getVertexByID(head),
					weigth, i);
		}
		// Arcs ending at the last node
		for (int i = numArcs - iniArcs; i < numArcs; i++) {
			tail = numNodes - iniArcs + r.nextInt(iniArcs);
			head = last_node;
			weigth = 1 + r.nextInt(10);
			G.addWeightedEdge(G.getVertexByID(tail), G.getVertexByID(head),weigth, i);
		}
		return G;
	}
}
