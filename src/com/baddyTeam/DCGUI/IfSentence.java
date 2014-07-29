package com.baddyTeam.DCGUI;

import java.awt.*;


public class IfSentence extends NodeDC {
	private static int id = 0;

    private NodeDC nextFalse;
    private NodeDC nextContinue;

	private IfSentenceView view;
	private String conditionText;
	
	public IfSentence() {
		super(id++);
		this.view = new IfSentenceView(this);
		this.conditionText = new String();

        super.next        = new StringNode("{");
        this.nextFalse    = new StringNode("} else {");
        this.nextContinue = new StringNode("}");
        super.next.setNext(this.nextFalse);
        this.nextFalse.setNext(this.nextContinue);
        this.nextContinue.setNext(null);
	}

	@Override
	String toC() {
		return "if( "+conditionText+" )";
	}
	@Override
	String getType() {
		return typeTwo;
	}

    @Override
    public IfSentenceView getView(){
        return view;
    }
    @Override
    public void updateView(Graphics g){
        view.updateView(g);
    }
    @Override
    public String getText(){
        return this.conditionText;
    }
    public void setText(String txt){
        this.conditionText = txt;
    }

    public NodeDC getNextFalse() {
        return this.nextFalse;
    }
    public NodeDC getNextTrue() {
        return this.next;
    }
    public NodeDC getNextContinue(){
        return  this.nextContinue;
    }
    public void setNextTrue(NodeDC nextTrue) {
        this.next.setNext(nextTrue);
    }
    public void setNextFalse(NodeDC nextFalse) {
        this.nextFalse.setNext(nextFalse);
        //this.nextFalse.setNext(nextFalse);
    }
    public void setNextContinue(NodeDC nextContinue){
        this.nextContinue = nextContinue;
    }

}