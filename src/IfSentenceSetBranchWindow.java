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

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					IfSentenceSetBranchWindow frame = new IfSentenceSetBranchWindow();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public IfSentenceSetBranchWindow(IfSentence node, NodeDC nextNode) {
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
		switch (option) {
		case "current":{
			node.getRoot().add(nextNode);
			nextNode.setRoot(node.getRoot());
			break;
			}
		
		case "If":{
			node.getIfConditions().add(nextNode);
			nextNode.setRoot(node.getIfConditions());
			System.out.print("Added");
			break;
			}
		
		case "Else":{
			node.getElseConditions().add(nextNode);
			nextNode.setRoot(node.getElseConditions());
			break;
			}

		default:{
			node.getRoot().add(nextNode);
			nextNode.setRoot(node.getRoot());
			break;
			}
		}
	}
}
