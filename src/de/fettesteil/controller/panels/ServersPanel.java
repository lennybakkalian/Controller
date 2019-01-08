package de.fettesteil.controller.panels;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ServersPanel extends JPanel {

	public JList<String> list;

	public ServersPanel() {
		setLayout(new BorderLayout());

		list = new JList<String>();
		add(list, BorderLayout.WEST);

	}
}
