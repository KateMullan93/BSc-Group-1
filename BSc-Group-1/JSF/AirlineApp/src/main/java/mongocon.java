import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.model.Projections;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.MongoClientOptions;

import java.awt.List;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

import org.bson.Document;

public class mongocon {
	
	 public static void main(String[] args) {

		    try {

			/**** Connect to MongoDB ****/
		
			MongoClient mongo = new MongoClient("localhost", 27017);

			/**** Get database ****/
			
			DB db = mongo.getDB("flightbookingsystem");

			/**** Get collection ****/
			
			DBCollection table = db.getCollection("customer");
			DBCollection table1 = db.getCollection("price");
			DBCollection table2 = db.getCollection("priceconvert");

			/**** Insert ****/
		
			BasicDBObject document = new BasicDBObject();
			document.put("name", "kate");
			document.put("age", 23);
			document.put("createdDate", new Date());
			table.insert(document);
			
			BasicDBObject document2 = new BasicDBObject();
			document2.put("flightid", "F001");
			document2.put("price", 300);
			table1.insert(document2);
			
			BasicDBObject document3 = new BasicDBObject();
			document3.put("flightid", "F002");
			document3.put("price", 350);
			table1.insert(document3);
			
			BasicDBObject document4 = new BasicDBObject();
			document4.put("euro", 0.88);
			document4.put("gbp", 1.14);
			table2.insert(document4);
			
			Document document5 = table1
				.find(new BasicDBObject("flight", "F001"))
				.projections(Projections.fields(Projections.include("price"), Projections.excludeId())).first();
			double price = document5.getDouble("price");
					
			
			
			/**** Find and display 
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("flight", "F001");

			DBCursor cursor = table2.find(searchQuery);

			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}****/
			
			

			/**** Update 
			
			BasicDBObject query = new BasicDBObject();
			query.put("name", "kate");

			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("name", "kate-update");

			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			table.update(query, updateObj); ****/

			/**** Find and display 
			BasicDBObject searchQuery2
			    = new BasicDBObject().append("name", "kate-update");

			DBCursor cursor2 = table.find(searchQuery2);

			while (cursor2.hasNext()) {
				System.out.println(cursor2.next());
			}****/

			/**** Done ****/
			System.out.println("Done");

			} catch (MongoException e) {
			e.printStackTrace();
		    } 

		  }
	 }

