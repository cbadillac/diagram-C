package com.baddyTeam.DCGUI;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;


public class CTextView extends NodeDCView {
	private Color color = Color.blue;
	private RoundRectangle2D roundRect;
	private static int HEIGHT    = 100;
	private static int WIDTH     = 70;
	CText node;
	
	

	public CTextView(CText node) {
		// TODO Auto-generated constructor stub
		super(50, 50, WIDTH, HEIGHT);
		this.node = node;					
			
	}

	@Override
	void updateView(Graphics g) {
		// TODO Auto-generated method stub
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.fillRoundRect(getXPosition(), getYPosition(), WIDTH, HEIGHT, 10, 10);
		

	}

	@Override
	boolean imHere(double x, double y) {
		if(x<getXPosition() + WIDTH && x>getXPosition() && y>getYPosition() && y<getYPosition() + HEIGHT)
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
