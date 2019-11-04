package MondoDBTest;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBConnection {
    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("shop");
            System.out.println("MongoDB connected");
            MongoCollection<Document> coll = db.getCollection("inventory");

            // Iterate over the documents
            FindIterable<Document> findIterable = coll.find();
            MongoCursor<Document> cursor = findIterable.iterator();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

            //Insert a Document into the database
            Document doc = new Document().append("item", "Envelopes").append("qty", 40);
            coll.insertOne(doc);
            System.out.println("Document inserted");

            // find all task documents.
            System.out.println("to find all the documents");
            for (Document cur : coll.find()) {
                System.out.println(cur.toJson());
            }

            // Find first document
            System.out.println("To find the first document");
            Document firstDoc = coll.find().first();
            System.out.println(firstDoc.toJson());

            //Get A Single Document That Matches a Filter
            System.out.println("Find a specific document");
            doc = coll.find(eq("item", "Books")).first();
            System.out.println(doc.toJson());

            // Update a Single Document
            coll.updateOne(eq("qty", 40), new Document("$set", new Document("qty", 110)));

            //Check for whether the document updated or not
            for (Document cur : coll.find()) {
                System.out.println(cur.toJson());
            }

            //to delete a document
            coll.deleteOne(eq("qty", 110));
            DeleteResult deleteResult = coll.deleteMany(eq("item", "Books"));
            System.out.println(deleteResult.getDeletedCount());
            mongoClient.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
