package com.baddyTeam.DCGUI;

import java.awt.*;


public class CText extends NodeDC {
	private CTextView view;
	private String text;
	private static int id=0;
	
	public CText() {
		super(id++);
		view = new CTextView(this);
		setText(new String());
	}

	@Override
	String toC() {
		// TODO CText fixed to C sentence
		return null;
	}

	@Override
	String getType() {
		return typeOne;
	}

	@Override
	void updateView(Graphics g) {
		view.updateView(g);

	}

	public CTextView getView() {
		return view;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
