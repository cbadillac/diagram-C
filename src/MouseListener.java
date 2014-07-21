import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import com.sun.org.apache.bcel.internal.generic.IfInstruction;


public class MouseListener extends MouseAdapter {
	
	private RightPanel panel;
	private NodeDCView nodeView = null;

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
        if(e.getClickCount() >= 2 && nodeView != null){
            //do something
        	if (nodeView instanceof IfSentenceView){
        		IfSentence ifSentence = (IfSentence)nodeView.getNode(); 
        		IfSentenceWindow frame = new IfSentenceWindow(ifSentence);
    			frame.setVisible(true);
        	}else if (nodeView instanceof VarSentenceView) {
        		VarSentence varSentence = (VarSentence)nodeView.getNode();
        		VarSentenceWindow frame = new VarSentenceWindow(varSentence);
				frame.setVisible(true);    	
			}
        	else if (nodeView instanceof CTextView ) {
        		CText cText = (CText)nodeView.getNode();
        		System.out.print(cText.getId());
        		CTextWindow frame = new CTextWindow(cText);
        		frame.setVisible(true);
				
			}
        	
        }
     }
	
	public void mouseDragged(MouseEvent e) {
		if(nodeView != null){
			nodeView.dragTo(e.getX(), e.getY());
			panel.repaintView();
		}
	}
	
	
	

}
