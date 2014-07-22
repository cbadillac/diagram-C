import java.awt.Graphics;
import java.util.ArrayList;


public abstract  class NodeDC {
	
	//static String typeOne   = "typeOne";
	//static String typeTwo   = "typeTwo";
	//static String typeThree = "typeThree";
	// we'd use rather instanceof
	private NodeDC root = null;
	
	private final int myId; /* to identify each element within its category */
	
	protected NodeDC( int id){
		myId = id;
	}
	
	abstract String toC();
	abstract void updateView(Graphics g);
	
	protected int getId() {
		return myId;
	}
	
	public NodeDC getRoot() {
		return root;
	}
	public void setRoot(NodeDC root) {
		this.root = root;
	}
	

}

