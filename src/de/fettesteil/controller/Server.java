package de.fettesteil.controller;

public class Server {

	private String name, location, address;
	private String ping = "-";

	public Server(String name, String location, String address) {
		this.name = name;
		this.location = location;
		this.address = address;
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

}
