package com.baddyTeam.DCGUI;

import java.util.Iterator;


public class Diagram implements Iterable<NodeDC>{

	private FirstNode firstNode;

	public Diagram() {
		this.firstNode = null;
	}
    public Diagram(FirstNode node) {
        this.firstNode = node;
    }

    @Override
    public Iterator<NodeDC> iterator(){
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
    public static WhileSentence createWhileSentence(){
        return new WhileSentence();
    }


    public FirstNode getNode(){
        return this.firstNode;
    }

}
