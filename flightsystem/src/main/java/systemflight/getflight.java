package systemflight;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class getflight extends connectdb{
	
	public static void main( String args[] ) {  
	      
	    
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("myDb");  
	      
	      // Retrieving a collection 
	      MongoCollection<Document> collection = database.getCollection("sample");
	      System.out.println("Collection sample selected successfully"); 

	      // Getting the iterable object 
	      FindIterable<Document> iterDoc = collection.find(); 
	      int i = 1; 

	      // Getting the iterator 
	      Iterator it = iterDoc.iterator(); 
	    
	      while (it.hasNext()) {  
	         System.out.println(it.next());  
	      i++; 
	      }
	   } 
	

}
