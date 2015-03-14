package com.example.idk.myuber;

/**
 * Created by Gabriel on 3/14/2015.
 * description: this class represents the bike that is ready for usage among other users of the app that you are able to click on, on the map.
 */
public class Bike {
    //the bike class has 6 method variables

   private int bike_rating;
   private String GPS_coord;
   private String owner_name;
   private Boolean isAvailable;
   private String lat;//coords latitude
   private String lon;//coords longitude


   //bike class constructor

    public Bike(int bike_rating, String GPS_coord, String owner_name, Boolean isAvailable, String lat, String lon){
        this.bike_rating = bike_rating;
        this.GPS_coord = GPS_coord;
        this.owner_name = owner_name;
        this.isAvailable = isAvailable;
        this.lat = lat;
        this.lon = lon;
    }
    //getters and setters for the method variables
    //NEED: to figure out where to connect the the variables to.

    public int getBike_rating(){
        return  bike_rating;
    }
    public String getGPS_coord(){
        return GPS_coord;
    }
    public String getOwner_name(){
        return owner_name;
    }
    public Boolean getIsAvailable(){ return isAvailable; }
    public String getLat() { return lat; }
    public String getLon() { return lon; }

    public void setBike_rating(int bike_rating){
        this.bike_rating = bike_rating;
    }
    public void setGPS_coord(String GPS_coord){
        this.GPS_coord = GPS_coord;
    }
    public void setOwner_name(String owner_name){
        this.owner_name = owner_name;
    }
    public void setIsAvailable(Boolean isAvailable) {this.isAvailable = isAvailable;}
    public void setLat(String lat) {this.lat = lat;}
    public void setLon(String lon) {this.lon = lon;}
}
