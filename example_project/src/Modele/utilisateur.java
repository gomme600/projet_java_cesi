package Modele;

import java.io.IOException;

import BDD.GestionBDD;

public class utilisateur {

	
	public static void supprimerUtilisateur(String nom) {
		GestionBDD g = new GestionBDD();
		
		try {
			g.supprimerUtilisateur(nom);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
