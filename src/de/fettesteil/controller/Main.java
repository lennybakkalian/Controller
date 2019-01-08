package de.fettesteil.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;

import de.fettesteil.controller.packets.LoginPacket;
import de.fettesteil.controller.packets.Packet;

public class Main {

	public static MainFrame mainFrame;
	public static LoadingFrame loadingFrame = new LoadingFrame();
	public static String HOST = "localhost";
	public static int PORT = 2222;
	public static Socket masterServer;
	public static BufferedReader br;
	public static PrintWriter pw;
	public static boolean authenticated = false;
	public static String ADMIN_KEY = "test";
	public static Server tableServer;

	public static void main(String args[]) {
		try {
			loadingFrame.setVisible(true);
			loadingFrame.setText("Verbinde zum Server");
			mainFrame = new MainFrame();

			// CONNECT TO MASTER SERVER
			masterServer = new Socket(HOST, PORT);
			br = new BufferedReader(new InputStreamReader(masterServer.getInputStream()));
			pw = new PrintWriter(masterServer.getOutputStream(), true);
			new Thread(new ReadThread()).start();
			// authenticate
			loadingFrame.setText("Login...");
			send(new LoginPacket(ADMIN_KEY));
			Thread.currentThread().sleep(50);
			while (!authenticated) {
				Thread.currentThread().sleep(200);
				loadingFrame.setText("Login..");
				Thread.currentThread().sleep(200);
				loadingFrame.setText("Login...");
			}
			// LOGGED IN
			tableServer = new Server("MasterServer", "-", masterServer.getInetAddress().toString());
			mainFrame.serversPanel.repaintServers();
			
			new Thread(new TickThread()).start();
			loadingFrame.setVisible(false);
			mainFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			mainFrame.setVisible(false);
			loadingFrame.setVisible(false);
			Utils.popup("Fehler", e.getMessage());
			System.exit(0);
		}
	}

	public static void send(Packet p) {
		try {
			if (masterServer.isConnected())
				pw.println(p.getData().toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
