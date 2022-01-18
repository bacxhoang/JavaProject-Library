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
		setBounds(100, 100, 583, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 540, 531);
		contentPane.add(tabbedPane);
		
		
		BookPanel bookPanel = new BookPanel();
		bookPanel.table.setBounds(25, 503, 510, -468);
		tabbedPane.addTab("Book", null, bookPanel, null);
		bookPanel.setLayout(null);
		
		AuthorPanel authorPanel = new AuthorPanel();
		tabbedPane.addTab("Author", null, authorPanel, null);
		
		BorrowerPanel borrowerPanel = new BorrowerPanel();
		borrowerPanel.table.setBounds(25, 485, 510, -450);
		tabbedPane.addTab("Borrower", null, borrowerPanel, null);
		
		CategoryPanel categoryPanel = new CategoryPanel();
		tabbedPane.addTab("Category", null, categoryPanel, null);
		
		StaffPanel staffPanel = new StaffPanel();
		tabbedPane.addTab("Staff", null, staffPanel, null);
		
		StudentPanel studentPanel = new StudentPanel();
		tabbedPane.addTab("Student", null, studentPanel, null);
		

	}

}
