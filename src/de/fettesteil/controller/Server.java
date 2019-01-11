package de.fettesteil.controller;

import java.util.UUID;

public class Server {

	private String name, location, address;
	private String ping = "";
	private boolean online;
	private UUID uuid;

	public Server(UUID uuid, String name, String location, String address, boolean online) {
		this.name = name;
		this.location = location;
		this.address = address;
		this.online = online;
		this.uuid = uuid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public void setPing(String ping) {
		this.ping = ping;
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
