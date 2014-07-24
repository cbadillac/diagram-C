package com.baddyTeam.DCGUI;

import javax.xml.soap.Node;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;


public abstract  class NodeDC implements Iterator<NodeDC>{
    private final int myId; /* to identify each element within its category */

	public static String typeOne   = "typeOne";
	public static String typeTwo   = "typeTwo";
	public static String typeThree = "typeThree";
	private NodeDC next;
	

	protected NodeDC( int id){
	    this.myId = id;
        this.next = null;
    }
	protected int getId() {
	      return myId;
	   }

    @Override
    public NodeDC next (){
        return this.next;
    }
    @Override
    public boolean hasNext(){
        return (this.next == null)? false: true;
    }
    @Override
    public void remove(){
        // Not removable from iteration ???
        throw new UnsupportedOperationException("remove() not allowed.");
    }
			
	abstract String toC();
	abstract String getType();

	abstract void updateView(Graphics g);
	abstract NodeDCView getView();

	public NodeDC getNode() {
		return this;
	}
	public void setNext(NodeDC nextNode) {
		this.next = nextNode;
	}

}

