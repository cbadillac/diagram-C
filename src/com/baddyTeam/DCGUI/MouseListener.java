package com.baddyTeam.DCGUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;


public class MouseListener extends MouseAdapter {
    private static int LEFTBUTTON = 1;
    private int rightClickCount   = 0;
	private RightPanel panel;
    private NodeDCView nodeViewOrigin = null; // Primer nodo clickeado
	private NodeDCView nodeViewDest = null;   // Segundo nodo clickeado


	public MouseListener(RightPanel panel) {
		this.panel = panel;
	}
	
	public void mouseMoved(MouseEvent e){
		if(panel.isHere(e.getX(), e.getY()) != null){
			nodeViewDest = panel.isHere(e.getX(), e.getY());
		}
		else
			nodeViewDest = null;
	}
	
	public void mousePressed( MouseEvent e ) {
        if(nodeViewDest == null){
            return;
        }

        if(e.getClickCount() >= 2  && e.getButton() == LEFTBUTTON){
            // this in a method ?
        	if (nodeViewDest instanceof IfSentenceView){
        		IfSentence ifSentence  = (IfSentence) nodeViewDest.getNode();
        		IfSentenceWindow frame = new IfSentenceWindow(ifSentence);
    			frame.setVisible(true);
        	}else if (nodeViewDest instanceof VarSentenceView) {
        		VarSentence varSentence = (VarSentence) nodeViewDest.getNode();
        		VarSentenceWindow frame = new VarSentenceWindow(varSentence);
				frame.setVisible(true);
			}else if (nodeViewDest instanceof CSentenceView) {
        		CSentence cText = (CSentence) nodeViewDest.getNode();
        		CSentenceWindow frame = new CSentenceWindow(cText);
        		frame.setVisible(true);
			}else if (nodeViewDest instanceof WhileSentenceView){
                WhileSentence whileSentence = (WhileSentence) nodeViewDest.getNode();
                WhileSentenceWindow frame = new WhileSentenceWindow(whileSentence);
                frame.setVisible(true);
            }
        }
        
        if (e.getButton() == 3) {
            // this in a method ?
        	rightClickCount++;

			if (rightClickCount == 1){
                this.nodeViewOrigin = nodeViewDest.clone();
                //System.out.print(nodeDCViewDest + "\n");
			} else if (rightClickCount == 2 && nodeViewOrigin.getNode() != nodeViewDest.getNode() ) {
                NodeDC originNode = nodeViewOrigin.getNode();
                NodeDC destNode   = nodeViewDest.getNode();

                if(destNode.isConnected())  //only one connection, bucle blocks!!!
                    return;

				if(originNode.getType().equals(NodeDC.typeOne)
                        && originNode.getNext() == null){
                    originNode.setNext(destNode);
                    destNode.connect();

                    Vector v1 = nodeViewOrigin.getVector();
                    Vector v2 = nodeViewDest.getVector();
                    Vector r1 = new Vector(nodeViewOrigin.getWIDTH()/2, nodeViewOrigin.getHEIGHT() );
                    Vector r2 = new Vector(nodeViewDest.getWIDTH()/2-1,0);

                    Line line = new Line(v1, v2, r1, r2);
                    panel.getLines().add(line);
                    panel.repaintView();

                }else if(originNode.getType().equals(NodeDC.typeTwo)){
                    IfSentenceSetBranchWindow win = new IfSentenceSetBranchWindow((IfSentence) originNode, destNode, panel);
                    win.setVisible(true);
                }else if(originNode.getType().equals(NodeDC.typeThree)) {
                }
                /*
                if (originNode.getType() == NodeDC.typeOne
                        && (originNode.getNext() == null || originNode.getNext() instanceof StringNode)){
                    if(destNode.getType() == NodeDC.typeTwo) {
                        Iterator<NodeDC> it = ((IfSentence)destNode).getNextContinue();

                        while(it.hasNext())
                            it = it.next();
                        ((NodeDC)it).setNext(originNode.getNext());
                        originNode.setNext(destNode);
                    } else {
                        originNode.setNext(destNode);
                    }

                } else if (originNode.getType() == NodeDC.typeTwo){
					IfSentenceSetBranchWindow win = new IfSentenceSetBranchWindow((IfSentence) originNode, destNode, panel);
					win.setVisible(true);
                    destNode.connect();
					//System.out.print("added if node");
				} else if (originNode.getType() == NodeDC.typeThree && (originNode.getNext() == null || originNode.getNext() instanceof StringNode)){
                    // TODO implement typeThree
                }
                */

				nodeViewOrigin = null;
				rightClickCount = 0;
			}else {
				rightClickCount = 0;
			}
		}

        //TODO: button to remove a node ! and lines too?
     }
	
	public void mouseDragged(MouseEvent e) {
		if(nodeViewDest != null ){
			nodeViewDest.dragTo(e.getX(), e.getY());
			panel.repaintView();
		}
	}

}
