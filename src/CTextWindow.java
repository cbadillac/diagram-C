import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CTextWindow extends JFrame {

	private JPanel contentPane;
	private CText cText;

	/**
	 * Launch the application.
	 */
//	
	/**
	 * Create the frame.
	 * @param cTxt 
	 */
	public CTextWindow(CText cTxt) {
		this.cText = cTxt;
		setTitle("C Code");
		setBounds(100, 100, 204, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblWriteYourCode = new JLabel("Write your code here:");
		contentPane.add(lblWriteYourCode, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("OK");
		
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
			
		final JTextArea textArea = new JTextArea();
		textArea.setTabSize(2);
		textArea.setRows(8);
		textArea.setFont(new Font("Arial", Font.PLAIN, 15));
		if (cText.getText() != null) {
			textArea.setText(cText.getText());
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sendText(textArea.getText());
				setVisible(false);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
	}

	private void sendText(String txt){
		cText.setText(txt);
	}
}
