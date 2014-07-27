package com.baddyTeam.DCGUI;

import java.util.ArrayList;


public class Diagram implements Iterable<NodeDC>{

    // TODO create a first node type
	private FirstNode firstNode;

	public Diagram() {
		this.firstNode = null;
	}
    public Diagram(FirstNode node) {
        this.firstNode = node;
    }

    @Override
    public NodeDC iterator(){
        return this.firstNode;
    }

    public static VarSentence createVarSentence(){
        return new VarSentence();
    }
    public static IfSentence createIfSentence(){
        return new IfSentence();
    }
    public static CSentence createCSentence(){
        return new CSentence();
    }

    public FirstNode getNode(){
        return this.firstNode;
    }

}
