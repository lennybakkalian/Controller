package de.fettesteil.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import de.fettesteil.controller.packets.LoginResponse;
import de.fettesteil.controller.packets.Packet;
import de.fettesteil.controller.packets.PingTestPacket;

public class ReadThread extends Thread {

	@Override
	public void run() {
		while (!interrupted()) {
			synchronized (this) {
				try {
					String raw = Main.br.readLine();
					if (raw == null || raw.length() == 0)
						break;
					JSONObject json = (JSONObject) new JSONParser().parse(raw);
					int packetid = Integer.valueOf((String) json.get("packetid"));
					switch (packetid) {
					case Packet.LOGINRESPONSE:
						int status = Integer.valueOf((String) json.get("status"));
						if (status == LoginResponse.LOGIN_SUCCESS) {
							Main.authenticated = true;
							System.out.println("Authenticated!");
						} else {
							Main.loadingFrame.setVisible(false);
							Utils.popup("Fehler", "Authentifizierungsfehler");
							System.exit(0);
						}
						break;
					case Packet.PINGTEST_SEND:
						// send ping back
						Main.send(new PingTestPacket(Packet.PINGTEST_RECV));
						break;
					case Packet.PINGTEST_RECV:
						// calc ping
						int newPing = (int) (System.currentTimeMillis() - TickThread.sendPing);
						if(newPing != TickThread.ping){
							TickThread.ping = newPing;
							Main.mainFrame.serversPanel.repaintServers();
						}
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}
		}
		System.out.println("ReadThread stopped");
		System.exit(0);
	}
}
