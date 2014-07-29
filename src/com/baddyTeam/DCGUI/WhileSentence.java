
package com.baddyTeam.DCGUI;

import java.awt.*;

/**
 * Created by Cristóbal on 28-07-2014.
 */
public class WhileSentence extends NodeDC {
    private WhileSentenceView view;
    private String       text;
    private static int id = 0;

    public WhileSentence() {
        super(id++);
        view = new WhileSentenceView(this);
        setText(new String());
    }

    @Override
    public String toC() {
        return "while("+text+")";
    }

    @Override
    public String getType() {
        return typeThree;
    }

    @Override
    public void updateView(Graphics g) {
        view.updateView(g);
    }

    @Override
    public NodeDCView getView() {
        return view;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
}
