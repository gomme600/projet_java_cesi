package Vue;

//Imports
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

//Class Responsable
public class Responsable extends JFrame {

	//Le panel contenant les elements graphiques
	private JPanel contentPane;
	JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	//Constructeur Responsable
	public Responsable() {
		//Changer le titre de la fenetre
		setTitle("Responsable");
		//Changer l'action de fermeture (Fermer uniquement la fenetre, ne pas arreter l'application)
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Ajout de texte
		lblNewLabel = new JLabel("Utilisateur");
		lblNewLabel.setBounds(10, 11, 256, 39);
		contentPane.add(lblNewLabel);
		
		//Ajout de texte
		JLabel lblNewLabel_1 = new JLabel("Portail Responsable");
		lblNewLabel_1.setBounds(301, 23, 137, 14);
		contentPane.add(lblNewLabel_1);
		
		//Ajout de tabs
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 48, 418, 206);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();

		//Ajout du tab produits
		tabbedPane.addTab("Produits", null, panel, null);
		panel.setLayout(null);
		
		//Ajout de liste
		JList listproduits = new JList();
		listproduits.setBackground(Color.WHITE);
		listproduits.setBorder(new LineBorder(new Color(0, 0, 0)));
		listproduits.setBounds(0, 0, 281, 178);
		panel.add(listproduits);
		
		
		//Ajout de bouton
		JButton btnNewButton = new JButton("Rafraichir");
		btnNewButton.setBounds(291, 43, 116, 23);
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
	
		//Ajout de bouton
		JButton btnCommander = new JButton("Commander");
		btnCommander.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            int index = listproduits.getSelectedIndex();
	            System.out.println("Index Selected: " + index);
	            String s = (String) listproduits.getSelectedValue();
	            System.out.println("Value Selected: " + s);
	            
	            String[] splited = s.split("\\s+");
	            
	            //ouvrir une fenetre
				Creer_commande frame = new Creer_commande();
				frame.setName(splited[0]);
				//frame.setQuantite("0");
				frame.setVisible(true);
			}
		});

		//Ajout de bouton
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
		btnModifier.setBounds(291, 111, 116, 23);
		panel.add(btnModifier);
		btnCommander.setBounds(291, 77, 116, 23);
		panel.add(btnCommander);
		
		//Ajout de tab Commandes
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Commandes", null, panel_1, null);
		panel_1.setLayout(null);
		
		//Ajout de liste
		JList list_1 = new JList();
		list_1.setBounds(0, 0, 302, 178);
		panel_1.add(list_1);
		
		//Ajout de bouton
		JButton btnNewButton_1 = new JButton("Rafraichir");
		btnNewButton_1.setBounds(312, 55, 95, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button pressed !");
				//Rafraichir la liste
				try {
				//Fichier a charger
				FileInputStream fstream = new FileInputStream("./commandes.db");
			    DataInputStream in = new DataInputStream(fstream);
			    BufferedReader br = new BufferedReader(new InputStreamReader(in));
				DefaultListModel listModel2 = new DefaultListModel();
				String strLine;
				//Balayer toutes les lignes
				while ((strLine = br.readLine()) != null)   
				{
					    //Ajouter chaque ligne a une liste modele
				        listModel2.addElement(strLine); 
				        System.out.println(strLine); 
				}

				//appliquer la liste modele a notre liste
				list_1.setModel(listModel2);
				//Fermer le document
				in.close();
				}
			    catch (Exception ee) {
			    	System.out.println(ee); 
			    }
			}
		});
		panel_1.add(btnNewButton_1);
		
		//Action pour le bouton supprimer
		JButton btnSuppr = new JButton("Supprimer");
		btnSuppr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Affichier et obtenir la selection de la liste
	            int index = list_1.getSelectedIndex();
	            System.out.println("Index Selected: " + index);
	            String s = (String) list_1.getSelectedValue();
	            System.out.println("Value Selected: " + s);
	            
	            String[] splited = s.split("\\s+");
	            
	            //Appeler la methode supprimerCommande
	            commandes.supprimerCommande(splited[0]);
	            
	            //Rafraichir la liste
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
		btnSuppr.setBounds(312, 89, 95, 23);
		panel_1.add(btnSuppr);
		

		//Rafraichir les 2 listes lors du chargement de la fenetre
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

	//Methodes pour changer le texte d'un label
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(String nom) {
		this.lblNewLabel.setText(nom);
	}
	
	
	
}
