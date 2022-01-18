package librarymanagement.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class AbstractPanel extends JPanel {
	protected JTable table;
	private JTable table_1;

	public AbstractPanel() {
		super();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 546, 258);
		add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(47, 343, 85, 21);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBtnRefresh(e);
			}
		});
		add(btnRefresh);
		
		JButton btnNewAdd = new JButton("Add");
		btnNewAdd.setBounds(230, 343, 85, 21);
		btnNewAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBtnAdd(e);
			}
		});
		add(btnNewAdd);
		
		JButton btnNewDelete = new JButton("Delete");
		btnNewDelete.setBounds(408, 343, 85, 21);
		btnNewDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBtnDelete(e);
			}
		});
		add(btnNewDelete);
	}
	
	abstract void handleBtnRefresh(ActionEvent evt);
	abstract void handleBtnAdd(ActionEvent evt);
	abstract void handleBtnDelete(ActionEvent evt);
}