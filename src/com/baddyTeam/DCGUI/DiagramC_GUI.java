package com.baddyTeam.DCGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import sun.org.mozilla.javascript.internal.annotations.JSConstructor;


public class DiagramC_GUI extends JFrame {
	Diagram diagram;
	RightPanel rightPanel;
	
	public DiagramC_GUI(Diagram dg) {
		
		diagram = dg;
		
		setFont(new Font("Tahoma", Font.PLAIN, 11));
		setTitle("Diagram-C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		setBounds(100, 100, 600, 509);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JLabel label1 = new JLabel("Components");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(10, 9, 79, 14);
//		JLabel label2 = new JLabel("Flow");
//		label2.setVerticalAlignment(SwingConstants.TOP);
//		label2.setHorizontalAlignment(SwingConstants.LEFT);
		
		LeftPanel leftPanel = new LeftPanel();
        leftPanel.setLayout(null);
        leftPanel.add(label1);

		this.rightPanel = new RightPanel(diagram);
		this.rightPanel.setPreferredSize(new Dimension(100, 100));
		
		final JScrollPane scroll = new JScrollPane(this.rightPanel);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, scroll);
		
		JButton btnIf = new JButton("If");
		btnIf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IfSentence ifSentence;
				ifSentence = new IfSentence();
				diagram.addNodes(ifSentence);
				diagram.addViewNodes(ifSentence.getView());
				rightPanel.repaint();
			}
		});
		
		
		btnIf.setIcon(new ImageIcon(DiagramC_GUI.class.getResource("/if_sentence2.png")));
		btnIf.setBounds(10, 34, 79, 37);
		leftPanel.add(btnIf);
		
		
		
		
		JButton btnVar = new JButton("Var");
		btnVar.setIcon(new ImageIcon(DiagramC_GUI.class.getResource("/var_sentence.png")));
		btnVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VarSentence varSentence = new VarSentence();
				diagram.addNodes(varSentence);
				diagram.addViewNodes(varSentence.getView());
				rightPanel.repaintView();
			}
		});
		
		btnVar.setBounds(10, 82, 79, 37);
		leftPanel.add(btnVar);
		
		JButton btnCCode = new JButton("Code");
		btnCCode.setIcon(new ImageIcon(DiagramC_GUI.class.getResource("/cText.png")));
		btnCCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CText cText = new CText();
				diagram.addNodes(cText);
				diagram.addViewNodes(cText.getView());
				rightPanel.repaintView();
			}
		});
		btnCCode.setBounds(10, 131, 79, 37);
		leftPanel.add(btnCCode);
		
		splitPane.setDividerLocation(100);
		
		DiagramC_MenuListener menuListener = new DiagramC_MenuListener(this);
		getContentPane().add(splitPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Tahoma", Font.PLAIN, 11));
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mntmExit.addActionListener(menuListener);
		
		JMenuItem mntmCreateCCode = new JMenuItem("Create C Code");
		mntmCreateCCode.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mnFile.add(mntmCreateCCode);
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About...");
		mntmAbout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mntmAbout.addActionListener(menuListener);
		mnHelp.add(mntmAbout);
		
		
	}
}
