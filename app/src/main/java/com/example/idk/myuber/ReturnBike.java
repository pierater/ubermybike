package com.example.idk.myuber;

/**
 * Created by Gabriel on 3/14/2015.
 */
//description: this class represents the function that displays when the user
// of a bike returns it to its previous marker where it was originally. Then
// the user rates the bike and its performance out of 5(int) as well as displays the total
// price of renting the bike.
public class ReturnBike {
    private int user_rating;
    private double total_price;// would printout $5 if it was all day, or 5 or less dollars if it was hourly


    public ReturnBike(int user_rating, double total_price)
    {
        this.user_rating = user_rating;
        this.total_price = total_price;
    }

    public int getUser_rating(){
        return user_rating;
    }
    public double getTotal_price(){
        return total_price;
    }

    public void setUser_rating(int user_rating){
        this.user_rating = user_rating;
    }
    public void setTotal_price(double total_price){
        this.total_price = total_price;
    }


}
