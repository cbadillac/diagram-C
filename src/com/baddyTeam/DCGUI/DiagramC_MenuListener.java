package com.baddyTeam.DCGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DiagramC_MenuListener implements ActionListener {
	private DiagramC_GUI window;
	

	public DiagramC_MenuListener(DiagramC_GUI window) {
		this.window = window;
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		JMenuItem menuItem = (JMenuItem)(event.getSource());
	    String text = menuItem.getText();
	    System.out.print(text);
	    
	    if(text.equals("Exit") ){

	    }
	}


}
