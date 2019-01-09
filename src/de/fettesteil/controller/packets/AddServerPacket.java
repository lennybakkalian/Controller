package de.fettesteil.controller.packets;

public class AddServerPacket extends Packet {

	public AddServerPacket(String name, String key, String location, String ip, int port) {
		super(Packet.ADD_SERVER);
		put("name", name);
		put("key", key);
		put("location", location);
		put("ip", ip);
		put("port", String.valueOf(port));
	}

}
