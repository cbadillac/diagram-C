package com.baddyTeam.DCGUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseListener extends MouseAdapter {
	
	private RightPanel panel;
	private NodeDCView nodeView = null;
	private static int LEFTBUTTON = 1;
	private int rightClickCount = 0;
	private NodeDCView nodeDCViewTemp =null;

	public MouseListener(RightPanel panel) {
		// TODO Auto-generated constructor stub
		this.panel = panel;
	}
	
	public void mouseMoved(MouseEvent e){
		if(panel.isHere(e.getX(), e.getY()) != null){
			nodeView = panel.isHere(e.getX(), e.getY());
		}
		else
			nodeView = null;
	}
	
	public void mousePressed( MouseEvent e ) {		
        if(e.getClickCount() >= 2 && nodeView != null && e.getButton() == LEFTBUTTON){
        	if (nodeView instanceof IfSentenceView){
        		IfSentence ifSentence = (IfSentence)nodeView.getNode(); 
        		IfSentenceWindow frame = new IfSentenceWindow(ifSentence);
    			frame.setVisible(true);
        	}else if (nodeView instanceof VarSentenceView) {
        		VarSentence varSentence = (VarSentence)nodeView.getNode();
        		VarSentenceWindow frame = new VarSentenceWindow(varSentence);
				frame.setVisible(true);    	
			}else if (nodeView instanceof CTextView) {
        		CText cText = (CText)nodeView.getNode();
        		System.out.print(cText.getId());
        		CTextWindow frame = new CTextWindow(cText);
        		frame.setVisible(true);
				
			}
        }
        
        if (e.getButton() == 3) {
        	rightClickCount++;
			if(rightClickCount == 1 && nodeView != null){
				nodeDCViewTemp = nodeView.clone();
				System.out.print(nodeDCViewTemp + "\n");
				
			}else if (rightClickCount == 2 && nodeView != null && nodeDCViewTemp.getNode() != nodeView.getNode() ) {
//				System.out.print("\n");
				NodeDC nodeDCTemp = nodeDCViewTemp.getNode();
				NodeDC actualNode = nodeView.getNode();
				Vector v1 = nodeDCViewTemp.getVector();
				Vector v2 = nodeView.getVector();
				Vector r1 = new Vector(nodeDCViewTemp.getWIDTH()/2, nodeDCViewTemp.getHEIGHT() );
				Vector r2 = new Vector(nodeView.getWIDTH()/2-1,0);
				
				if (panel.getDiagram().getRoot().getCurrentNextNode() == null) {
					panel.getDiagram().getRoot().setCurrentNextNode(nodeDCTemp);
					nodeDCTemp.setCurrentNextNode(actualNode);
					Line line = new Line(v1, v2, r1, r2);
					panel.getDiagram().getLines().add(line);
					panel.repaintView();
					
					System.out.print("added firsts nodes");
					
				} else if (nodeDCTemp.getType() == NodeDC.typeOne) {
					nodeDCTemp.setCurrentNextNode(actualNode);
					Line line = new Line(v1, v2, r1, r2);
					panel.getDiagram().getLines().add(line);
					panel.repaintView();	
					

				} else if(nodeDCTemp.getType() == NodeDC.typeThree){
					IfSentenceSetBranchWindow win = new IfSentenceSetBranchWindow((IfSentence) nodeDCTemp, actualNode, panel); 
					win.setVisible(true);
					System.out.print("added if node");
				}
				nodeDCViewTemp = null;
				rightClickCount = 0;
			}else {
				rightClickCount = 0;
			}
		}
     }
	
	public void mouseDragged(MouseEvent e) {
		if(nodeView != null ){
			nodeView.dragTo(e.getX(), e.getY());
			panel.repaintView();
		}
	}
	
	
	

}