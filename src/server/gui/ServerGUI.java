package server.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import server.Server;

import java.awt.TextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerGUI {

	private JFrame frame;
	private JTextField textField;
	
	public String host;

	public static void main (String[] args) {
		
		EventQueue.invokeLater(new Thread() {
			
			public void run() {
				
				try {
					ServerGUI window = new ServerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
	}

	public ServerGUI() {
		initialize();
	}

	private void initialize() {
		
		//FRAME
		frame = new JFrame();
		frame.setBounds(100, 100, 825, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		//LABELS
		JLabel lblEnterPort = new JLabel("Enter Port :");
		lblEnterPort.setBounds(319, 160, 77, 38);
		frame.getContentPane().add(lblEnterPort);		
		
		JLabel lblServer = new JLabel("SERVER");
		lblServer.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 58));
		lblServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblServer.setBounds(322, 11, 192, 64);
		frame.getContentPane().add(lblServer);
		
		//DYNAMIC LABELS		
		JLabel lblErrorText = new JLabel("");
		lblErrorText.setBounds(284, 260, 288, 14);
		frame.getContentPane().add(lblErrorText);
		
		//TEXT FIELDS	
		textField = new JTextField();
		textField.setBounds(384, 160, 130, 38);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		//BUTTONS
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setEnabled(false);
		btnCancel.setBounds(452, 226, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnStart = new JButton("Start");
		btnStart.setEnabled(false);
		btnStart.setBounds(353, 226, 89, 23);
		frame.getContentPane().add(btnStart);		
		
		//LISTENERS
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				lblErrorText.setText("");
				if(textField.getText().toCharArray().length == 4) {textField.setEnabled(false); btnCancel.setEnabled(true); btnStart.setEnabled(true);} 
				
			}
			
		});
		
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textField.setText("");
				textField.setEnabled(true);
				btnStart.setEnabled(false);
				btnCancel.setEnabled(false);
				
			}
		});
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Boolean validHost = true;
				
				for(char c : textField.getText().toCharArray()) {
					
					if(c == ' ') {validHost = false;}
					else if(!Character.isDigit(c)) {validHost = false;}

					
				}
				
				if (validHost) {
					lblErrorText.setText("Started server with host " + textField.getText() + ".");
					btnStart.setEnabled(false);
					btnCancel.setEnabled(false);
					textField.setEnabled(false);
					new Thread(new Server(Integer.parseInt(textField.getText()))).start();
				}
				
				else if (!validHost) {
					lblErrorText.setText("Invalid host, please use 4 numbers.");
					textField.setText("");
					textField.setEnabled(true);
					btnStart.setEnabled(false);
					btnCancel.setEnabled(false);
				}
				
			}
		});

	}
}
