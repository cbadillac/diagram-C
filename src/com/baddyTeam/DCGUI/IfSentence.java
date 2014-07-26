package com.baddyTeam.DCGUI;

import java.awt.*;


public class IfSentence extends NodeDC {
	private static int id=0;

    private NodeDC nextFalse;
    private NodeDC nextTrue;

	private IfSentenceView view;
	private String conditionText;
	
	public IfSentence() {
		super(id++);
		this.view = new IfSentenceView(this);
		this.conditionText = new String();

        this.nextTrue  = this.nextFalse;
        this.nextFalse = super.next;
	}

	@Override
	String toC() {
		return "if("+conditionText+")";
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
        return this.nextTrue;
    }
    public void setNextTrue(NodeDC nextTrue) {
        nextTrue.setNext(this.nextTrue);
        this.nextTrue = nextTrue;
    }
    public void setNextFalse(NodeDC nextFalse) {
        nextFalse.setNext(this.nextFalse);
        this.nextFalse = nextFalse;
    }

}