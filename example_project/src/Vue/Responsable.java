package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Responsable extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Etudiant frame = new Etudiant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Responsable() {
		setTitle("Responsable");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Utilisateur");
		lblNewLabel.setBounds(10, 11, 256, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Portail Responsable");
		lblNewLabel_1.setBounds(323, 23, 115, 14);
		contentPane.add(lblNewLabel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 48, 418, 206);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Produits", null, panel, null);
		
		JList list = new JList();
		panel.add(list);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Commandes", null, panel_1, null);
		
		JList list_1 = new JList();
		panel_1.add(list_1);
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(String nom) {
		this.lblNewLabel.setText(nom);
	}
}
