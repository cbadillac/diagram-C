package com.baddyTeam.DCGUI;

import javax.xml.soap.Node;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public abstract class NodeDC implements Iterator<NodeDC>{
    private final int myId; /* to identify each element within its category */

	public static String typeOne   = "typeOne";
	public static String typeTwo   = "typeTwo";
	public static String typeThree = "typeThree";


	protected NodeDC next;
    protected boolean connected;



    private boolean ignore;
	

	protected NodeDC( int id){
	    this.myId         = id;
        this.next         = null;
        this.connected = false;
        this.ignore = false;
    }

	protected int getId() {
	      return myId;
	   }

    @Override
    public NodeDC next (){
        if (this.next == null)
            throw new NoSuchElementException();

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
    abstract String getText();

	public NodeDC getNext() {
		return this.next;
	}
	public void setNext(NodeDC nextNode) {
        if(nextNode == null) return;
        if( this.next != null)
            nextNode.setNext(this.next);
		this.next = nextNode;
	}

    public boolean isConnected(){
        return connected;
    }
    public void connect(){
        this.connected = true;
    }
    public boolean isIgnore() {
        return ignore;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }
}

