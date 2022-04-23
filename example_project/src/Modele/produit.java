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
	
}
