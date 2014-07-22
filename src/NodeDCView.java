import java.awt.Graphics;


public abstract class NodeDCView implements Cloneable {

	abstract void updateView(Graphics g);
	abstract void setXPosition(double xPosition);
	abstract void setYPosition(double yPosition);
	abstract void dragTo(double x, double y);
	abstract boolean imHere(double x, double y);
	abstract NodeDC getNode();
	
	public NodeDCView clone(){
		try {
            return (NodeDCView) super.clone();
        } catch (CloneNotSupportedException e) {        
            e.printStackTrace();
            throw new RuntimeException();
        }
	}
}
