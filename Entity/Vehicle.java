package Entity;

import com.mongodb.DBObject;

public class Vehicle {

    private String _class;
    private String model;
    private String name;
    private String imei;
    private String registrationNumber;
    private String description;
    private String key;

    public Vehicle() {
    }

    public Vehicle(String _class, String name, String imei, String registrationNumber, String description, String key) {
        this._class = _class;
        this.name = name;
        this.imei = imei;
        this.registrationNumber = registrationNumber;
        this.description = description;
        this.key = key;
    }

    public static Vehicle transformObject(DBObject object){

        Vehicle vehicle = new Vehicle();

        if(object != null){

            vehicle._class = object.get("_class").toString();
            vehicle.name = object.get("name").toString();
            vehicle.imei = object.get("imei").toString();
            vehicle.registrationNumber = object.get("registrationNumber").toString();
            vehicle.description = object.get("description").toString();
            vehicle.key = object.get("key").toString();
        }

        return vehicle;
    }

    @Override
    public String toString() {

        return "\nClass = '" + _class + '\'' +
                "\nName = '" + name + '\'' +
                "\nIMEI = '" + imei + '\'' +
                "\nRegistrationNumber = '" + registrationNumber + '\'' +
                "\nDescription = '" + description + '\'' +
                "\nKey = '" + key + '\'';
    }


    public String getModel() {
        return model;
    }

    public String get_class() {
        return _class;
    }

    public String getName() {
        return name;
    }

    public String getImei() {
        return imei;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getKey() {
        return key;
    }
}
