package com.baddyTeam.DCGUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RightPanel extends JPanel {

	private Diagram diagram;
	private ArrayList<NodeDCView> elements;
	private ArrayList<Line> lines;
	
	/**
	 * Create the panel.
	 * @param diagram 
	 */

    public RightPanel(){
        super();
        this.diagram = null;

        this.elements = new ArrayList<NodeDCView>();
        this.lines    = new ArrayList<Line>();

        MouseListener mListen = new MouseListener(this);
        addMouseListener(mListen);
        addMouseMotionListener(mListen);
    }
	public RightPanel(Diagram diagram) {
		super();
		this.diagram = diagram;

        this.elements = new ArrayList<NodeDCView>();
        this.lines    = new ArrayList<Line>();

		MouseListener mListen = new MouseListener(this);
		addMouseListener(mListen);
		addMouseMotionListener(mListen);
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
        
        for (NodeDCView e:elements)
           e.updateView(g2);
        
        for (Line e:lines)
        	e.updateView(g2);
	}

    public void addViewNodes(NodeDCView nd){
        elements.add(nd);
    }
	
	public Diagram getDiagram(){
        return diagram;
    }
    public ArrayList<Line> getLines() {
        return lines;
    }

    public void setDiagram(Diagram diagram){
        this.diagram = diagram;
    }

}
