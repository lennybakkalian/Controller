package de.fettesteil.controller;

import javax.swing.JOptionPane;

public class Utils {
	public static void popup(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
}
