package com.baddyTeam.DCGUI;

import java.awt.*;
import java.awt.geom.Rectangle2D;


public class VarSentenceView extends NodeDCView {
		
	private Color color  = Color.GREEN;
	private Rectangle2D rectangle;
	private VarSentence node;
	private static int HEIGHT    = 50;
	private static int WIDTH     = 80;

	public VarSentenceView(VarSentence node) {
		super(50, 50, WIDTH, HEIGHT);
		// TODO Auto-generated constructor stub
		this.node = node;
		rectangle = new Rectangle2D.Double(getXPosition(), getYPosition(), HEIGHT, WIDTH);
	}

	@Override
	void updateView(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		rectangle.setFrame(getXPosition(),getYPosition(), WIDTH, HEIGHT);
		g2.setColor(color);
		g2.fill(rectangle);

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
