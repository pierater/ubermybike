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

    static String[][] coordinates = new String[2][10];
    static String[] bike_nums = new String[10];
    static int[] bike_ratings = new int[10];
    static String[] owner_array_phone_num = new String[10];
    static String[] owner_array_first_name = new String[10];
    static String[] owner_array_last_name = new String[10];
    static String cc;
    static String email;
    static int experience;
    static int user_rating;
    static int owner_rating;
    static String[] bike_owner_nums = new String[10];
    static int current_bikes;
    static String owner_first_name;
    static String owner_last_name;
    static String owner_phone_num;



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
            Log.v("LOG", String.valueOf(jObj.length()));
        }
        catch (Exception e) {
            Log.v("LOG", "EXCEPTION1N");
            e.printStackTrace();

        }
        Log.v("JSON", jObj.toString());
        return jObj;

    }

    public class bikeTask extends AsyncTask<String, Void, JSONArray> {

        public bikeTask() {
            super();
        }

        @Override
        protected JSONArray doInBackground(String... params) {
            try {

                String lat = "36.9999";
                String lon = "-122.054";
                String URL = "http://home.loosescre.ws/~keith/astwe/server.php?command=bike&lat=36.9999&lon=-122.054";
                HttpGet httpget = new HttpGet(URL);
                Log.v("URL1", URL);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();

                HttpResponse SetServerString;
                Log.v("LOG", "EXCEPTION3N");
                HttpClient Client = new DefaultHttpClient();
                HttpConnectionParams.setConnectionTimeout(Client.getParams(), 10000);
                Log.v("LOG", "EXCEPTION4N");
                SetServerString = Client.execute(httpget);
                ResponseHandler<String> handler = new BasicResponseHandler();

                Log.v("LOG", "EXCEPTION5N");
                HttpEntity httpentity = SetServerString.getEntity();


                JSONArray result = getJson(httpentity);
                Log.v("RESULT", result.toString());
                return result;
            } catch (Exception e) {
                Log.v("LOG", "EXCEPTION2N");
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onPostExecute(JSONArray jobj) {

            parseBike(jobj);
            MapsActivity.makeMarkers();
            Log.v("JSON", String.valueOf(jobj.length()));
        }
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
        public void onPostExecute(JSONArray jobj) {

            parseUser(jobj);
            Log.v("JSONUSER", String.valueOf(jobj.length()));
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
            JSONObject temp = jObj.getJSONObject(0); //sweg
            owner_first_name = temp.getString("first");
            owner_last_name = temp.getString("last");
            cc = temp.getString("card");
            owner_phone_num = temp.getString("phone");
            email = temp.getString("phone");
            owner_rating = Integer.parseInt(temp.getString("orating"));
            user_rating = Integer.parseInt(temp.getString("urating"));
            experience = Integer.parseInt(temp.getString("exp"));

        }
        catch (Exception e) {
            Log.v("LOG", "EXCEPTIONN");
            e.printStackTrace();
        }


    }

    public void parseBike(JSONArray jObj) {

        try {
            Log.v("LOGSS", String.valueOf(jObj.length()));

            for(int i = 0; i < jObj.length(); i++) {

                JSONObject temp = jObj.getJSONObject(i);
                coordinates[current_bikes][0] = temp.getString("lat");
                coordinates[current_bikes][1] = temp.getString("lon");
                bike_nums[current_bikes] = temp.getString("bikeid");

                bike_ratings[current_bikes] = Integer.parseInt(temp.getString("rating"));
                bike_owner_nums[current_bikes] = temp.getString("owner");
                current_bikes++;

            }


        }
        catch (Exception e) {
            //Log.v("LOG", String.valueOf(jObj.length()));
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

    public String getBike_nums(int index) { return bike_nums[index];}

    public int getBike_ratings(int index) { return bike_ratings[index];}

    public String[][] getCoordinates() { return coordinates;}

    public String getBike_owner_num(int index) { return bike_owner_nums[index];}

    public String getLat(int owner) {

        for(int i = 0; i < current_bikes; i++) {

            if(Integer.parseInt(bike_owner_nums[i]) == owner) {
                return coordinates[i][0];
            }
        }
        return null;
    }

    public String getLon(int owner) {

        for(int i = 0; i < current_bikes; i++) {

            if(Integer.parseInt(bike_owner_nums[i]) == owner) {
                return coordinates[i][1];
            }
        }
        return null;
    }

    public String getOwner(String lat, String lon) {

        for(int i = 0; i < current_bikes; i++) {

            if(coordinates[i][0].equals(lat) && coordinates[i][1].equals(lon)) {

                return bike_owner_nums[i];
            }
        }
        return null;
    }


}

