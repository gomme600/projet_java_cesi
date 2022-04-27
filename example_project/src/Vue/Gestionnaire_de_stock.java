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
import Modele.produit;

import java.awt.Color;
import javax.swing.JEditorPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class Gestionnaire_de_stock extends JFrame {

	protected static Object listproduits;
	private JPanel contentPane;
	JLabel lblNewLabel;

	//Fenetre gestionnaire de stock
	public Gestionnaire_de_stock() {
		setTitle("Gestionnaire de stock");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Utilisateur");
		lblNewLabel.setBounds(10, 11, 256, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Portail gestionnaire de stock");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(182, 23, 256, 14);
		contentPane.add(lblNewLabel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 48, 617, 444);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		
				tabbedPane.addTab("Produits", null, panel, null);
						panel.setLayout(null);
						
						JList listproduits = new JList();
						listproduits.setBackground(Color.WHITE);
						listproduits.setBorder(new LineBorder(new Color(0, 0, 0)));
						listproduits.setBounds(0, 0, 330, 416);
						panel.add(listproduits);
				
				JButton btnNewButton = new JButton("Rafraichir");
				btnNewButton.setBounds(342, 85, 108, 62);
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
								btnModifier.setBounds(478, 85, 108, 62);
								panel.add(btnModifier);
								
								JButton btnDelete = new JButton("Supprimer");
								btnDelete.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
							            int index = listproduits.getSelectedIndex();
							            System.out.println("Index Selected: " + index);
							            String s = (String) listproduits.getSelectedValue();
							            System.out.println("Value Selected: " + s);
							            
							            String[] splited = s.split("\\s+");
							            
							            produit.supprimerProduit(splited[0]);
							            
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
								btnDelete.setBounds(342, 169, 108, 62);
								panel.add(btnDelete);
								
								JButton btnAjouter = new JButton("Ajouter");
								btnAjouter.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
										//ouvrir une fenetre
										ajouter_produit frame = new ajouter_produit();
										frame.setVisible(true);
										
									}
								});
								btnAjouter.setBounds(478, 169, 108, 62);
								panel.add(btnAjouter);
								
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
								btnCommander.setBounds(413, 250, 108, 62);
								panel.add(btnCommander);
								
								
								//Ajout de tab Commandes
								JPanel panel_1 = new JPanel();
								tabbedPane.addTab("Commandes", null, panel_1, null);
								panel_1.setLayout(null);
								
								//Ajout de liste
								JList list_1 = new JList();
								list_1.setBounds(0, 0, 377, 416);
								panel_1.add(list_1);
								
								//Ajout de bouton
								JButton btnNewButton_1 = new JButton("Rafraichir");
								btnNewButton_1.setBounds(445, 112, 107, 71);
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
								btnSuppr.setBounds(445, 224, 107, 76);
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

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(String nom) {
		this.lblNewLabel.setText(nom);
	}
}
