package com.baddyTeam.DCGUI;

import java.awt.*;


public abstract class NodeDCView implements Cloneable {
	
	private Vector vector;
	private int WIDTH;
	private int HEIGHT;
	
	abstract void updateView(Graphics g);

	abstract boolean imHere(double x, double y);
	abstract NodeDC getNode();
	
	public NodeDCView(int x, int y,int WIDTH,int HEIGHT){
		vector = new Vector(x, y);
		this.HEIGHT = HEIGHT;
		this.WIDTH = WIDTH;
	}
	
	public int getXPosition(){
		return vector.getX();
	}
	
	public void setXPosition(int x){
		vector.setX(x);
	}
	
	public int getYPosition(){
		return vector.getY();
	}
	
	public void setYPosition(int y){
		vector.setY(y);
	}
	
	public void dragTo(int x, int y){
		vector.setX(x - WIDTH/2);
		vector.setY(y - HEIGHT/2);
	}
	
	public Vector getVector(){
		return vector;
	}
	
	public NodeDCView clone(){
		try {
            return (NodeDCView) super.clone();
        } catch (CloneNotSupportedException e) {        
            e.printStackTrace();
            throw new RuntimeException();
        }
	}

	public void setWIDTH(int WIDTH) {
		this.WIDTH = WIDTH;
	}

	public void setHEIGHT(int HEIGHT) {
		this.HEIGHT = HEIGHT;
	}
	
	public int getWIDTH(){
		return this.WIDTH;
	}
	
	public int getHEIGHT(){
		return this.HEIGHT;
	}
}