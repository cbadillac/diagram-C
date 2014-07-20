import java.awt.event.MouseAdapter;
import java.awt.event.*;


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
			;
	}
	
	public void mouseDragged(MouseEvent e) {
		if(nodeView != null){
			nodeView.dragTo(e.getX(), e.getY());
			panel.repaintView();
		}
	}
	

}
