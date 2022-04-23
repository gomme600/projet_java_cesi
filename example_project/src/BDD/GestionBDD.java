package BDD;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import static org.junit.Assert.*;


import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class GestionBDD {

	public GestionBDD(){
		
	}
	
	public int enregistrerNewUser(String nom, String pass, String type) throws IOException
	{
		
		    String fileName="./database.db";
		
		    FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter(fileName, true);
				//inherited method from java.io.OutputStreamWriter 
				fileWriter.write(nom);
				fileWriter.write("+");
				fileWriter.write(pass);
				fileWriter.write("+");
				fileWriter.write(type);
				fileWriter.write(System.lineSeparator());
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (fileWriter != null) {
						fileWriter.flush();
						fileWriter.close();					
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
		return 1; 
		
	}
	
	public int verifierUtilisateur(String nom, String mdp) throws IOException
	{
		
		    String fileName="./database.db";
		
		    try (FileReader fileInvc = new FileReader(fileName);
		            BufferedReader readervc = new BufferedReader(fileInvc)) {
		            String readvc = readervc.readLine();
		            while (readvc != null) {
		                if (readvc.contains(nom+"+"+mdp+"+")) {
		                	if (readvc.contains(nom+"+"+mdp+"+"+"Gestionnaire de stock")) {
			                    return 0;
			                }
		                	if (readvc.contains(nom+"+"+mdp+"+"+"Caissier")) {
			                    return 1;
			                }
		                	if (readvc.contains(nom+"+"+mdp+"+"+"Responsable")) {
			                    return 2;
			                }
		                	if (readvc.contains(nom+"+"+mdp+"+"+"Gestionnaire de commande")) {
			                    return 3;
			                }
		                }
		                readvc = readervc.readLine();
		            }
		            return 4;
		       }
		
	}
	
}
