import javax.swing.JPanel;

import com.sun.corba.se.impl.orbutil.graph.Node;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.*; 
import java.awt.*;
import java.util.*;

public class RightPanel extends JPanel {

	private Diagram diagram;
	private ArrayList<NodeDCView> elements;
	public  Line2D.Double X_AXIS;  // lines to draw my world axes (singular axis, plural axes).
	
	
	/**
	 * Create the panel.
	 * @param diagram 
	 */
	
	public RightPanel(Diagram diagram) {
		super();
		this.diagram = diagram;
		X_AXIS = new Line2D.Double(5,5,5,5);
		MouseListener mListen = new MouseListener(this);
		addMouseListener(mListen);
		addMouseMotionListener(mListen);
		elements = diagram.getViewNodes();
	}
	
	public NodeDCView isHere(double x, double y){
		for(NodeDCView e: elements){
			if(e.imHere(x, y)){
				return e;
			}
		}
		return null;
	}
	
	public void repaintView(){
		repaint();
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);
  
       
//        AffineTransform old = g2d.getTransform();
//        g2.rotate(Math.toRadians(45), 225, 225);
//        //draw shape/image (will be rotated)
//        Rectangle2D rectangle = new Rectangle2D.Double(200, 200, 50, 50);
//        g2.draw(rectangle);
//        
//        g2d.setTransform(old);
//        Rectangle2D rectangle2 = new Rectangle2D.Double(20,80,50,50);
//        //things you draw after here will not be rotated 
//        g2d.setColor(Color.red);
//        g2.draw(rectangle2);
		
		
        ArrayList<NodeDCView> elements = diagram.getViewNodes();
        for (NodeDCView e:elements)
           e.updateView(g2);
		
	}
	
	public Diagram getDiagram(){
		return diagram;
	}

}
