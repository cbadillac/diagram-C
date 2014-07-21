import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public class VarSentenceView extends NodeDCView {
	
	private double xPosition;
	private double yPosition;
	
	private Color color  = Color.GREEN;
	private Rectangle2D rectangle;
	private VarSentence node;
	private static double HEIGHT    = 50;
	private static double WIDTH     = 80;

	public VarSentenceView(VarSentence node) {
		// TODO Auto-generated constructor stub
		xPosition = 50;
		yPosition = 50;
		this.node = node;
		rectangle = new Rectangle2D.Double(xPosition, yPosition, HEIGHT, WIDTH);
	}

	@Override
	void updateView(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		rectangle.setFrame(xPosition,yPosition, WIDTH, HEIGHT);
		g2.setColor(color);
		g2.fill(rectangle);

	}

	@Override
	void setXPosition(double xPosition) {
		this.xPosition = xPosition;


	}

	@Override
	void setYPosition(double yPosition) {
		// TODO Auto-generated method stub
		this.yPosition = yPosition;

	}

	@Override
	void dragTo(double x, double y) {
		// TODO Auto-generated method stub		
		this.xPosition = x - WIDTH/2;
		this.yPosition = y - HEIGHT/2;

	}

	@Override
	boolean imHere(double x, double y) {
		// TODO Auto-generated method stub
		if(x<rectangle.getMaxX() && x>rectangle.getMinX() && y>rectangle.getMinY() && y<rectangle.getMaxY())
			return true;
		else
			return false;
	}
	
	public VarSentence getNode(){
		return node;
	}

}
