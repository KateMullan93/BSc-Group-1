import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.MongoClientOptions;

import java.awt.List;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

public class mongocon {
	
	 public static void main(String[] args) {

		    try {

			/**** Connect to MongoDB ****/
			// Since 2.10.0, uses MongoClient
			MongoClient mongo = new MongoClient("localhost", 27017);

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("flightbookingsystem");

			/**** Get collection / table from 'testdb' ****/
			// if collection doesn't exists, MongoDB will create it for you
			DBCollection table = db.getCollection("customer");
			DBCollection table1 = db.getCollection("price");
			DBCollection table2 = db.getCollection("priceconvert");

			/**** Insert ****/
			// create a document to store key and value
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
			document2.put("euro", 0.88);
			document2.put("gbp", 1.14);
			table2.insert(document3);
			

			/**** Find and display ****/
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", "kate");

			DBCursor cursor = table.find(searchQuery);

			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}

			/**** Update ****/
			// search document where name="mkyong" and update it with new values
			BasicDBObject query = new BasicDBObject();
			query.put("name", "kate");

			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("name", "kate-update");

			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			table.update(query, updateObj);

			/**** Find and display ****/
			BasicDBObject searchQuery2
			    = new BasicDBObject().append("name", "kate-update");

			DBCursor cursor2 = table.find(searchQuery2);

			while (cursor2.hasNext()) {
				System.out.println(cursor2.next());
			}

			/**** Done ****/
			System.out.println("Done");

		    } catch (MongoException e) {
			e.printStackTrace();
		    }

		  }
		}

