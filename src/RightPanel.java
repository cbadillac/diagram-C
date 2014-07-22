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
	private ArrayList<Line> lines;
	
	
	/**
	 * Create the panel.
	 * @param diagram 
	 */
	
	public RightPanel(Diagram diagram) {
		super();
		this.diagram = diagram;

		MouseListener mListen = new MouseListener(this);
		addMouseListener(mListen);
		addMouseMotionListener(mListen);
		elements = diagram.getViewNodes();
		lines = diagram.getLines();
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
        ArrayList<Line>lineElements = diagram.getLines();
        
        for (NodeDCView e:elements)
           e.updateView(g2);
        
        for (Line e:lineElements)
        	e.updateView(g2);
	}
	
	public Diagram getDiagram(){
		return diagram;
	}

}
