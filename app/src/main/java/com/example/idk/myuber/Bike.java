package com.example.idk.myuber;

/**
 * Created by Gabriel on 3/14/2015.
 */
public class Bike {
    //the bike class has 4 method variables

   private int bike_rating;
   private String GPS_coord;
   private String owner_name;

   //bike class constructor

    public Bike(int bike_rating, String GPS_coord, String owner_name){
        this.bike_rating = bike_rating;
        this.GPS_coord = GPS_coord;
        this.owner_name = owner_name;
    }
    public int getBike_rating(){
        return  bike_rating;
    }
    public String getGPS_coord(){
        return GPS_coord;
    }
    public String getOwner_name(){
        return owner_name;
    }
    public void setBike_rating(int bike_rating){
        this.bike_rating = bike_rating;
    }
    public void setGPS_coord(String GPS_coord){
        this.GPS_coord = GPS_coord;
    }
    public void setOwner_name(String owner_name){
        this.owner_name = owner_name;
    }



}
