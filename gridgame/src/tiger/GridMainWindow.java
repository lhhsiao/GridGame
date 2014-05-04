package tiger;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class GridMainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GridMainWindow window = new GridMainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GridMainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 478, 323);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, "name_1399087871662371000");
		desktopPane.setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setResizable(true);
		internalFrame.setBounds(6, 6, 146, 137);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		internalFrame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon(GridMainWindow.class.getResource("/tiger/images.jpeg")));
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GridMainWindow.class.getResource("/tiger/2.jpeg")));
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel.add(btnNewButton_8);
		
		
		JInternalFrame internalFrame_1 = new JInternalFrame("New JInternalFrame");
		internalFrame_1.setBounds(166, 6, 146, 137);
		desktopPane.add(internalFrame_1);
		
		JInternalFrame internalFrame_2 = new JInternalFrame("New JInternalFrame");
		internalFrame_2.setBounds(326, 6, 146, 137);
		desktopPane.add(internalFrame_2);
		
		JInternalFrame internalFrame_3 = new JInternalFrame("New JInternalFrame");
		internalFrame_3.setBounds(6, 155, 146, 137);
		desktopPane.add(internalFrame_3);
		
		JInternalFrame internalFrame_4 = new JInternalFrame("New JInternalFrame");
		internalFrame_4.setBounds(166, 155, 146, 137);
		desktopPane.add(internalFrame_4);
		
		JInternalFrame internalFrame_5 = new JInternalFrame("New JInternalFrame");
		internalFrame_5.setBounds(326, 155, 146, 137);
		desktopPane.add(internalFrame_5);
		internalFrame_5.setVisible(true);
		internalFrame_4.setVisible(true);
		internalFrame_3.setVisible(true);
		internalFrame_2.setVisible(true);
		internalFrame_1.setVisible(true);
		internalFrame.setVisible(true);

	}
}
