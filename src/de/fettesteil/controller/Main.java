package de.fettesteil.controller;

import java.net.Socket;

import javax.swing.JFrame;

public class Main {

	public static JFrame mainFrame;
	public static Socket masterServer;
	public static String HOST = "localhost";
	public static int PORT = 2222;

	public static void main(String args[]) {
		try {
			mainFrame = new MainFrame();

			// CONNECT TO MASTER SERVER
			masterServer = new Socket(HOST, PORT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
