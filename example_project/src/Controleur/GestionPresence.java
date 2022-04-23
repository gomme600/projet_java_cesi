package Controleur;

import java.awt.EventQueue;
import java.io.IOException;

import BDD.GestionBDD;
import Vue.Inscription;

import java.io.IOException;

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
		
		try {
			g.enregistrerNewUser(nom);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
