package librarymanagement.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public abstract class AbstractPanel extends JDialog {
	private JTable table;
	public AbstractPanel() {
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(254, 63, 384, 293);
		getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBounds(430, 393, 85, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBounds(72, 393, 85, 21);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(253, 393, 85, 21);
		getContentPane().add(btnNewButton_2);
	}

	void handleBtnUpdate(ActionEvent evt) {
	}
	void handleBtnAdd(ActionEvent evt) {
	}
	void handleBtnDelete(ActionEvent evt) {
	}
	
}
