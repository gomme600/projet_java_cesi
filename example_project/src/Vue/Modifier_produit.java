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

import Modele.produit;

public class Modifier_produit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
	public Modifier_produit() {
		setTitle("Modifier Produit");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 357, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produit");
		lblNewLabel.setBounds(129, 24, 109, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(156, 67, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 118, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(156, 175, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(73, 70, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantit\u00E9");
		lblNewLabel_2.setBounds(73, 121, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Prix");
		lblNewLabel_3.setBounds(73, 178, 60, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Mettre \u00E0 jour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produit.modifierProduit(textField.getText(), textField_2.getText(), textField_1.getText());
			}
		});
		btnNewButton.setBounds(73, 219, 179, 23);
		contentPane.add(btnNewButton);
	}


	public void setName(String nom) {
		this.textField.setText(nom);
	}
	
	public void setQuantite(String nom) {
		this.textField_1.setText(nom);
	}
	
	public void setPrix(String nom) {
		this.textField_2.setText(nom);
	}
	

}
