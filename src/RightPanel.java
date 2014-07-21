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
		
		
        ArrayList<NodeDCView> elements = diagram.getViewNodes();
        for (NodeDCView e:elements)
           e.updateView(g2);
		
	}
	
	public Diagram getDiagram(){
		return diagram;
	}

}
