import com.example.idk.myuber.Bike;
import com.example.idk.myuber.Httpget;

import org.json.JSONArray;
import org.json.JSONObject;

public class User {

    private String first_name;
    private String last_name;
    private Bike bike;
    private String phone_number;
    private String email;
    private int rating;
    private int experience;

    public User(String start_first_name,String start_last_name, String startphone_number, String startemail, Bike bike) {

        first_name = start_first_name;
        last_name = start_last_name;
        phone_number = startphone_number;
        email = startemail;
        String bike_lat;
        String bike_lon;
        Httpget get;
        JSONArray obj = null;
        get = new Httpget();
        //obj = get.getBike("36.99", "-122");
        get.parseBike(obj);
        //bike_lat = get.getBike_lat();
        //bike_lon = get.getBike_lon();


    }

    public String getFirst_name() { return first_name;}

    public String getLast_name() { return last_name;}

    public Bike getBike() { return bike;}

    public String getPhone_number() { return phone_number;}

    public String getEmail() { return email;}

    public int getRating() { return rating;}

    public int getExperience() { return experience;}
}
