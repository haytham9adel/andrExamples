package com.example.andr.andr_example.application;

import android.app.Application;
import android.content.Context;


/**
 * Created by dev-haytham on 9/7/2017.
 */

public class MyApp extends Application {


    @Override
    public void onCreate() {
       super.onCreate();


    }


    public static Context getAppContext() {
        return MyApp.getAppContext() ;
    }

}
