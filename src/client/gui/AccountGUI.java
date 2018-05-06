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
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class AccountGUI {

	private JFrame frame;
	static String name;
	static String IP;
	static int host;
	

	public void initApp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountGUI window = new AccountGUI(name, IP, host);
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
		
		//BUTTONS
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(710, 11, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnBack);
		
		//LISTENERS
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				new MenuGUI(name, IP, host).initApp(false);
			}
		});
		
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				Client.disconnect(name);
			}
		});

	}
}
