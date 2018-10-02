import DAO.MongoDAO;
import Entity.Tracker;
import Entity.Tracking;
import Entity.Vehicle;
import com.mongodb.*;

import java.util.ArrayList;
import java.util.Set;

@SuppressWarnings("deprecation")
public class MoitrackDAO implements MongoDAO {

    private MongoClient mongoClient;
    private DBCollection collection;
    private DB database;

    private Integer YOUR_PORT = 00000000;

    public MoitrackDAO() {

        collection = null;
        this.mongoClient = new MongoClient("YOUR_HOST", YOUR_PORT);
        System.out.println();
        database = mongoClient.getDB("YOUR_DATABASE_NAME");
        Set<String> set = database.getCollectionNames();

        System.out.println("\nCollections: ");
        for(String s: set){
            System.out.println(s);
        }

        System.out.println();
    }

    private void switchCollections(String coll){
        this.collection = database.getCollection(coll);
    }

    /************** Vehicle functionality ***************/
    public ArrayList<DBObject> getAllVehicles() {

        switchCollections("vehicle");
        DBCursor cursor = collection.find();
        ArrayList<DBObject> objects = new ArrayList<DBObject>();

        while(cursor.hasNext()){
            objects.add(cursor.next());
        }

        return objects;
    }

    public DBObject getVehicleByRegistrationNumber(String registrationNumber) {

        switchCollections("vehicle");
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("registrationNumber", registrationNumber);
        DBCursor cursor = collection.find(searchQuery);

        return cursor.one();
    }

    public void addVehicle(Vehicle vehicle) {

        switchCollections("vehicle");
        BasicDBObject document = new BasicDBObject();
        document.put("_class", vehicle.get_class());
        document.put("name", vehicle.getName());
        document.put("imei", vehicle.getImei());
        document.put("registrationNumber", vehicle.getRegistrationNumber());
        document.put("description", vehicle.getDescription());
        document.put("key", vehicle.getKey());
        collection.insert(document);
    }

    public Boolean deleteVehicle(String registrationNumber) {

        switchCollections("vehicle");
        BasicDBObject document = new BasicDBObject();
        document.put("registrationNumber", registrationNumber);
        return (collection.remove(document).getN() == 1);
    }

    public Boolean updateVehicle(Vehicle vehicle) {

        switchCollections("vehicle");
        BasicDBObject original = new BasicDBObject();
        original.put("imei", vehicle.getImei());

        BasicDBObject newObject = new BasicDBObject();
        newObject.put("_class", vehicle.get_class());
        newObject.put("name", vehicle.getName());
        newObject.put("model", vehicle.getModel());
        newObject.put("key", vehicle.getKey());
        newObject.put("registrationNumber", vehicle.getRegistrationNumber());
        newObject.put("description", vehicle.getDescription());

        return (collection.update(original, newObject).getN() == 1);
    }


    /************** Tracker functionality ***************/
    public ArrayList<DBObject> getAllTracker() {

        switchCollections("tracker");
        DBCursor cursor = collection.find();
        ArrayList<DBObject> objects = new ArrayList<DBObject>();

        while(cursor.hasNext()){
            objects.add(cursor.next());
        }

        return objects;
    }

    public DBObject getTrackerByRegistrationNumber(String registrationNumber) {
        return null;
    }

    public void addTracker(Tracker tracker) {

    }

    public Boolean deleteTracker(String registrationNumber) {
        return null;
    }

    public Boolean updateTracker(Tracker tracker) {
        return null;
    }


    /************** Tracking functionality ***************/
    public ArrayList<DBObject> getAllTracking() {

        switchCollections("tracking");
        DBCursor cursor = collection.find();
        ArrayList<DBObject> objects = new ArrayList<DBObject>();

        while(cursor.hasNext()){
            objects.add(cursor.next());
        }

        return objects;
    }

    public DBObject getTrackingByRegistrationNumber(String registrationNumber) {
        return null;
    }

    public void addTracking(Tracking tracking) {

    }

    public Boolean deleteTracking(String registrationNumber) {
        return null;
    }

    public Boolean updateTracking(Tracking tracking) {
        return null;
    }
}
