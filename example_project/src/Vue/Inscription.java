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
import java.util.Enumeration;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.TextField;
import javax.swing.SwingConstants;

public class Inscription extends JFrame {

	private JPanel contentPane;
	JPanel panel_1 ;
	int compteur = 0;
	private JTextField textField_1;
	private JLabel lblUtilisateur;
	private JButton btnConnexion;
	private JButton btnEnregistrer;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_2;
	private JLabel lblstatus;
	private JButton btnNewButton;

    //Fenetre inscription
	public Inscription() {
		setTitle("Inscription");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(229, 27, 191, 200);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		setTextField_1(new JTextField());
		getTextField_1().setBounds(90, 38, 89, 22);
		panel_1.add(getTextField_1());
		getTextField_1().setColumns(10);
		
		lblUtilisateur = new JLabel("utilisateur");
		lblUtilisateur.setBounds(10, 41, 69, 16);
		panel_1.add(lblUtilisateur);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seconecter();
			}
		});
		btnConnexion.setBounds(31, 150, 130, 25);
		panel_1.add(btnConnexion);
		
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EnregisterNouveauUtilisateur();
			}
		});
		btnEnregistrer.setBounds(31, 114, 130, 25);
		panel_1.add(btnEnregistrer);
		
		JLabel lblMotDePasse = new JLabel("mot de passe");
		lblMotDePasse.setBounds(10, 77, 78, 16);
		panel_1.add(lblMotDePasse);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 77, 89, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel titre = new JLabel("Gestion de stock");
		titre.setBounds(175, 6, 181, 16);
		contentPane.add(titre);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Gestionnaire de stock");
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(63, 48, 173, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Caissier");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(63, 87, 173, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Responsable");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(63, 135, 173, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Gestionnaire de commande");
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(63, 180, 173, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		lblstatus = new JLabel("");
		lblstatus.setBounds(10, 243, 173, 14);
		contentPane.add(lblstatus);
		
		btnNewButton = new JButton("Gestion des utilisateurs");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ouvrir une fenetre
				Gestion_utilisateurs frame = new Gestion_utilisateurs();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(229, 238, 191, 23);
		contentPane.add(btnNewButton);
	}
	
	void seconecter() {
		// lire le contenu de la zone de texte et le comparer avec la base de donnees
		String utilisateur = getTextField_1().getText();
		String mdp = getTextField_2().getText();
		
		int res = GestionPresence.verifierUtilisateur(utilisateur, mdp);

		if(res == 0) {
			//ouvrir une fenetre
			Gestionnaire_de_stock frame = new Gestionnaire_de_stock();
			frame.setLblNewLabel(utilisateur);
			frame.setVisible(true);
		}
		
		if(res == 1) {
			//ouvrir une fenetre
			Caissier frame = new Caissier();
			frame.setLblNewLabel(utilisateur);
			frame.setVisible(true);
		}
		
		if(res == 2) {
			//ouvrir une fenetre
			Responsable frame = new Responsable();
			frame.setLblNewLabel(utilisateur);
			frame.setVisible(true);
		}
		
		if(res == 3) {
			//ouvrir une fenetre
			Gestionnaire_de_commande frame = new Gestionnaire_de_commande();
			frame.setLblNewLabel(utilisateur);
			frame.setVisible(true);
		}
		
		if(res == 4) {
			//Changer status
			lblstatus.setText("Utilisateur invalide");
		}
		
	}
	
	void EnregisterNouveauUtilisateur() {
		String nom = getTextField_1().getText();
		String pass = getTextField_2().getText();
		String user_type = null;
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
		        AbstractButton button = buttons.nextElement();
		        if (button.isSelected()) {
		               user_type = button.getText();
		        }
		    }
		
		int status = GestionPresence.enregistrerUtilisateur(nom, pass, user_type);
		if (status == 0)
		{
			lblstatus.setText("Utilisateur enregistre !");
		}
		else
		{
			lblstatus.setText("Utilisateur existe deja !");
		}
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}
	
}
