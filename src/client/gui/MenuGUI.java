package client.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import client.Client;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MenuGUI {

	public JFrame frame;
	String name;
	String IP;
	int host;
	

	public void initApp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI window = new MenuGUI(name, IP, host);
					window.frame.setVisible(true);
					Client.Connect(name, IP, host, window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuGUI(String name, String IP, int host) {
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
		btnAdd.setBounds(388, 168, 89, 23);
		frame.getContentPane().add(btnAdd);
		btnAdd.setEnabled(true);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(710, 11, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JButton btnStart = new JButton("START");
		btnStart.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnStart);
		
		//LISTENERS
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				Client.disconnect(name);
			}
		});
		
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String video = textFieldVideoAD.getText();
				Client.addVideo(name, video);

			}
		});
		
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				Client.disconnect(name);
			}
		});
	}
}


