package com.baddyTeam.DCGUI;

import java.util.ArrayList;


public class Diagram implements Iterable<NodeDC>{
    //TODO this class will use the Fabric pattern design.

	private NodeDC firstNode;

	public Diagram() {
		this.firstNode = null;
	}

    @Override
    public NodeDC iterator(){
        return this.firstNode;
    }

    public void createVarSentence(){}
    public void createIfSentence(){}
    public void createCSentence(){}

}
