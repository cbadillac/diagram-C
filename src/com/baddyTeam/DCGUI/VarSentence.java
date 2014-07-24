package com.baddyTeam.DCGUI;

import java.awt.*;


public class VarSentence extends NodeDC {
	
	private static int id = 0;
	
	private VarSentenceView view;
	
	private String varName;
	private String varValue;
	private String varType;

	
	public VarSentence() {
		super(id++);
		view     = new VarSentenceView(this);
		setVarName(new String());
		setVarValue(new String());
	}

	
	@Override
	String toC() {
		return null;
	}

	@Override
	void updateView(Graphics g) {
		view.updateView(g);
	}
	
	
	public VarSentenceView getView(){
		return view;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public String getVarValue() {
		return varValue;
	}

	public void setVarValue(String varValue) {
		this.varValue = varValue;
	}

	public String getVarType() {
		return varType;
	}

	public void setVarType(String varType) {
		this.varType = varType;
	}


	@Override
	String getType() {
		// TODO Auto-generated method stub
		return NodeDC.typeOne;
	}

}
