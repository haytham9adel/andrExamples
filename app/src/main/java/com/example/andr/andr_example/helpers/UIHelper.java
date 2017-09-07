package com.example.andr.andr_example.helpers;

import android.widget.Toast;

import com.example.andr.andr_example.application.MyApp;

/**
 * Created by dev-haytham on 9/7/2017.
 */

public class UIHelper {



    public static void showToast(String msg) {
        Toast.makeText( MyApp.getAppContext() , msg , Toast.LENGTH_LONG  ) ;
    }
}
