package driver;

import com.mongodb.DBCollection;
import connection.*;
import ui.HomeScreen;

public class Driver {
    public static void main(String[] args) {

        String host = "localhost";
        int port = 27017;
        String dbName = "SchoolDatabase";
        String collectionName = "ChicagoSchools";
        String url = "mongodb://" + host + ":" + port + "/" + dbName;

        Connector conn = new Connector(url, collectionName);
        DBCollection collection = conn.getCollection();

        HomeScreen hs = new HomeScreen(collection);
    }
}
