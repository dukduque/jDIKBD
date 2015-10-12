package DIKBD;



public class AproxBucket {
	
	private AproxBucket down;
	private AproxBucket up;
	private DIKBD_Vertex entrance;
	
	/**
	 * Key of the bucket, also is the lower bound
	 * of the bucket
	 */
	private int key;
	/**
	 * upper is the upper bound of the bucket
	 */
	private int upper;
	
	/**
	 * lower is the upper bound of the bucket
	 */
	private int lower;
	
	/**
	 * Create an instance of an aproximate bucket. If a bucket
	 * is opened, a new vertex is being added
	 * @param v
	 */
	public AproxBucket(DIKBD_Vertex v, int nKey){
		down = null;
		up = null;
		entrance = v;
		key = nKey;
		lower = key*DIKBD.Delta;
		upper = (key+1)*DIKBD.Delta-1;
	}
	
	
	/**
	 * Insert a vertex in the bucket.
	 * @param v Vertex being inserted
	 */
	public void insertVertexDist(DIKBD_Vertex v){
		//System.out.println("Entrando "+ v.getID() + " FO : " + v.getMinCost() );
		entrance.insertVertexDist(v);
	}
	/**
	 * 
	 * @return
	 */
	public AproxBucket deleteLabeledBucket() {
		if(up!=null){
			up.down = null;
			return up;
		}
		return null;
	}
	 
	public void deleteToPassDist(DIKBD_Vertex v){
		entrance = entrance.getBRigthDist();
		v.fastUnlinkDist();
	}
	
	
	
	public boolean deleteToMoveDist(DIKBD_Vertex v){
		if(entrance.getID() == v.getID()){
			entrance = entrance.getBRigthDist();
		}
		return v.unLinkVertexDist();
	}
	
	public AproxBucket deleteBucketToEmpty(){
		if(up!=null){
			up.down = null;
			return up;
		}
		return null;
	}
	
	public AproxBucket deleteBucket(){
		if(up!=null){
			up.down = down;
			if(down != null){
				down.up = up;
			}else{
				return null;
			}
		}
		else{
			if(down != null){
				down.up = null;
				return down;
			}else{
				return null;
			}
		}
		return null;
	}
	
	public int getKey(){
		return key;
	}
	
	public int getLowerBound()
	{
		return lower;
	}
	
	public int getUpperBound()
	{
		return upper;//No me gusta llamar a delta así
	}
	
	public DIKBD_Vertex getEntrance(){
		return  entrance;
	}
	public AproxBucket getUP(){
		return up;
	}
	public AproxBucket getDown(){
		return down;
	}
	public void setUP(AproxBucket v){
		up = v;
	}
	public void setDown(AproxBucket v){
		down = v;
	}
	public void turnTheBucket(){
		entrance= entrance.getBRigthDist();
	}
	
}
