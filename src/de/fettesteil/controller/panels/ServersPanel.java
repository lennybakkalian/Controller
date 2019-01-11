package de.fettesteil.controller.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import de.fettesteil.controller.Main;
import de.fettesteil.controller.Server;
import de.fettesteil.controller.TickThread;

public class ServersPanel extends JPanel {

	private DefaultTableModel tableModel;
	private String[] columnName = { "Status", "Name", "Standort", "Adresse", "Ping", "UUID" };
	private JTable serverList;

	public ServersPanel() {
		setLayout(new BorderLayout(0, 0));
		tableModel = new DefaultTableModel() {
			@Override
			public int getColumnCount() {
				return columnName.length;
			}

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}

			@Override
			public String getColumnName(int column) {
				return columnName[column];
			}
		};
		serverList = new JTable(tableModel);
		serverList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(serverList), BorderLayout.CENTER);
	}

	public void repaintServers() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				tableModel.setRowCount(0);
				tableModel.addRow(new Object[] { "ONLINE", Main.tableServer.getName(), "",Main.HOST + ":" + Main.PORT, String.valueOf(TickThread.ping), "" });
				for (Server s : Main.childServers)
					tableModel.addRow(new Object[] { s.isOnline() ? "ONLINE" : "OFFLINE", s.getName(), s.getLocation(),
							s.getAddress(), s.getPing(), s.getUuid().toString() });
				for (int i = 0; i < serverList.getColumnCount(); i++) {
					TableColumn column = serverList.getColumnModel().getColumn(i);
					column.setCellRenderer(new CustomRenderer());
					switch(i) {
					case 0:
						column.setMinWidth(60);
						column.setMaxWidth(60);
						break;
					case 4:
						// ping
						column.setMinWidth(40);
						column.setMaxWidth(40);
						break;
					}
				}
			}
		});
	}

	class CustomRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 6703872492730589499L;

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);
			if (row == 0) {
				cellComponent.setBackground(Color.BLACK);
				cellComponent.setForeground(Color.WHITE);
			}

			switch (column) {
			case 0:
				if (value.equals("OFFLINE"))
					setBackground(Color.RED);
				else {
					setBackground(Color.GREEN);
					setForeground(Color.BLACK);
				}
				break;
			}

			return cellComponent;
		}
	}
}
