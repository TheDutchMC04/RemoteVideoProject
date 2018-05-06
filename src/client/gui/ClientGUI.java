package client.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClientGUI {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldIP;
	private JTextField textFieldHost;
	
	public String name;
	public String IPaddress = "localhost";

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					ClientGUI window = new ClientGUI();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
	}

	public ClientGUI() {
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
		lblEnterPort.setBounds(311, 211, 89, 38);
		frame.getContentPane().add(lblEnterPort);		
		
		JLabel lblEnterIP = new JLabel("Enter IP Adress :");
		lblEnterIP.setBounds(284, 160, 104, 38);
		frame.getContentPane().add(lblEnterIP);
		
		JLabel lblClient = new JLabel("CLIENT");
		lblClient.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 58));
		lblClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblClient.setBounds(322, 11, 192, 64);
		frame.getContentPane().add(lblClient);
		
		//DYNAMIC LABELS		
		JLabel lblErrorText = new JLabel("");
		lblErrorText.setBounds(250, 256, 538, 14);
		frame.getContentPane().add(lblErrorText);
		
		//TEXT FIELDS	
		textFieldName = new JTextField();
		textFieldName.setBounds(384, 111, 130, 38);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldIP = new JTextField();
		textFieldIP.setBounds(384, 160, 130, 38);
		frame.getContentPane().add(textFieldIP);
		textFieldIP.setColumns(10);
		textFieldIP.setEnabled(false);
		
		textFieldHost = new JTextField();
		textFieldHost.setBounds(384, 211, 130, 38);
		frame.getContentPane().add(textFieldHost);
		textFieldHost.setColumns(10);
		textFieldHost.setEnabled(false);
		
		//BUTTONS
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setEnabled(false);
		btnCancel.setBounds(384, 312, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnStart = new JButton("Start");
		btnStart.setEnabled(false);
		btnStart.setBounds(384, 278, 89, 23);
		frame.getContentPane().add(btnStart);
		
		//LISTENERS
		textFieldHost.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
						
				lblErrorText.setText("");
				if(textFieldHost.getText().toCharArray().length == 4) {textFieldHost.setEnabled(false); textFieldName.setEnabled(false); btnCancel.setEnabled(true); btnStart.setEnabled(true);} 
						
			}
					
		});
		
		textFieldName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				name = textFieldName.getText();
				
				List<Character> characters = new ArrayList<>();
				  for (char c : name.toCharArray()) {
					  if(c != ' ')
					  characters.add(c);
				    }

				if(!characters.isEmpty()) {textFieldHost.setEnabled(true); textFieldIP.setEnabled(true);}
				else if (characters.isEmpty()) {textFieldHost.setEnabled(false); textFieldIP.setEnabled(false);}
			}
		});
		
		textFieldIP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				IPaddress = textFieldName.getText();
				
				List<Character> characters = new ArrayList<>();
				  for (char c : IPaddress.toCharArray()) {
					  if(c != ' ')
					  characters.add(c);
				    }

				if(!characters.isEmpty()) {IPaddress = "localhost";}
			}
		});
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				name = textFieldName.getText();
				Boolean validHost = true;
				
				for(char c : textFieldHost.getText().toCharArray()) {
					
					if(c == ' ') {validHost = false;}
					else if(!Character.isDigit(c)) {validHost = false;}

					
				}
				
				if (validHost) {
					lblErrorText.setText("Started client with host *" + textFieldHost.getText() + "*, with IP *" + IPaddress + "* and as name *" + name + "*.");
					btnStart.setEnabled(false);
					btnCancel.setEnabled(false);
					textFieldHost.setEnabled(false);
					frame.setVisible(false);
					new AccountGUI(name, IPaddress, Integer.parseInt(textFieldHost.getText())).initApp();

				}
				
				else if (!validHost) {
					lblErrorText.setText("Invalid host, please use 4 numbers.");
					textFieldHost.setText("");
					textFieldHost.setEnabled(true);
					btnStart.setEnabled(false);
					btnCancel.setEnabled(false);
				}
				
			}
		});
		
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textFieldHost.setText("");
				textFieldHost.setEnabled(true);
				textFieldName.setText("");
				textFieldName.setEnabled(true);
				btnStart.setEnabled(false);
				btnCancel.setEnabled(false);
				
			}
		});
				
	}

}
