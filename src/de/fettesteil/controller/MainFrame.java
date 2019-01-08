package de.fettesteil.controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import de.fettesteil.controller.panels.ServersPanel;

public class MainFrame extends JFrame {
	
	public JTabbedPane tabBar;
	
	public ServersPanel serversPanel;
	
	public MainFrame() {
		super("Server Controller");
		setLayout(new BorderLayout());
		setSize(1280, 720);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		serversPanel = new ServersPanel();
		
		tabBar = new JTabbedPane();
		tabBar.add("Servers", serversPanel);
		add(tabBar, BorderLayout.CENTER);
	}
}
