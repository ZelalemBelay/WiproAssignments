package assignment_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class MainClass {

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		  FileOutputStream fout=new FileOutputStream("serializingFile.txt");  
		  ObjectOutputStream out=new ObjectOutputStream(fout);  
		  out.writeObject(new Double(5));  
		  out.writeObject(new Long(7));  
		  out.writeObject(new Date());  
		  out.flush();  
		  out.close();  
		  System.out.println("Success");
		  
		  ObjectInputStream in=new ObjectInputStream(new FileInputStream("serializingFile.txt"));  
		  Double i = (Double) in.readObject();
		  Long l = (Long) in.readObject();
		  Date d = (Date) in.readObject();
		  
		  System.out.println("Double Value: "+ i );
		  System.out.println("Long Value: "+ l );
		  System.out.println("Date Value: "+ d );
	}
}