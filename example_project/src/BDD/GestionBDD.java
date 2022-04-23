package BDD;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import static org.junit.Assert.*;

public class GestionBDD {

	public GestionBDD(){
		
	}
	
	public int enregistrerNewUser(String nom) throws IOException
	{
		
		    String fileName="./database.db";
		
		    RandomAccessFile stream = new RandomAccessFile(fileName, "rw");
		    FileChannel channel = stream.getChannel();
		    String value = "Hello";
		    byte[] strBytes = value.getBytes();
		    ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
		    buffer.put(strBytes);
		    buffer.flip();
		    channel.write(buffer);
		    stream.close();
		    channel.close();

		    // verify
		    RandomAccessFile reader = new RandomAccessFile(fileName, "r");
		    assertEquals(value, reader.readLine());
		    reader.close();
		
		return 1; 
	}
}
