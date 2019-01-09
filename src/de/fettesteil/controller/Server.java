package de.fettesteil.controller;

import java.util.UUID;

public class Server {

	private String name, location, address;
	private String ping = "-";
	private boolean online;
	private UUID uuid;

	public Server(UUID uuid, String name, String location, String address, boolean online) {
		this.name = name;
		this.location = location;
		this.address = address;
		this.online = online;
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getAddress() {
		return address;
	}

	public String getPing() {
		return ping;
	}

	public void setPing(int ping) {
		this.ping = String.valueOf(ping);
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public UUID getUuid() {
		return uuid;
	}

}
