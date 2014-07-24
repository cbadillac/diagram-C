package com.baddyTeam.DCGUI;

import java.awt.*;


public class CSentence extends NodeDC {
    private CSentenceView view;
    private String        text;
    private static int id = 0;

    public CSentence() {
        super(id++);
        view = new CSentenceView(this);
        setText(new String());
	}

	@Override
	String toC() {
		return text;
	}

	@Override
	String getType() {
		return typeOne;
	}

	@Override
	void updateView(Graphics g) {
		view.updateView(g);

	}

	public CSentenceView getView() {
		return view;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
