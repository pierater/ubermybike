package com.example.idk.myuber;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Httpget {

    String bike_lon;
    String bike_lat;
    String bike_num;
    int bike_rating;
    String owner_phone_num;
    static String owner_first_name;
    static String owner_last_name;
    String cc;
    String email;
    int experience;
    int user_rating;
    int owner_rating;
    String bike_owner_num;


    static JSONArray getJson(HttpEntity httpentity) {

        InputStream is = null;
        String received;
        JSONArray jObj = null;
        if(httpentity == null) {
            Log.v("NULL", "ISNULL");
        }

        try {
            is = httpentity.getContent();
        }

        catch (IllegalStateException e1) {
            Log.v("LOG", "EXCEPTION7");
            e1.printStackTrace();
        } catch (IOException e1) {
            Log.v("LOG", "EXCEPTION8");
            e1.printStackTrace();
        }

        try {
            if(is == null) {
                Log.d("ERRORR", "IT IS NULL");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            Log.v("LOG", "EXCEPTION10");
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            is.close();

            received = sb.toString();
            Log.v("LOG", "EXCEPTION11");
            if(received == null) {
                Log.v("LOG", "EXCEPTION12");
            }
            Log.v("LOG", "received" + received);
            jObj = new JSONArray(received);

        }
        catch (Exception e) {
            Log.v("LOG", "EXCEPTION1N");
            e.printStackTrace();

        }

        return jObj;

    }

    public JSONArray getBike(String lat, String lon) {

        String URL = "http://home.loosescre.ws/~keith/astwe/server.php?command=bike&lat=";
        URL += lat;
        URL += "&lon=";
        URL += lon;
        JSONArray result = null;

        try {

            HttpGet httpget = new HttpGet(URL);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();

            HttpResponse SetServerString;
            HttpClient Client = new DefaultHttpClient();
            SetServerString = Client.execute(httpget);

            HttpEntity httpentity = SetServerString.getEntity();


            result = getJson(httpentity);

        }

        catch (Exception e) {
            Log.v("LOG", "EXCEPTION1N");
            e.printStackTrace();
        }

        return result;
    }


    public class myTask extends AsyncTask<String, Void, JSONArray> {

        public myTask() {
            super();
        }

        @Override
        protected JSONArray doInBackground(String... params) {
            try {
                String URL = "http://home.loosescre.ws/~keith/astwe/server.php?command=user&number="+ params[0];
                HttpGet httpget = new HttpGet(URL);
                Log.v("URL", params[0]);

                ResponseHandler<String> responseHandler = new BasicResponseHandler();

                HttpResponse SetServerString;
                Log.v("LOG", "EXCEPTION3N");
                HttpClient Client = new DefaultHttpClient();
                HttpConnectionParams.setConnectionTimeout(Client.getParams(), 10000);
                Log.v("LOG", "EXCEPTION4N");
                SetServerString = Client.execute(httpget);
                ResponseHandler<String> handler = new BasicResponseHandler();
                //String body = handler.handleResponse(SetServerString);
                //Log.v("BODY", body);

                Log.v("LOG", "EXCEPTION5N");
                HttpEntity httpentity = SetServerString.getEntity();


                JSONArray result = getJson(httpentity);
                Log.v("RESULT", result.toString());
                return result;
            }
            catch (Exception e) {
                Log.v("LOG", "EXCEPTION2N");
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONArray obj) {
            parseUser(obj);
            Log.v("ERROR", "EXCEPTION6N");
        }
            }

    public JSONArray newBike(Bike new_bike) {

        String URL = "http://home.loosescre.ws/~keith/astwe/server.php?command=newbike&data=";

        JSONArray result = null;


        try {

            HttpGet httpget = new HttpGet(URL);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();

            HttpResponse SetServerString;
            HttpClient Client = new DefaultHttpClient();
            SetServerString = Client.execute(httpget);

            HttpEntity httpentity = SetServerString.getEntity();


            result = getJson(httpentity);

        }

        catch (Exception e) {
            Log.v("LOG", "EXCEPTIONN");
            e.printStackTrace();
        }

        return result;
    }

    public static void parseUser(JSONArray jObj) {


        try {
            JSONObject temp = jObj.getJSONObject(0);
            String first_name = temp.getString("first");
            Log.v("LOGG", first_name);
            owner_first_name = jObj.getJSONObject(0).toString();
            owner_last_name = jObj.getJSONObject(0).toString();
            Log.v("TEST", "NAME");
            Log.v("LOG", owner_first_name);
            Log.v("LOG", owner_last_name);
            /*cc = jObj.getString("card");
            owner_phone_num = jObj.getString("phone");
            email = jObj.getString("email");
            owner_rating = jObj.optInt("orating");
            user_rating = jObj.optInt("urating");
            experience = jObj.optInt("exp");
            */
        }
        catch (Exception e) {
            Log.v("LOG", "EXCEPTIONN");
            e.printStackTrace();
        }


    }

    public void parseBike(JSONArray jObj) {

        try {

            bike_num = jObj.getJSONObject(1).toString();
            Log.v("TEST", bike_num);
            /*
            bike_num = jObj.getString("bikeid");
            bike_rating = jObj.optInt("rating");
            bike_lat = jObj.getString("lat");
            bike_lon = jObj.getString("lon");
            bike_owner_num = jObj.getString("owner");
            */
        }
        catch (Exception e) {
            Log.v("LOG", "EXCEPTIONN");
            e.printStackTrace();
        }
    }

    public String getOwner_first_name() { return owner_first_name;}

    public String getOwner_last_name() { return owner_last_name;}

    public String getCc() { return cc;}

    public String getOwner_phone_num() { return owner_phone_num;}

    public String getEmail() { return email;}

    public int getOwner_rating() { return  owner_rating;}

    public int getUser_rating() { return user_rating;}

    public int getExperience() { return experience;}

    public String getBike_num() { return bike_num;}

    public int getBike_rating() { return bike_rating;}

    public String getBike_lat() { return bike_lat;}

    public String getBike_lon() { return bike_lon;}

    public String getBike_owner_num() { return bike_owner_num;}

}

