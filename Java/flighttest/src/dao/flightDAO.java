package dao;



	import java.util.ArrayList;
	import java.util.List;

	import org.bson.types.ObjectId;

	import converter.flightconverter;
	import model.flight;
	import com.mongodb.BasicDBObjectBuilder;
	import com.mongodb.DBCollection;
	import com.mongodb.DBCursor;
	import com.mongodb.DBObject;
	import com.mongodb.MongoClient;

	//DAO class for different MongoDB CRUD operations
	//take special note of "id" String to ObjectId conversion and vice versa
	//also take note of "_id" key for primary key
	public class flightDAO {

		private DBCollection col;

		public flightDAO(MongoClient mongo) {
			this.col = mongo.getDB("journaldev").getCollection("Persons");
		}

		public flight createPerson(flight p) {
			DBObject doc = flightconverter.toDBObject(p);
			this.col.insert(doc);
			ObjectId id = (ObjectId) doc.get("_id");
			p.setId(id.toString());
			return p;
		}

		public void updatePerson(flight p) {
			DBObject query = BasicDBObjectBuilder.start()
					.append("_id", new ObjectId(p.getId())).get();
			this.col.update(query, flightconverter.toDBObject(p));
		}

		public List<flight> readAllPerson() {
			List<flight> data = new ArrayList<flight>();
			DBCursor cursor = col.find();
			while (cursor.hasNext()) {
				DBObject doc = cursor.next();
				flight p = flightconverter.toPerson(doc);
				data.add(p);
			}
			return data;
		}

		public void deletePerson(flight p) {
			DBObject query = BasicDBObjectBuilder.start()
					.append("_id", new ObjectId(p.getId())).get();
			this.col.remove(query);
		}

		public flight readPerson(flight p) {
			DBObject query = BasicDBObjectBuilder.start()
					.append("_id", new ObjectId(p.getId())).get();
			DBObject data = this.col.findOne(query);
			return flightconverter.toPerson(data);
		}

	}
