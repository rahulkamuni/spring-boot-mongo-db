package com.rahul.springbootmongodb;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class TestMongoDb {

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient(new MongoClientURI(
				"mongodb://spring-boot-mongo-db:JhelTfNbpqmdvlOf954NKHSB0TJxiuNUPrMF9UWWEu5lmK8xXV5Rqd85sC5YIGrAE0N6ohDwidVAbpGYrU0KQg==@spring-boot-mongo-db.mongo.cosmos.azure.com:10255/?ssl=true&replicaSet=globaldb&maxIdleTimeMS=120000&appName=@spring-boot-mongo-db@&retrywrites=false"));
		List<String> databases = mongoClient.getDatabaseNames();

		System.out.println("Size------<" + databases.size());

		/**** Get database ****/
		// if database doesn't exists, MongoDB will create it for you
		DB db = mongoClient.getDB("testdb");

		/**** Get collection / table from 'testdb' ****/
		// if collection doesn't exists, MongoDB will create it for you
		DBCollection table = db.getCollection("user");

		/**** Insert ****/
		// create a document to store key and value
		BasicDBObject document = new BasicDBObject();
		document.put("name", "Rahul");
		document.put("age", 30);
		document.put("createdDate", new Date(System.currentTimeMillis()));
		table.insert(document);

		/**** Find and display ****/
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", "mkyong");

		DBCursor cursor = table.find(searchQuery);

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

		for (String dbName : databases) {
			System.out.println("- Database: " + dbName);

			DB db1 = mongoClient.getDB(dbName);

			Set<String> collections = db1.getCollectionNames();
			for (String colName : collections) {
				System.out.println("\t + Collection: " + colName);
			}
		}

		mongoClient.close();
	}
}
