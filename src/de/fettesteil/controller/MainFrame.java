package de.fettesteil.controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import de.fettesteil.controller.panels.AddServerPanel;
import de.fettesteil.controller.panels.ServersPanel;

public class MainFrame extends JFrame {
	
	public JTabbedPane tabBar;
	
	public ServersPanel serversPanel;
	public AddServerPanel addServerPanel;
	
	public MainFrame() {
		super("Server Controller");
		setLayout(new BorderLayout());
		setSize(1280, 720);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		serversPanel = new ServersPanel();
		addServerPanel = new AddServerPanel();
		
		tabBar = new JTabbedPane();
		tabBar.add("Servers", serversPanel);
		tabBar.add("Add Server", addServerPanel);
		add(tabBar, BorderLayout.CENTER);
	}
}
