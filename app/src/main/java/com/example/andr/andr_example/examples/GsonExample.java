package com.example.andr.andr_example.examples;

import com.example.andr.andr_example.model.UserModel;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dev-haytham on 9/7/2017.
 */

public class GsonExample {

    private Gson mGson ;

    public GsonExample() {
        mGson = new Gson() ;
    }

    public String getJsonFromModel (UserModel user) {
        return  mGson.toJson(user) ;
    }

    public String OLDgetJson () {
        JSONObject obj = new JSONObject() ;
        try {
            obj.put("id", 10);
            obj.put("name", "adel");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj.toString() ;
    }

    public UserModel getUserFromJson (String gson) {
        return  mGson.fromJson(gson ,UserModel.class ) ;
    }

     public UserModel OLDgetModel (JSONObject obj) {
         UserModel user = null ;
         try {
              user = new UserModel(obj.getLong("id") , obj.getString("name") ,obj.getString("address")  ) ;
         } catch (JSONException e) {
             e.printStackTrace();
         }
         return user ;
     }

}
