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

import Modele.produit;
import Modele.utilisateur;

import java.awt.Color;
import javax.swing.JEditorPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class Gestion_utilisateurs extends JFrame {

	protected static Object listproduits;
	private JPanel contentPane;

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
	public Gestion_utilisateurs() {
		setTitle("Gestionnaire de stock");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Portail gestionnaire d'utilisateurs");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(182, 23, 256, 14);
		contentPane.add(lblNewLabel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 48, 617, 444);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		
				tabbedPane.addTab("Utilisateurs", null, panel, null);
						panel.setLayout(null);
						
						JList listproduits = new JList();
						listproduits.setBackground(Color.WHITE);
						listproduits.setBorder(new LineBorder(new Color(0, 0, 0)));
						listproduits.setBounds(0, 0, 330, 416);
						panel.add(listproduits);
				
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
						    	System.out.println(ee); 
						    }
				
				JButton btnNewButton = new JButton("Rafraichir");
				btnNewButton.setBounds(422, 135, 108, 62);
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
					    	System.out.println(ee); 
					    }
					}
					
				});
				panel.add(btnNewButton);
								
								JButton btnDelete = new JButton("Supprimer");
								btnDelete.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
							            int index = listproduits.getSelectedIndex();
							            System.out.println("Index Selected: " + index);
							            String s = (String) listproduits.getSelectedValue();
							            System.out.println("Value Selected: " + s);
							            
							            String[] splited = s.split("\\s+");
							            
							            utilisateur.supprimerUtilisateur(splited[0]);
							            
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
										    	System.out.println(ee); 
										    }
										
									}
								});
								btnDelete.setBounds(422, 220, 108, 62);
								panel.add(btnDelete);
		

		
	}

}
