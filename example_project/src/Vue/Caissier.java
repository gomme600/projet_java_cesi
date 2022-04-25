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

import java.awt.Color;
import javax.swing.JEditorPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;

public class Caissier extends JFrame {

	protected static Object listproduits;
	private JPanel contentPane;
	JLabel lblNewLabel;
	private JTextField textField;

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
	public Caissier() {
		setTitle("Caissier");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Utilisateur");
		lblNewLabel.setBounds(10, 11, 256, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Portail caissier");
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
								
								JButton btnDelete = new JButton("Bip boup");
								btnDelete.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
							            int index = listproduits.getSelectedIndex();
							            System.out.println("Index Selected: " + index);
							            String s = (String) listproduits.getSelectedValue();
							            System.out.println("Value Selected: " + s);
							            
							            String[] splited = s.split("\\s+");
							            String quantiteField = textField.getText();
							            if (quantiteField.isEmpty()) {
							            	 produit.decrementeProduit(splited[0],"1");
							            }else {
								            produit.decrementeProduit(splited[0],quantiteField);
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
								});
								btnDelete.setBounds(423, 180, 108, 62);
								panel.add(btnDelete);
								
								JLabel lblNewLabel_2 = new JLabel("Quantit\u00E9");
								lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
								lblNewLabel_2.setBounds(423, 89, 108, 14);
								panel.add(lblNewLabel_2);
								
								textField = new JTextField();
								textField.setBounds(433, 114, 86, 20);
								panel.add(textField);
								textField.setColumns(10);
								
								
								//Rafraichir la liste lors du chargement de la fenetre
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
