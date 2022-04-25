package Modele;

import java.io.IOException;

import BDD.GestionBDD;

public class produit {

	
	public static void modifierProduit(String nom, String prix, String quantite) {
		GestionBDD g = new GestionBDD();
		
		try {
			g.modifierProduit(nom, prix, quantite);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void ajouterProduit(String nom, String prix, String quantite) {
		GestionBDD g = new GestionBDD();
		
		try {
			g.ajouterProduit(nom, prix, quantite);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void decrementeProduit(String nom, String quantite) {
		GestionBDD g = new GestionBDD();
		
		try {
			g.decrementeProduit(nom, quantite);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void supprimerProduit(String nom) {
		GestionBDD g = new GestionBDD();
		
		try {
			g.supprimerProduit(nom);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
