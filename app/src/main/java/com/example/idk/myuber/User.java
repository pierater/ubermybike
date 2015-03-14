import com.example.idk.myuber.Bike;
import com.example.idk.myuber.Httpget;

import org.json.JSONObject;

public class User {

    public String name;
    public Bike bike;
    public String phone_number;
    public String email;
    public int rating;
    public int experience;

    public User(String startname, String startphone_number, String startemail, Bike bike) {

        name = startname;
        phone_number = startphone_number;
        email = startemail;
        String bike_lat;
        String bike_lon;
        Httpget get;
        JSONObject obj = null;
        get = new Httpget();
        obj = get.getBike("36.99", "-122");
        get.parseBike(obj);
        bike_lat = get.getBike_lat();
        bike_lon = get.getBike_lon();


    }

    public String getName() {

        return name;
    }

    public Bike getBike() {

        return bike;
    }

    public String getPhone_number() {

        return phone_number;
    }

    public String getEmail() {

        return email;
    }

    public int getRating() {

        return rating;
    }

    public int getExperience() {

        return experience;
    }
}
