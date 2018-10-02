import com.mongodb.DBObject;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
//@SpringBootApplication
public class Initiator {

    private static ArrayList<DBObject> vehicles;
    private static ArrayList<DBObject> tracker;
    private static ArrayList<DBObject> tracking;

    static {
        vehicles = new ArrayList<DBObject>();
        tracker = new ArrayList<DBObject>();
        tracking = new ArrayList<DBObject>();
    }

    public static void main(String[] args) {

        MoitrackDAO moitrackDAO = new MoitrackDAO();

        /*Initiator.vehicles = moitrackDAO.getAllVehicles();
        Initiator.tracker = moitrackDAO.getAllTracker();
        Initiator.tracking = moitrackDAO.getAllTracking();

        System.out.println("\n************* Vehicles **************");
        PrintVehicles();
        System.out.println("************* Trackers **************");
        PrintTrackers();
        System.out.println("************* Entity.Tracking **************");
        PrintTracking();*/

        //PrintMap((HashMap<String, Object>) moitrackDAO.getVehicleByRegistrationNumber("CX14SGGP").toMap());
        /*moitrackDAO.addVehicle(new Entity.Vehicle("za.co.moitrack.data.Entity.Vehicle",
                                            "Jeep Savo 1988",
                                            "36154780312457",
                                            "FC23LOP1GP",
                                            "Testing Jeep",
                                            "TestVehicle-52125"));*/

        Initiator.vehicles = moitrackDAO.getAllVehicles();
        PrintVehicles();

//        SpringApplication.run(Initiator.class, args);
    }

    /**************** Printers ******************/
    public static void PrintVehicles(){

        HashMap<String, Object> map;
        for (DBObject dbObject: vehicles){

            map = (HashMap<String, Object>) dbObject.toMap();
            PrintMap(map);
            System.out.println();
        }
    }

    public static void PrintTracking(){

        HashMap<String, Object> map;
        for (DBObject dbObject: tracking){

            map = (HashMap<String, Object>) dbObject.toMap();
            PrintMap(map);
            System.out.println();
        }
    }

    public static void PrintTrackers(){

        HashMap<String, Object> map;
        for (DBObject dbObject: tracker){

            map = (HashMap<String, Object>) dbObject.toMap();
            PrintMap(map);
            System.out.println();
        }
    }

    public static void PrintMap(HashMap<String, Object> map){

        for(Map.Entry<String, Object> entry: map.entrySet()){

            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
