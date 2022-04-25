package BDD;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

import javax.swing.DefaultListModel;

import static org.junit.Assert.*;


import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.DataInputStream;
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
	
	public int modifierProduit(String nom, String prix, String quantite) throws IOException
	{
		
		    String fileName="./produits.db";
		
			try {
			FileInputStream fstream = new FileInputStream(fileName);
		    DataInputStream in = new DataInputStream(fstream);
		    LineNumberReader br = new LineNumberReader(new InputStreamReader(in));
			String strLine;
			//while ((strLine = br.readLine()) != nom+" - "+prix+" e - "+quantite) 
			while ((strLine = br.readLine()) != null)
			{
				    if(strLine.contains(nom))
				    {
				    	System.out.println("line number " + br.getLineNumber() + " = " + strLine);
				    	
				    	
				        //Instantiating the Scanner class to read the file
				        Scanner sc = new Scanner(new File(fileName));
				        //instantiating the StringBuffer class
				        StringBuffer buffer = new StringBuffer();
				        //Reading lines of the file and appending them to StringBuffer
				        while (sc.hasNextLine()) {
				           buffer.append(sc.nextLine()+System.lineSeparator());
				        }
				        String fileContents = buffer.toString();
				        System.out.println("Contents of the file: "+fileContents);
				        //closing the Scanner object
				        sc.close();
				        String oldLine = nom+" - "+"[0-9]*"+" e - "+"[0-9]*";
				        String newLine = nom+" - "+prix+" e - "+quantite;
				        //Replacing the old line with new line
				        fileContents = fileContents.replaceAll(oldLine, newLine);
				        //instantiating the FileWriter class
				        FileWriter writer = new FileWriter(fileName);
				        System.out.println("");
				        System.out.println("new data: "+fileContents);
				        writer.append(fileContents);
				        writer.flush();
				        writer.close();
				        
				    }
			}
			in.close();
			}
		    catch (Exception ee) {
		    	System.out.println(ee); 
		    }
		
		return 1; 
		
	}
	
	
}
