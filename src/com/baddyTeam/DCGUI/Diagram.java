package com.baddyTeam.DCGUI;

import java.util.ArrayList;


public class Diagram implements Iterable<NodeDC>{

    // TODO the first NodeDC node should be a function reference (main, ...)
	private NodeDC firstNode;

	public Diagram() {
		this.firstNode = null;
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

}
