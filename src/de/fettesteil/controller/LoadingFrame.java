package de.fettesteil.controller;

import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoadingFrame extends JFrame {
	
	private JLabel loadingText = new JLabel("Loading");

	public LoadingFrame() {
		setSize(150, 50);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(loadingText);
	}

	public void setText(String text) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				loadingText.setText(text);
			}
		});
	}
}
