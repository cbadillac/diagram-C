import java.awt.Graphics;
import java.util.ArrayList;


public abstract  class NodeDC {
	
	static String typeOne   = "typeOne";
	static String typeTwo   = "typeTwo";
	static String typeThree = "typeThree";
	private ArrayList<NodeDC> root = null;
	
	private final int myId; /* to identify each element within its category */
	   
	   protected NodeDC( int id){
	      myId = id;
	   }
	   protected int getId() {
	      return myId;
	   }
			
	abstract String toC();
	abstract String getType();
	abstract void updateView(Graphics g);
	
	public ArrayList<NodeDC> getRoot() {
		return root;
	}
	public void setRoot(ArrayList<NodeDC> root) {
		this.root = root;
	}
	

}

