package Modele;

import java.io.IOException;

import BDD.GestionBDD;

public class commandes {

	
	public static void creerCommande(String nom, String quantite) {
		GestionBDD g = new GestionBDD();
		
		try {
			g.creerCommande(nom, quantite);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void supprimerCommande(String nom) {
		GestionBDD g = new GestionBDD();
		
		try {
			g.supprimerCommande(nom);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void approuveCommande(String nom, String quantite) {
		GestionBDD g = new GestionBDD();
		
		try {
			g.approuveCommande(nom, quantite);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
