package DIKBD;



public class Bucket {
	
	private DIKBD_Vertex entrance;
	private int key;
	
	/**
	 * Create an instance of a bucket. If a bucket
	 * is opened, a new vertex is being added
	 * @param v
	 */
	public Bucket(DIKBD_Vertex v, int nKey){
		entrance = v;
		key = nKey;
	}
	
	public Bucket(int nKey){
		key = nKey;
	}
	
	
	/**
	 * Insert a vertex in the bucket.
	 * @param v Vertex being inserted
	 */
	public void insertVertexDist(DIKBD_Vertex v){
		if(entrance!=null){
			entrance.insertVertexDist(v);
		}else{
			entrance = v;
		}
	}
	
	
	/**
	 * 
	 * @param v
	 * @return
	 */
	public boolean deleteLabeledVertexDist(){
		//Delete entrance / FIFO policy 
		entrance = entrance.getBRigthDist();
		boolean emp = entrance.getBLeftDist().unLinkVertexDist();
		if(emp){
			entrance = null;
			return true;
		}
		return false;
	}
	
	public boolean deleteToMoveDist(DIKBD_Vertex v){
		if(entrance.getID() == v.getID()){
			entrance = entrance.getBRigthDist();
		}
		if(v.unLinkVertexDist()){
			entrance = null;
			return true;
		}
		return false;
	}
	
	
	public int getKey(){
		return key;
	}
	public void setKey(int nKey){
		key = nKey;
	}
	
	public DIKBD_Vertex getEntrance(){
		return  entrance;
	}
	
	public boolean empty() {
		if(entrance!=null){
			return false;
		}
		return true;
	}
}
