package Controleur;

import java.awt.EventQueue;

import BDD.GestionBDD;
import Vue.Inscription;

public class GestionPresence {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					Inscription frame = new Inscription();
					frame.setVisible(true);
				
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static void enregistrerUtilisateur(String nom) {
		GestionBDD g = new GestionBDD();
		
		g.enregistrerNewUser(nom); 
	}

}
