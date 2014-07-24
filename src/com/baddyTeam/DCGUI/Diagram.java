package com.baddyTeam.DCGUI;

import java.util.ArrayList;


public class Diagram {
	private ArrayList<NodeDC> nodes;
	private ArrayList<NodeDCView> viewNodes;
	private NodeDC root;
	private ArrayList<Line> lines;


	public Diagram() {
		nodes     = new ArrayList<NodeDC>();
		viewNodes = new ArrayList<NodeDCView>();
		lines     = new ArrayList<Line>();
		root      = new NodeDCRoot();				
	}

	public void addNodes(NodeDC nd){
		nodes.add(nd);
	}
	public void addViewNodes(NodeDCView nd){
		viewNodes.add(nd);
	}

	public ArrayList<NodeDC> getNodes(){
		return nodes;
	}
	public ArrayList<NodeDCView> getViewNodes(){
		return viewNodes;
	}
	public NodeDC getRoot() {
		return root;
	}
	public ArrayList<Line> getLines() {
		return lines;
	}

}
