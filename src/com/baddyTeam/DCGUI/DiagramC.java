package com.baddyTeam.DCGUI;


public class DiagramC {
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			Diagram diagram = new Diagram();
			DiagramC_GUI mainGUI = new DiagramC_GUI(diagram);
			mainGUI.setDefaultCloseOperation(DiagramC_GUI.EXIT_ON_CLOSE);
		    mainGUI.setVisible(true);
	}
}
