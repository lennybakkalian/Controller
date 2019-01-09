package de.fettesteil.controller.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.fettesteil.controller.Main;
import de.fettesteil.controller.Utils;
import de.fettesteil.controller.packets.AddServerPacket;
import javafx.geometry.HorizontalDirection;

public class AddServerPanel extends JPanel {

	private JTextField name, key, location, ip, port;
	private JButton submit;

	public AddServerPanel() {
		setLayout(null);
		name = new JTextField();
		key = new JTextField();
		location = new JTextField();
		ip = new JTextField();
		port = new JTextField();
		submit = new JButton("Erstellen");

		int xOff = 100;
		name.setBounds(new Rectangle(xOff, 20, 300, 30));
		key.setBounds(new Rectangle(xOff, 50, 300, 30));
		location.setBounds(new Rectangle(xOff, 80, 300, 30));
		ip.setBounds(new Rectangle(xOff, 110, 300, 30));
		port.setBounds(new Rectangle(xOff, 140, 300, 30));
		submit.setBounds(new Rectangle(xOff, 170, 300, 30));

		add(name);
		add(key);
		add(location);
		add(ip);
		add(port);
		add(submit);

		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// validate input
				String namestr = name.getText();
				String keystr = key.getText();
				String locationstr = location.getText();
				String ipstr = ip.getText();
				String portstr = ip.getText();
				int portint = -1;

				// just check clientside
				if (namestr.length() > 0 && namestr.length() < 100) {
					if (keystr.length() > 0 && keystr.length() < 100) {
						if (locationstr.length() > 0 && locationstr.length() < 100) {
							if (ipstr.length() > 0 && ipstr.length() < 100) {
								try {
									portint = Integer.valueOf(portstr);
								} catch (Exception e) {
									Utils.popup("Fehler", "Invalid number in 'Port' field");
									return;
								}
								// send packet
								Main.send(new AddServerPacket(namestr, keystr, locationstr, ipstr, portint));
							} else {
								Utils.popup("Fehler", "Invalid Length (Ip)");
							}
						} else {
							Utils.popup("Fehler", "Invalid Length (Location)");
						}
					} else {
						Utils.popup("Fehler", "Invalid Length (Key)");
					}
				} else {
					Utils.popup("Fehler", "Invalid Length (Name)");
				}
			}
		});

		JLabel namelbl = new JLabel("Name");
		JLabel keylbl = new JLabel("Key");
		JLabel locationlbl = new JLabel("Location");
		JLabel iplbl = new JLabel("Ip");
		JLabel portlbl = new JLabel("Port");
		namelbl.setBounds(new Rectangle(10, 20, 300, 30));
		keylbl.setBounds(new Rectangle(10, 50, 300, 30));
		locationlbl.setBounds(new Rectangle(10, 80, 300, 30));
		iplbl.setBounds(new Rectangle(10, 110, 300, 30));
		portlbl.setBounds(new Rectangle(10, 140, 300, 30));
		add(namelbl);
		add(keylbl);
		add(locationlbl);
		add(iplbl);
		add(portlbl);
	}
}
