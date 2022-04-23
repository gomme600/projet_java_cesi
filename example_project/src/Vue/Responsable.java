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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		lblNewLabel_1.setBounds(301, 23, 137, 14);
		contentPane.add(lblNewLabel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 48, 418, 206);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();

		tabbedPane.addTab("Produits", null, panel, null);

		JList listproduits = new JList();
		panel.add(listproduits);
		
		JButton btnNewButton = new JButton("Rafraichir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button pressed !");
				try {
				FileInputStream fstream = new FileInputStream("./database.db");
			    DataInputStream in = new DataInputStream(fstream);
			    BufferedReader br = new BufferedReader(new InputStreamReader(in));
				DefaultListModel listModel = new DefaultListModel();
				String strLine;
				while ((strLine = br.readLine()) != null)   
				{
				        listModel.addElement(strLine); 
				        System.out.println(strLine);
				}

				listproduits.setModel(listModel);
				in.close();
				}
			    catch (Exception ee) {
			    }
			}
			
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Commandes", null, panel_1, null);
		
		JList list_1 = new JList();
		panel_1.add(list_1);
		
		JButton btnNewButton_1 = new JButton("Rafraichir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button pressed !");
				try {
				FileInputStream fstream = new FileInputStream("./database.db");
			    DataInputStream in = new DataInputStream(fstream);
			    BufferedReader br = new BufferedReader(new InputStreamReader(in));
				DefaultListModel listModel = new DefaultListModel();
				String strLine;
				while ((strLine = br.readLine()) != null)   
				{
				        listModel.addElement(strLine); 
				        System.out.println(strLine);
				}

				list_1.setModel(listModel);
				in.close();
				}
			    catch (Exception ee) {
			    }
			}
		});
		panel_1.add(btnNewButton_1);
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(String nom) {
		this.lblNewLabel.setText(nom);
	}
}
