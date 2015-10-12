
package DIKBD;

public class DIKBD_Edge {
	
	private int eDist;
	
	
	
	
	private DIKBD_Edge nextE;
	private int id;
	private DIKBD_Vertex source;
	private DIKBD_Vertex target;
	
	public DIKBD_Edge(int d , DIKBD_Vertex nT, DIKBD_Vertex nH, int nid) {
		// TODO Auto-generated constructor stub
		eDist = d;
		
		this.source = nT;
		this.target = nH;
		this.id = nid;
	}
	
	public void addNextCommonTailEdge(DIKBD_Edge e){
		if(nextE!= null){
			nextE.addNextCommonTailEdge(e);
		}
		else{
			nextE = e;
		}
	}

	
	public DIKBD_Edge getNext()
	{
		return nextE;
	}
	public void setNextE(DIKBD_Edge e ){
		nextE = e;
	}
	public int getWeightDist(){
		return eDist;
	}
	
	public DIKBD_Vertex getSource(){
		return source;
	}
	
	public DIKBD_Vertex getTarget(){
		return target;
	}
	public int getID()
	{
		return id;
	}
	public DIKBD_Edge findEdgebyTarget( DIKBD_Vertex targetT)
	{
		if(targetT.getID() == this.target.getID())
		{
			return this;
		}else{
			if(nextE!= null)
			{
				return nextE.findEdgebyTarget(targetT);
			}
		}
		return null;
	}
	
	
	
}
