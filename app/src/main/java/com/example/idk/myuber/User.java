import com.example.idk.myuber.Bike;

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
        bike = new Bike();
    }

    public String getNametName() {

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