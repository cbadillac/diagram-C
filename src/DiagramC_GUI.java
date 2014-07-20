import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuListener;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Label;
import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class DiagramC_GUI extends JFrame {
	Diagram diagram;
	RightPanel rightPanel;
	
	public DiagramC_GUI(Diagram dg) {
		
		diagram = dg;
		
		setFont(new Font("Tahoma", Font.PLAIN, 11));
		setTitle("Diagram-C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JLabel label1 = new JLabel("Components");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(10, 9, 79, 14);
		JLabel label2 = new JLabel("Flow");
		label2.setVerticalAlignment(SwingConstants.TOP);
		
		LeftPanel leftPanel = new LeftPanel();
		rightPanel = new RightPanel(diagram);

		
		leftPanel.setLayout(null);
		
		leftPanel.add(label1);
		rightPanel.add(label2);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
		
		JButton btnIf = new JButton("If");
		btnIf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				IfSentence ifSentence;
				ifSentence = new IfSentence ();
				diagram.addNodes(ifSentence);
				diagram.addViewNodes(ifSentence.getView());
				rightPanel.repaint();
			}
		});
		
		
		btnIf.setIcon(new ImageIcon("C:\\Users\\Crist\u00F3bal\\workspace2\\diagram-C\\icons\\if_sentence2.png"));
		btnIf.setBounds(10, 34, 79, 37);
		leftPanel.add(btnIf);
		
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
