package com.baddyTeam.DCGUI;

import java.awt.*;

/**
 * Created by Cristobal on 27-07-2014.
 */
public class FirstNode extends NodeDC {
    private static int id = 0;
    private FirstNodeView view;

    protected FirstNode() {
        super(id++);
        this.view = new FirstNodeView(this);
    }

    @Override
    protected int getId() {
        return super.getId();
    }


    @Override
    public NodeDC next() {
        return super.next();
    }
    @Override
    public boolean hasNext() {
        return super.hasNext();
    }
    @Override
    public void remove() {
        super.remove();
    }

    @Override
    String toC() {
        return "int main()";
    }
    @Override
    String getType() {
        return NodeDC.typeThree;
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
        return null;
    }

    @Override
    public NodeDC getNext() {
        return super.getNext();
    }
    @Override
    public void setNext(NodeDC nextNode) {
        super.setNext(nextNode);
    }
}
