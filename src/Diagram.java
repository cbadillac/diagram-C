import java.util.ArrayList;


public class Diagram {
	private ArrayList<NodeDC> nodes;
	private ArrayList<NodeDCView> viewNodes;
	private ArrayList<NodeDC> root;
	
	public Diagram() {
		nodes     = new ArrayList<NodeDC>();
		viewNodes = new ArrayList<NodeDCView>(); 
		root = new ArrayList<NodeDC>();
		
				
	}
	
	public void addNodes(NodeDC nd){
		nodes.add(nd);
	}
	
	public void addViewNodes(NodeDCView nd){
		viewNodes.add(nd);
	}
	public ArrayList<NodeDC> getNodes(){
		return nodes;
	}
	
	public ArrayList<NodeDCView> getViewNodes(){
		return viewNodes;
	}

	public ArrayList<NodeDC> getRoot() {
		return root;
	}
	


}
