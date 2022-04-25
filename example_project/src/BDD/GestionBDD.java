package BDD;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import javax.swing.DefaultListModel;

import static org.junit.Assert.*;


import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
	public int ajouterProduit(String nom, String prix, String quantite) throws IOException
	{
		
		    String fileName="./produits.db";
		
			try {
				        String newLine = nom+" - "+prix+" e - "+quantite;
				        
				        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
			            bw.append(newLine);
			            bw.write(System.lineSeparator());
			            bw.flush();
			            bw.close();
			            
				        System.out.println("");
			}
		    catch (Exception ee) {
		    	System.out.println(ee); 
		    }
		
		return 1; 
		
	}
	
	
	
	public int creerCommande(String nom, String quantite) throws IOException
	{
		
		    String fileName="./commandes.db";
		
			try {
			FileInputStream fstream = new FileInputStream(fileName);
		    DataInputStream in = new DataInputStream(fstream);
		    LineNumberReader br = new LineNumberReader(new InputStreamReader(in));
			String strLine;
			int found = 0;
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
				        String[] old_quantity = strLine.split("\\+");
				        String old_quantite = old_quantity[1];
				        int old_quantite_int = Integer.parseInt(old_quantite);
				        int new_quantite_int = Integer.parseInt(quantite);
				        System.out.println("Old quantity: "+old_quantite);
				        System.out.println("New quantity: "+quantite);
				        String oldLine = nom+"\\+"+"[0-9]*";
				        String newLine = nom+"\\+"+Integer.toString((old_quantite_int+new_quantite_int));
				        //Replacing the old line with new line
				        fileContents = fileContents.replaceAll(oldLine, newLine);
				        //instantiating the FileWriter class
				        FileWriter writer = new FileWriter(fileName);
				        System.out.println("");
				        System.out.println("new data: "+fileContents);
				        writer.append(fileContents);
				        writer.flush();
				        writer.close();
				        
				        found = 1;
				        
				    }
			}
		    if(found == 0)
		    {
			    FileWriter fileWriter = null;
				try {
					fileWriter = new FileWriter(fileName, true);
					//inherited method from java.io.OutputStreamWriter 
					fileWriter.write(nom);
					fileWriter.write("+");
					fileWriter.write(quantite);
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
		    }
			in.close();
			}
		    catch (Exception ee) {
		    	System.out.println(ee); 
		    }
		
		return 1; 
		
	}
	
	public int supprimerCommande(String nom) throws IOException
	{
		
		    String fileName="./commandes.db";
		
			try {
				System.out.println("Element a supprimer : "+nom);
			    File file = new File(fileName);
			    File temp = new File("./_temp_");
			    PrintWriter out = new PrintWriter(new FileWriter(temp));
			    Files.lines(file.toPath())
			        .filter(line -> !line.contains(nom))
			        .forEach(out::println);
			    out.flush();
			    out.close();
			    Files.move(temp.toPath(), Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
			}
		    catch (Exception ee) {
		    	System.out.println(ee); 
		    }
		
		return 1; 
		
	}
	public int supprimerProduit(String nom) throws IOException
	{
		
	    String fileName="./produits.db";
	
		try {
			System.out.println("Element a supprimer : "+nom);
		    File file = new File(fileName);
		    File temp = new File("./_temp_");
		    PrintWriter out = new PrintWriter(new FileWriter(temp));
		    Files.lines(file.toPath())
		        .filter(line -> !line.contains(nom))
		        .forEach(out::println);
		    out.flush();
		    out.close();
		    Files.move(temp.toPath(), Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
		}
	    catch (Exception ee) {
	    	System.out.println(ee); 
	    }
	
	return 1; 
	
}
	
	public int approuveCommande(String nom, String quantite) throws IOException
	{
		
		    String fileName="./commandes.db";
		    String fileName2="./produits.db";
		
			try {
			FileInputStream fstream = new FileInputStream(fileName);
		    DataInputStream in = new DataInputStream(fstream);
		    LineNumberReader br = new LineNumberReader(new InputStreamReader(in));
			String strLine;
			
			FileInputStream fstream2 = new FileInputStream(fileName2);
		    DataInputStream in2 = new DataInputStream(fstream2);
		    LineNumberReader br2 = new LineNumberReader(new InputStreamReader(in2));
			String strLine2;
			
			while ((strLine = br.readLine()) != null)
			{
				    if(strLine.contains(nom))
				    {
				    	
						while ((strLine2 = br2.readLine()) != null)
						{
							    if(strLine2.contains(nom))
							    {

				    	System.out.println("line number " + br.getLineNumber() + " = " + strLine);
				    	
				    	
				        //Instantiating the Scanner class to read the file
				        Scanner sc = new Scanner(new File(fileName2));
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
				        System.out.println("Splitting : "+strLine2);
				        String[] data = strLine2.split(" ");
				        System.out.println("Getting price");
				        String prix = data[2];
				        System.out.println("Getting quantity");
				        String old_quantite = data[5];
				        int old_quantite_int = Integer.parseInt(old_quantite);
				        int new_quantite_int = Integer.parseInt(quantite);
				        System.out.println("Old quantity: "+old_quantite);
				        System.out.println("New quantity: "+quantite);
				        String oldLine = nom+" - "+"[0-9]*"+" e - "+"[0-9]*";
				        String newLine = nom+" - "+prix+" e - "+Integer.toString((old_quantite_int+new_quantite_int));
				        //Replacing the old line with new line
				        fileContents = fileContents.replaceAll(oldLine, newLine);
				        //instantiating the FileWriter class
				        FileWriter writer = new FileWriter(fileName2);
				        System.out.println("");
				        System.out.println("new data: "+fileContents);
				        writer.append(fileContents);
				        writer.flush();
				        writer.close();
				        
							    }
						}
						
				        
				        
				    }
			}
			in.close();
			in2.close();
			}
		    catch (Exception ee) {
		    	System.out.println(ee); 
		    }
		
		return 1; 
		
	}
	
}
