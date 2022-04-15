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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Inscription extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JPanel panel = new JPanel();
	JButton btnIncrementer ;
	JButton btnDcrementer;
	JPanel panel_1 ;
	private JLabel lblCompteur;
	int compteur = 0;
	private JTextField textField_1;
	private JLabel lblUtilisateur;
	private JButton btnConnexion;
	private JButton btnEnregistrer;


	public Inscription() {
		setTitle("Inscription");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		panel.setBounds(12, 30, 230, 197);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setBounds(12, 55, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		btnIncrementer = new JButton("Incrementer");
		btnIncrementer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// code qui correspond au click de la sourie
				incrementer();
				
			}
		});
		btnIncrementer.setBounds(12, 90, 97, 25);
		panel.add(btnIncrementer);
		
		btnDcrementer = new JButton("D\u00E9crementer");
		btnDcrementer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				decrementer(); 
			}
			
		});
		btnDcrementer.setBounds(12, 135, 97, 25);
		panel.add(btnDcrementer);
		
		lblCompteur = new JLabel("compteur");
		lblCompteur.setBounds(12, 13, 56, 16);
		panel.add(lblCompteur);
		
		panel_1 = new JPanel();
		panel_1.setBounds(258, 27, 162, 200);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 62, 116, 22);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		lblUtilisateur = new JLabel("utilisateur");
		lblUtilisateur.setBounds(12, 23, 56, 16);
		panel_1.add(lblUtilisateur);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seconecter();
			}
		});
		btnConnexion.setBounds(12, 142, 97, 25);
		panel_1.add(btnConnexion);
		
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EnregisterNouveauUtilisateur();
			}
		});
		btnEnregistrer.setBounds(12, 104, 97, 25);
		panel_1.add(btnEnregistrer);
	}

	void incrementer() {
		compteur ++;
		textField.setText(""+compteur);
	}
	
	void decrementer() {
		compteur --;
		textField.setText(""+compteur);
	}
	
	void seconecter() {
		// lire le contenu de la zone de texte et le comparer avec Alain et Ihab
		String utilisateur = textField_1.getText();
		
		if(utilisateur.equals("Ihab")) {
			//ouvrir une fenetre enseignant
			Formateur frame = new Formateur();
			frame.setLblNewLabel("Ihab");
			frame.setVisible(true);
		}
		
		if(utilisateur.equals("Alain")){
			//ouvrir une fenetre etudiant
			Etudiant frame = new Etudiant();
			frame.setLblNewLabel("Alain");
			frame.setVisible(true);
		}
	}
	
	void EnregisterNouveauUtilisateur() {
		String nom = textField_1.getText();
		GestionPresence.enregistrerUtilisateur(nom);
	}
}
