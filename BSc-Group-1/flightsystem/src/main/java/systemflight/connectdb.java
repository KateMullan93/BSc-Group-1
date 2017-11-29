package systemflight;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DB;
import com.mongodb.DBCollection;

import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

public class connectdb {
	
	public void connectdb(){  
	      
	      // Creating a Mongo client 
	      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	     
	      // Creating Credentials 
	    //  MongoCredential credential; 
	    //  credential = MongoCredential.createCredential("sampleUser", "myDb", 
	     //    "password".toCharArray()); 
	     // System.out.println("Connected to the database successfully");  
	      
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("myDb");  
	      
	      // Creating a collection 
	     // System.out.println("Collection created successfully"); 

	      // Retieving a collection
	      MongoCollection<Document> collection = database.getCollection("myCollection"); 
	      System.out.println("Collection myCollection selected successfully"); 
	      
	     //Inserting a collection
	      
	      Document document = new Document("title", "test") 
	    	      .append("id", 1)
	    	      .append("description", "database");
	    	      collection.insertOne(document); 
	    	      System.out.println("Document inserted successfully"); 
	    	      
	    	//get all documents in a collection
	   
	    	      // Getting the iterable object 
	    	      FindIterable<Document> iterDoc = collection.find(); 
	    	      int i = 1; 

	    	      // Getting the iterator 
	    	      Iterator it = iterDoc.iterator(); 
	    	    
	    	      while (it.hasNext()) {  
	    	         System.out.println(it.next());  
	    	      i++; 
	   }
	}}