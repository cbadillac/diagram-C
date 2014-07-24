package com.baddyTeam.DCGUI;

import java.awt.*;


public class IfSentence extends NodeDC {
	private static int id=0;

    private NodeDC leftNextNode    = null;
    private NodeDC rightNextNode   = null;
    private NodeDC currentNextNode = null;

	private IfSentenceView view;
	private String text;
	
	public IfSentence() {
		super(id++);
		view = new IfSentenceView(this);
		text = new String();
		System.out.print("If Created :) id:" + id + "\n");
	}

	@Override
	String toC() {
        // TODO: if fixed C sentence.
		return null;
	}
	@Override
	String getType() {
		return typeThree;
	}

    @Override
    public IfSentenceView getView(){
        return view;
    }
    @Override
    public void updateView(Graphics g){
        view.updateView(g);
    }


    public String getText(){
        return text;
    }
    public void setText(String txt){
        this.text = txt;
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
