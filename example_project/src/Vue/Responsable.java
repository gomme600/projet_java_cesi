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
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JEditorPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{78, 71, 91, 1, 79, 0};
		gbl_panel.rowHeights = new int[]{23, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JList listproduits = new JList();
		listproduits.setBackground(Color.WHITE);
		listproduits.setBorder(new LineBorder(new Color(0, 0, 0)));
		listproduits.setBounds(10, 165, 229, -148);
		GridBagConstraints gbc_listproduits = new GridBagConstraints();
		gbc_listproduits.gridwidth = 2;
		gbc_listproduits.fill = GridBagConstraints.HORIZONTAL;
		gbc_listproduits.insets = new Insets(0, 0, 0, 5);
		gbc_listproduits.gridx = 0;
		gbc_listproduits.gridy = 0;
		panel.add(listproduits, gbc_listproduits);
		
		JButton btnCommander = new JButton("Commander");
		btnCommander.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		JButton btnNewButton = new JButton("Rafraichir");
		btnNewButton.setBounds(279, 27, 113, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button pressed !");
				try {
				FileInputStream fstream = new FileInputStream("./produits.db");
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
			    	System.out.println(ee); 
			    }
			}
			
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		//panel.setLayout(null);
	
		

		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifier.setBounds(279, 82, 113, 23);
		GridBagConstraints gbc_btnModifier = new GridBagConstraints();
		gbc_btnModifier.anchor = GridBagConstraints.WEST;
		gbc_btnModifier.insets = new Insets(0, 0, 0, 5);
		gbc_btnModifier.gridx = 3;
		gbc_btnModifier.gridy = 0;
		panel.add(btnModifier, gbc_btnModifier);
		btnCommander.setBounds(279, 133, 113, 23);
		GridBagConstraints gbc_btnCommander = new GridBagConstraints();
		gbc_btnCommander.anchor = GridBagConstraints.WEST;
		gbc_btnCommander.gridx = 4;
		gbc_btnCommander.gridy = 0;
		panel.add(btnCommander, gbc_btnCommander);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Commandes", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{123, 1, 79, 83, 0, 0};
		gbl_panel_1.rowHeights = new int[]{23, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		//panel_1.setLayout(null);
		
		JList list_1 = new JList();
		list_1.setBounds(223, 171, -213, -155);
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.gridwidth = 3;
		gbc_list_1.anchor = GridBagConstraints.WEST;
		gbc_list_1.insets = new Insets(0, 0, 0, 5);
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 0;
		panel_1.add(list_1, gbc_list_1);
		
		JButton btnNewButton_1 = new JButton("Rafraichir");
		btnNewButton_1.setBounds(274, 45, 114, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button pressed !");
				try {
				FileInputStream fstream = new FileInputStream("./commandes.db");
			    DataInputStream in = new DataInputStream(fstream);
			    BufferedReader br = new BufferedReader(new InputStreamReader(in));
				DefaultListModel listModel2 = new DefaultListModel();
				String strLine;
				while ((strLine = br.readLine()) != null)   
				{
				        listModel2.addElement(strLine); 
				        System.out.println(strLine); 
				}

				list_1.setModel(listModel2);
				in.close();
				}
			    catch (Exception ee) {
			    	System.out.println(ee); 
			    }
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 0;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnSuppr = new JButton("Supprimer");
		btnSuppr.setBounds(274, 105, 114, 23);
		GridBagConstraints gbc_btnSuppr = new GridBagConstraints();
		gbc_btnSuppr.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSuppr.gridx = 4;
		gbc_btnSuppr.gridy = 0;
		panel_1.add(btnSuppr, gbc_btnSuppr);
		

		
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(String nom) {
		this.lblNewLabel.setText(nom);
	}
}
