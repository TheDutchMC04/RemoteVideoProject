package client.gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import client.Client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AccountGUI extends Thread {

	private JFrame frame;
	static String name;
	static String IP;
	static int host;
	

	public void initApp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountGUI window = new AccountGUI(name, IP, host);
					Client.Connect(name, IP, host);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AccountGUI(String name, String IP, int host) {
		this.name = name;
		this.IP = IP;
		this.host = host;
		initialize(name, IP, host);
	}

	private void initialize(String name, String IP, int host) {
		
		//FRAME
		frame = new JFrame();
		frame.setBounds(100, 100, 825, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		//LABELS		
		JLabel lblClient = new JLabel(name);
		lblClient.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 58));
		lblClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblClient.setBounds(226, 11, 394, 64);
		frame.getContentPane().add(lblClient);
		
		//TEXT FIELDS
		JTextField textFieldVideoAD = new JTextField();
		textFieldVideoAD.setBounds(226, 106, 411, 38);
		frame.getContentPane().add(textFieldVideoAD);
		textFieldVideoAD.setColumns(10);
		textFieldVideoAD.setEnabled(true);
		
		//BUTTONS
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String video = textFieldVideoAD.getText();
				Client.addVideo(name, video);

			}
		});
		btnAdd.setBounds(388, 168, 89, 23);
		frame.getContentPane().add(btnAdd);
		btnAdd.setEnabled(true);
	}

}
