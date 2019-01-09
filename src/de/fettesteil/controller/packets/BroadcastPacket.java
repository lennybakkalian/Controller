package de.fettesteil.controller.packets;

import org.json.simple.JSONObject;

import de.fettesteil.controller.Utils;

public class BroadcastPacket {
	public static void process(JSONObject json) {
		Utils.popup((String) json.get("title"), (String) json.get("msg"));
	}
}
