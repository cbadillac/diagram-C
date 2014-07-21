import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;


public class CTextView extends NodeDCView {
	private Color color = Color.blue;
	private RoundRectangle2D roundRect;
	private int xPosition;
	private int yPosition;
	private static int HEIGHT    = 100;
	private static int WIDTH     = 70;
	CText node;
	
	

	public CTextView(CText node) {
		// TODO Auto-generated constructor stub
		this.node = node;
		xPosition = 50;
		yPosition = 50;	
						
			
	}

	@Override
	void updateView(Graphics g) {
		// TODO Auto-generated method stub
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.fillRoundRect(xPosition, yPosition, WIDTH, HEIGHT, 10, 10);
		

	}

	@Override
	void setXPosition(double xPosition) {
		// TODO Auto-generated method stub
		this.xPosition = (int) xPosition;

	}

	@Override
	void setYPosition(double yPosition) {
		// TODO Auto-generated method stub
		this.yPosition = (int) yPosition;
		

	}

	@Override
	void dragTo(double x, double y) {
		// TODO Auto-generated method stub
		this.xPosition = (int) x - WIDTH/2;
		this.yPosition = (int) y - HEIGHT/2;

	}

	@Override
	boolean imHere(double x, double y) {
		if(x<xPosition + HEIGHT && x>xPosition && y>yPosition && y<yPosition + HEIGHT)
			return true;
		else
			return false;
		
	}

	@Override
	NodeDC getNode() {
		// TODO Auto-generated method stub
		return node;
	}

}
