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

import Modele.commandes;

import java.awt.Color;
import javax.swing.JEditorPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Gestionnaire_de_commande extends JFrame {

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
	public Gestionnaire_de_commande() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Portail Gestionnaire de commande");
		lblNewLabel_1.setBounds(221, 23, 217, 14);
		contentPane.add(lblNewLabel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 48, 418, 206);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Commandes", null, panel_1, null);
		panel_1.setLayout(null);
		//panel_1.setLayout(null);
		
		JList list_1 = new JList();
		list_1.setBounds(0, 0, 302, 178);
		panel_1.add(list_1);
		
		JButton btnNewButton_1 = new JButton("Rafraichir");
		btnNewButton_1.setBounds(312, 55, 95, 23);
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
		panel_1.add(btnNewButton_1);
		
		JButton btnSuppr = new JButton("Supprimer");
		btnSuppr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            int index = list_1.getSelectedIndex();
	            System.out.println("Index Selected: " + index);
	            String s = (String) list_1.getSelectedValue();
	            System.out.println("Value Selected: " + s);
	            
	            String[] splited = s.split("\\s+");
	            
	            commandes.supprimerCommande(splited[0]);
	            
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
		btnSuppr.setBounds(312, 118, 95, 23);
		panel_1.add(btnSuppr);
		
		JButton btnNewButton_1_1 = new JButton("Approuver");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            int index = list_1.getSelectedIndex();
	            System.out.println("Index Selected: " + index);
	            String s = (String) list_1.getSelectedValue();
	            System.out.println("Value Selected: " + s);
	            
	            String[] splited = s.split("\\+");
	            
	            commandes.approuveCommande(splited[0], splited[1]);
	            commandes.supprimerCommande(splited[0]);
	            
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
		btnNewButton_1_1.setBounds(312, 89, 95, 23);
		panel_1.add(btnNewButton_1_1);
		
		JPanel panel = new JPanel();

		tabbedPane.addTab("Produits", null, panel, null);
		panel.setLayout(null);
		
		JList listproduits = new JList();
		listproduits.setBackground(Color.WHITE);
		listproduits.setBorder(new LineBorder(new Color(0, 0, 0)));
		listproduits.setBounds(0, 0, 306, 178);
		panel.add(listproduits);
		
		
		
		JButton btnNewButton = new JButton("Rafraichir");
		btnNewButton.setBounds(316, 60, 91, 23);
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
		panel.add(btnNewButton);

		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		            int index = listproduits.getSelectedIndex();
		            System.out.println("Index Selected: " + index);
		            String s = (String) listproduits.getSelectedValue();
		            System.out.println("Value Selected: " + s);
		            
		            String[] splited = s.split("\\s+");
		            
		            //ouvrir une fenetre
					Modifier_produit frame = new Modifier_produit();
					frame.setName(splited[0]);
					frame.setQuantite(splited[5]);
					frame.setPrix(splited[2]);
					frame.setVisible(true);
			}
		});
		btnModifier.setBounds(316, 94, 91, 23);
		panel.add(btnModifier);
		

		//Rafraichir les 2 listes lors du chargement de la fenetre
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

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(String nom) {
		this.lblNewLabel.setText(nom);
	}
}
