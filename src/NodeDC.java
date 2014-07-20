import java.awt.Graphics;


public abstract class NodeDC {
	
	static String typeOne   = "typeOne";
	static String typeTwo   = "typeTwo";
	static String typeThree = "typeThree";
	
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
}

