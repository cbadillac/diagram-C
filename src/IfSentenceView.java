import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;

import sun.org.mozilla.javascript.internal.ast.WithStatement;

public class IfSentenceView extends NodeDCView {
	private Color color  = Color.RED;
	private Rectangle2D rectangle;
	private double xPosition;
	private double yPosition;
	private static double HEIGHT    = 50;
	private static double WIDTH     = 50;
	
	public IfSentenceView() {
		
		xPosition = 50;
		yPosition = 50;
		rectangle = new Rectangle2D.Double(xPosition, yPosition, HEIGHT, WIDTH);
		
		// TODO Auto-generated constructor stub
	}
	
	public void setXPosition(double xPosition){
		this.xPosition = xPosition;
	}
	
	public void setYPosition(double yPosition){
		this.yPosition = yPosition;
	}
	
	public void dragTo(double x, double y){
		this.xPosition = x - WIDTH/2;
		this.yPosition = y - HEIGHT/2;
		
	}
	
	public void updateView(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		rectangle.setFrame(xPosition,yPosition, WIDTH, HEIGHT);
		g2.setColor(color);
		AffineTransform old = g2.getTransform();
        g2.rotate(Math.toRadians(45), rectangle.getCenterX(), rectangle.getCenterY());
        //draw shape/image (will be rotated)
        g2.fill(rectangle);
        g2.setTransform(old);
        
        
       
	}

	@Override
	boolean imHere(double x, double y) {
		if(x<rectangle.getMaxX() && x>rectangle.getMinX() && y>rectangle.getMinY() && y<rectangle.getMaxY())
			return true;
		else
			return false;
	}

}
