package com.baddyTeam.DCGUI;

import javax.xml.soap.Node;
import java.awt.*;
import java.util.ArrayList;


public abstract  class NodeDC {

    private final int myId; /* to identify each element within its category */

	public static String typeOne   = "typeOne";
	public static String typeTwo   = "typeTwo";
	public static String typeThree = "typeThree";
	private ArrayList<NodeDC> root = null;
	private NodeDC leftNextNode    = null;
	private NodeDC rightNextNode   = null;
	private NodeDC currentNextNode = null;
	

	protected NodeDC( int id){
	      myId = id;
	   }
	protected int getId() {
	      return myId;
	   }
			
	abstract String toC();
	abstract String getType();

	abstract void updateView(Graphics g);
	abstract NodeDCView getView();
	
	public ArrayList<NodeDC> getRoot() {
		return root;
	}
	public void setRoot(ArrayList<NodeDC> root) {
		this.root = root;
	}
	public NodeDC getLeftNextNode() {
		return leftNextNode;
	}
	public void setLeftNextNode(NodeDC leftNextNode) {
		this.leftNextNode = leftNextNode;
	}
	public NodeDC getRightNextNode() {
		return rightNextNode;
	}
	public void setRightNextNode(NodeDC rightNextNode) {
		this.rightNextNode = rightNextNode;
	}
	public NodeDC getCurrentNextNode() {
		return currentNextNode;
	}
	public void setCurrentNextNode(NodeDC currentNextNode) {
		this.currentNextNode = currentNextNode;
	}
	

}

