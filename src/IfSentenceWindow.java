import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class IfSentenceWindow extends JFrame {

	private JPanel contentPane;
	private IfSentence ifSentence;
	private String text;

	public IfSentenceWindow(IfSentence ifstc) {
		setTitle("If Sentence");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 271, 132);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.ifSentence = ifstc; 
		
		JLabel lblWriteYourCondition = new JLabel("Write your condition here:");
		lblWriteYourCondition.setBounds(5, 5, 203, 14);
		contentPane.add(lblWriteYourCondition);
	
		
		JButton btnOk = new JButton("OK");
		
		btnOk.setBounds(136, 60, 92, 23);
		contentPane.add(btnOk);
		
		final JFormattedTextField formattedTextField = new JFormattedTextField();
		
		if(ifSentence.getText() != null){
			formattedTextField.setText(ifstc.getText());
		}
		formattedTextField.setBounds(15, 24, 193, 20);
		contentPane.add(formattedTextField);
		this.text = formattedTextField.getText();
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Ok if apretado");
				sendText(formattedTextField.getText());
				setVisible(false);				
			}
		});
	}
	
	private void sendText(String txt){
		System.out.print(txt);
		ifSentence.setText(txt);
	}
}
