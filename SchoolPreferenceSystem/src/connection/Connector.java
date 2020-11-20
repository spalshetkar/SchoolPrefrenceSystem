package connection;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Connector {

    private String url = null;
    private MongoClient client = null;
    private DB db = null;
    private DBCollection collection = null;

    public Connector(String url, String collectionName) {

        this.url = url;
        MongoClientURI uri = new MongoClientURI(url);
        client = new MongoClient(uri);
        db = client.getDB(uri.getDatabase());
        collection = db.getCollection(collectionName);
        System.out.println("Connection Established!");

    }

    public DBCollection getCollection() {
        return collection;
    }
}
