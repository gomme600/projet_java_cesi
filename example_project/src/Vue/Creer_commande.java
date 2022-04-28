package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controleur.GestionPresence;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Modele.commandes;
import Modele.produit;

public class Creer_commande extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	//Fenetre cree commande
	public Creer_commande() {
		setTitle("Modifier Produit");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 357, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produit");
		lblNewLabel.setBounds(138, 24, 109, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(156, 67, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 118, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(73, 70, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantit\u00E9");
		lblNewLabel_2.setBounds(73, 121, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Commander");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandes.creerCommande(textField.getText(), textField_1.getText());
			}
		});
		btnNewButton.setBounds(73, 171, 179, 23);
		contentPane.add(btnNewButton);
	}


	public void setName(String nom) {
		this.textField.setText(nom);
	}
	
	public void setQuantite(String nom) {
		this.textField_1.setText(nom);
	}
	
	

}
