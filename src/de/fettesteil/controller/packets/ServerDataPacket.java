package de.fettesteil.controller.packets;

import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import de.fettesteil.controller.Main;
import de.fettesteil.controller.Server;

public class ServerDataPacket {
	public static void process(JSONObject json) {

		boolean updateTable = false;
		JSONArray arr = (JSONArray) json.get("servers");
		for (Object o : arr) {
			JSONObject serverJson = (JSONObject) o;
			UUID uuid = UUID.fromString((String) serverJson.get("uuid"));
			String name = (String) serverJson.get("name");
			String location = (String) serverJson.get("location");
			String ping = (String) serverJson.get("ping");
			String address = (String) serverJson.get("address");
			// get server by uuid or create new if not exist
			Server s = Main.getByUUID(uuid);
			if (s == null) {
				s = new Server(uuid, name, location, address, true);
				s.setPing(ping);
				Main.childServers.add(s);
				updateTable = true;
			} else {
				if (!s.getName().equals(name)) {
					s.setName(name);
					updateTable = true;
				}
				if (!s.getLocation().equals(location)) {
					s.setLocation(location);
					updateTable = true;
				}
				if (!s.getPing().equals(ping)) {
					s.setPing(ping);
					updateTable = true;
				}
			}
		}

		if (updateTable)
			Main.mainFrame.serversPanel.repaintServers();

	}
}
