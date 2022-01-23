package librarymanagement.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JTabbedPane;

import java.awt.FlowLayout;
import javax.swing.JTable;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 642, 531);
		contentPane.add(tabbedPane);
		
		BookPanel bookPane = new BookPanel();
		tabbedPane.addTab("Book", null, bookPane, null);
		
		AuthorPanel authorPane = new AuthorPanel();
		tabbedPane.addTab("Author", null, authorPane, null);
		
		CategoryPanel categoryPane = new CategoryPanel();
		tabbedPane.addTab("Category", null, categoryPane, null);
		
		BorrowerPanel borrowerPane = new BorrowerPanel();
		tabbedPane.addTab("Borrower", null, borrowerPane, null);
		
		StudentPanel studentPane = new StudentPanel();
		tabbedPane.addTab("Student", null, studentPane, null);
		
		


	}

}