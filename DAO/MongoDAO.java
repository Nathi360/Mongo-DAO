package DAO;

import Entity.Tracker;
import Entity.Tracking;
import Entity.Vehicle;
import com.mongodb.DBObject;

import java.util.Collection;

public interface MongoDAO {

    /************** Vehicle functionality ***************/
    Collection<DBObject> getAllVehicles();
    DBObject getVehicleByRegistrationNumber(String registrationNumber);
    void addVehicle(Vehicle vehicle);
    Boolean deleteVehicle(String registrationNumber);
    Boolean updateVehicle(Vehicle vehicle);


    /************** Tracker functionality ***************/
    Collection<DBObject> getAllTracker();
    DBObject getTrackerByRegistrationNumber(String registrationNumber);
    void addTracker(Tracker tracker);
    Boolean deleteTracker(String registrationNumber);
    Boolean updateTracker(Tracker tracker);


    /************** Tracking functionality ***************/
    Collection<DBObject> getAllTracking();
    DBObject getTrackingByRegistrationNumber(String registrationNumber);
    void addTracking(Tracking tracking);
    Boolean deleteTracking(String registrationNumber);
    Boolean updateTracking(Tracking tracking);

}
