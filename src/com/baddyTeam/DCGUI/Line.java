package com.baddyTeam.DCGUI;

import java.awt.*;
import java.awt.geom.Line2D;


public class Line {
	private Vector vect1;
	private Vector vect2;
	private Vector relativeVect1;
	private Vector relativeVect2;
	private Line2D line2D;
	
	private Color color;
	
	public Line(Vector v1, Vector v2, Vector rV1, Vector rV2) {
		this.vect1         = v1;
		this.vect2         = v2;
		this.relativeVect1 = rV1;
		this.relativeVect2 = rV2;
		line2D = new Line2D.Double(vect1.getX() + relativeVect1.getX() , vect1.getY() + relativeVect1.getY(), 
			    vect2.getX() + relativeVect1.getX() , vect2.getY() + relativeVect2.getY());
		
		// TODO Auto-generated constructor stub
	}
	
	void updateView(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		
		line2D.setLine(vect1.getX() + relativeVect1.getX() , vect1.getY() + relativeVect1.getY(), 
			    vect2.getX() + relativeVect2.getX() , vect2.getY() + relativeVect2.getY());
		g2.setColor(color.BLACK);
		g2.setStroke(new BasicStroke(2f));
		g2.draw(line2D);
		
//		g2.drawLine(vect1.getX() + relativeVect1.getX() , vect1.getY() + relativeVect1.getY(), 
//				    vect2.getX() + relativeVect1.getX() , vect2.getY() + relativeVect2.getY());
//		g2.setColor(color.black);

	}


}
