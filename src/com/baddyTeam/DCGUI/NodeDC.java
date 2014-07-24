package com.baddyTeam.DCGUI;

import javax.xml.soap.Node;
import java.awt.*;
import java.util.ArrayList;


public abstract  class NodeDC {

    private final int myId; /* to identify each element within its category */

	public static String typeOne   = "typeOne";
	public static String typeTwo   = "typeTwo";
	public static String typeThree = "typeThree";
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

	public NodeDC getCurrentNextNode() {
		return currentNextNode;
	}
	public void setCurrentNextNode(NodeDC currentNextNode) {
		this.currentNextNode = currentNextNode;
	}

}

