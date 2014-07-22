import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class IfSentenceSetBranchWindow extends JFrame {
	IfSentence node;
	NodeDC nextNode;
	RightPanel panel;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public IfSentenceSetBranchWindow(IfSentence node, NodeDC nextNode, RightPanel panel) {
		this.panel = panel;
		this.node = node;
		this.nextNode = nextNode;
		setTitle("Set Branch");
		setBounds(100, 100, 317, 81);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseTheBranch = new JLabel("Branch:");
		lblChooseTheBranch.setBounds(10, 11, 132, 14);
		contentPane.add(lblChooseTheBranch);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Current", "If", "Else"}));
		comboBox.setBounds(86, 8, 109, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setOption(comboBox.getSelectedItem().toString());
				setVisible(false);
			}
		});
		btnNewButton.setBounds(205, 7, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	private void setOption(String option){
		Vector v1 = node.getView().getVector();
		Vector v2 = nextNode.getView().getVector();
		Vector r2 = new Vector(nextNode.getView().getWIDTH()/2,0);
		switch (option) {
		case "Current":{
			node.setCurrentNextNode(nextNode);
			Vector r1 = new Vector(node.getView().getWIDTH()/2, node.getView().getHEIGHT() );
			Line line = new Line(v1, v2, r1, r2);
			panel.getDiagram().getLines().add(line);
			panel.repaintView();
			break;
			}			
		
		case "If":{
			node.setLeftNextNode(nextNode);
			Vector r1 = new Vector(node.getView().getWIDTH(), node.getView().getHEIGHT()/2 );
			Line line = new Line(v1, v2, r1, r2);
			panel.getDiagram().getLines().add(line);
			panel.repaintView();
			break;
			}
			
		
		case "Else":{
			node.setRightNextNode(nextNode);
			Vector r1 = new Vector(0, node.getView().getHEIGHT()/2 );
			Vector r3 = new Vector(nextNode.getView().getWIDTH()/2, 0);
			System.out.print(nextNode.getView().getWIDTH());
			Line line = new Line(v1, v2, r1, r3);
			panel.getDiagram().getLines().add(line);
			panel.repaintView();
			break;
			}

		default:{
			System.out.print("ERROR: No se puede crear branch");
			break;
			}
		}
	}
}
