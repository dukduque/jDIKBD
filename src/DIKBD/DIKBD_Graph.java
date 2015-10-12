package DIKBD;

import java.util.Collection;
import java.util.Set;

import org.jgrapht.EdgeFactory;
import org.jgrapht.Graph;

public class DIKBD_Graph  implements Graph<DIKBD_Vertex, DIKBD_Edge> {

	
	static DIKBD_Vertex[] vertexes;
	
	private int numNodes;
	private int Cd;
	private int root;

	
	public DIKBD_Graph( int numNodes) {
		super();
		this.numNodes = numNodes;
		Cd=0;
		vertexes = new DIKBD_Vertex[numNodes];
	}
	
	public  int getNumNodes()
	{
		return numNodes;
	}
	/**
	 * Return a vertex given an ID	
	 * @param id ID of the node to be returned
	 * @return The corresponding {@link DIKBD_Vertex} to the id
	 */
	public DIKBD_Vertex getVertexByID(int id){
		return vertexes[id];
	}
	
	/**
	 * Adds a weighted edge to the graph
	 * @param sourceVertex Source vertex
	 * @param targetVertex Tail vertext
	 * @param d distance or weight of the edge
	 * @param id Edge ID
	 * @return 
	 */
	public DIKBD_Edge addWeightedEdge(DIKBD_Vertex sourceVertex, DIKBD_Vertex targetVertex, int arcCost, int id) {
		if(arcCost>Cd){
			Cd=arcCost;
		}
		vertexes[sourceVertex.getID()].addOutGoingEdge(new DIKBD_Edge(arcCost,sourceVertex,targetVertex, id));
		return null;
	}
	
	
	/**
	 * Not used
	 */
	@Override
	public DIKBD_Edge addEdge(DIKBD_Vertex sourceVertex, DIKBD_Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not used
	 */
	@Override
	public boolean addEdge(DIKBD_Vertex sourceVertex, DIKBD_Vertex targetVertex, DIKBD_Edge e) {
		return false;
	}
	/**
	 * Adds a vertex in the graph
	 */
	@Override
	public boolean addVertex(DIKBD_Vertex v) {
		vertexes[v.getID()] = v;
		return true;
	}
	/**
	 * not used
	 */
	@Override
	public boolean containsEdge(DIKBD_Vertex sourceVertex,
			DIKBD_Vertex targetVertex) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not used
	 */
	@Override
	public boolean containsEdge(DIKBD_Edge e) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not used
	 */
	@Override
	public boolean containsVertex(DIKBD_Vertex v) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not used
	 */
	@Override
	public Set<DIKBD_Edge> edgeSet() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not used
	 */
	@Override
	public Set<DIKBD_Edge> edgesOf(DIKBD_Vertex vertex) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not used
	 */
	@Override
	public Set<DIKBD_Edge> getAllEdges(DIKBD_Vertex sourceVertex,
			DIKBD_Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not used
	 */
	@Override
	public DIKBD_Edge getEdge(DIKBD_Vertex sourceVertex, DIKBD_Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not used
	 */
	@Override
	public EdgeFactory<DIKBD_Vertex, DIKBD_Edge> getEdgeFactory() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not used
	 */
	@Override
	public DIKBD_Vertex getEdgeSource(DIKBD_Edge e) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not used
	 */
	@Override
	public DIKBD_Vertex getEdgeTarget(DIKBD_Edge e) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not used
	 */
	@Override
	public double getEdgeWeight(DIKBD_Edge e) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Not used
	 */
	@Override
	public boolean removeAllEdges(Collection<? extends DIKBD_Edge> edges) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not used
	 */
	@Override
	public Set<DIKBD_Edge> removeAllEdges(DIKBD_Vertex sourceVertex,
			DIKBD_Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not used
	 */
	@Override
	public boolean removeAllVertices(Collection<? extends DIKBD_Vertex> vertices) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not used
	 */
	@Override
	public DIKBD_Edge removeEdge(DIKBD_Vertex sourceVertex,
			DIKBD_Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not used
	 */
	@Override
	public boolean removeEdge(DIKBD_Edge e) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not used
	 */
	@Override
	public boolean removeVertex(DIKBD_Vertex v) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not used
	 */
	@Override
	public Set<DIKBD_Vertex> vertexSet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Returns the value of the higher cost in the graph
	 * @return
	 */
	public int getCd()
	{
		return Cd;
	}
	/**
	 * Obtain the path from the node given in the DIKBD SP
	 * to an specified node.
	 * @param endNode the node at where we ask the sp
	 * @return a string of the path
	 */
	public String getShortestPath(int endNode){
		if(endNode<0)
			return "Unreached";
		String p = endNode+"";
		if(endNode == root)
			return p;
		else{
			if(vertexes[endNode].pre<0)
				return "Node "+ endNode +" is unreachable";
			return getShortestPath(vertexes[endNode].pre)+" , "+ p;
		}
	}
	/**
	 * Returns the objective function of the shortest path given as a parameter
	 * @param endNode End node of the path
	 * @return objective function value of the SP
	 */
	public int getShortestPathValue(int endNode){
		return getVertexByID(endNode).getMinDist();
	}
	
	public String toString() {

		String nodesS = "";
		String edgesS = "";
		for (int i = 0; i < vertexes.length; i++) {
			nodesS += (", " + i);
			DIKBD_Edge e = vertexes[i].getEdges();
			while (e != null) {
				edgesS += (", ("+e.getSource().getID() +" , "+e.getTarget().getID() +")=" +e.getWeightDist());
				e = e.getNext();
			}
		}
		nodesS = nodesS.replaceFirst(", ", "");
		edgesS = edgesS.replaceFirst(", ", "");
		return "["+nodesS+"]\n"+ "["+edgesS+"]\n";
	}

	/**
	 * Creates and returns a String representation of the paths to every node
	 * @return All the path from the root node
	 */
	public String getAllPaths() {
		String retorno="";
		for(int v_i = 0 ; v_i<numNodes ; v_i++){
			if(vertexes[v_i].pre!=-1)
			retorno += "TO:"+ v_i + ": " +  getShortestPath(v_i)+"\n";
			else if(v_i == root)
			retorno += "TO:"+ v_i + ": " +  "root\n";
			else
			retorno += "TO:"+ v_i + ": " +  "unreached\n";
		}
		
		return retorno;
	}
	
	/**
	 * Sets the root node
	 * @param nR
	 */
	public void setRoot(int nR) {
		root = nR;
	}
	
}
