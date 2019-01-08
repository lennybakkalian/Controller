package de.fettesteil.controller;

import de.fettesteil.controller.packets.Packet;
import de.fettesteil.controller.packets.PingTestPacket;

public class TickThread implements Runnable {

	public static Long sendPing;
	public static int ping = 0;

	@Override
	public void run() {
		while (!Thread.currentThread().interrupted()) {
			synchronized (this) {
				try {

					// measure ping to MasterServer
					sendPing = System.currentTimeMillis();
					Main.send(new PingTestPacket(Packet.PINGTEST_SEND));

					Thread.currentThread().sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
