package DIKBD;

import java.util.ArrayList;



public class DIKBD_Vertex {
	
	public static final int infinity = (int)Double.POSITIVE_INFINITY;
	
	private DIKBD_Edge reverseEdges;
	ArrayList<Integer> magicIndex;
	private int id;
	private DIKBD_Vertex left;
	private DIKBD_Vertex right;
	int minDist;
	int pre;
	private boolean insertedDist;
	
	
	public DIKBD_Vertex(int i) {
		id = i;
		insertedDist = false;
		minDist = infinity;
		left = this;
		right = this;
		pre = -1;
	}
	
	public int  getID()
	{
		return id;
	}
	
	public void addOutGoingEdge(DIKBD_Edge e)
	{
		if(reverseEdges!=null){
			reverseEdges.addNextCommonTailEdge(e);
		}else
			reverseEdges = e;
	}
	
	
	public DIKBD_Edge getEdges() {
		if(reverseEdges!= null){
			return reverseEdges;
		}return new DIKBD_Edge(1, this,this , -1);
	}
	
	/**
	 * Sets a min distance label
	 * @param c new min label
	 */
	public void setMinDist(int c){
		minDist = c;
	}
	
	/**
	 * This method returns the shortest path distance to this node
	 * @return Minimum distance 
	 */
	public int getMinDist(){
		return minDist;
	}
	
	/**
	 * Set a predecessor of the node
	 * @param p the new predecessor.
	 */
	public void setPre(int p){
		pre =p;
	}
	
	
	
		
	/**
	 * Unlink a vertex from the bucket
	 * @return true, if the buckets gets empty
	 */
	public boolean unLinkVertexDist(){
		if(right.getID() == id){
			left=this;
			right=this;
			return true;
		}else{
			left.setRigthDist(right);
			right.setLeftDist(left);
			left = this;
			right = this;
			return false;
		}
	}
	
	public void fastUnlinkDist(){
		left=this;
		right=this;
	}
	
	public void unlinkRighBoundDist()
	{
		right = null;
	}
	
	/**
	 * Insert a vertex in a bucket. 
	 * New vertex is inserted on the left of the bucket entrance 
	 * @param v vertex in progress to be inserted
	 */
	public void insertVertexDist(DIKBD_Vertex v) {
		v.setLeftDist(left);
		v.setRigthDist(this);
		left.setRigthDist(v);
		left = v;
	}
	
	/**
	 * Distance basic methods
	 */
	public void setLeftDist(DIKBD_Vertex v){
		left= v;
	}
	public void setRigthDist(DIKBD_Vertex v){
		right= v;
	}
	public DIKBD_Vertex getBLeftDist(){
		return left;
	}
	public DIKBD_Vertex getBRigthDist(){
		return right;
	}
	public void setInsertedDist(){
		insertedDist = true;
	}
	public boolean isInserteDist(){
		return insertedDist;
	}
	
	public void reset(){
		insertedDist = false;
	}
	
}

