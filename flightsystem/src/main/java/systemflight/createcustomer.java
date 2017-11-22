package systemflight;

import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase; 

import org.bson.Document;  
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  

public class createcustomer extends connectdb {
   
   public static void main( String args[] ) {  
      
      // Accessing the database 
      MongoDatabase database = mongo.getDatabase("myDb"); 

      // Retrieving a collection
      MongoCollection<Document> collection = database.getCollection("sample"); 
      System.out.println("Collection sample selected successfully");

      Document document = new Document("title", "MongoDB") 
      .append("id", 1)
      .append("description", "database") ;
      collection.insertOne(document); 
      System.out.println("Document inserted successfully");  
 
   }
}