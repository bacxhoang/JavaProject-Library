package librarymanagement.api;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class UserHome {
	private JFrame UserHome;
    private JPanel contentPane;

	public void setVisible(boolean b) {
		UserHome.setVisible(true);
		
	}

    public UserHome(String userSes) {
    	UserHome = new JFrame();
    	UserHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	UserHome.setBounds(450, 190, 1014, 597);
    	UserHome.setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        UserHome.setContentPane(contentPane);
        contentPane.setLayout(null);
       
        JButton btnNewButton = new JButton("Logout");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                	UserHome.dispose();
                    UserLogin obj = new UserLogin();
                    obj.setVisible(true);
                }
                UserHome.dispose();
                UserLogin obj = new UserLogin();
                obj.setVisible(true);

            }
        });
 
    }
}