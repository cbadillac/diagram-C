
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
    String toC() {
        return "while("+text+")";
    }

    @Override
    String getType() {
        return typeThree;
    }

    @Override
    void updateView(Graphics g) {
        view.updateView(g);
    }

    @Override
    NodeDCView getView() {
        return view;
    }

    @Override
    String getText() {
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
}
