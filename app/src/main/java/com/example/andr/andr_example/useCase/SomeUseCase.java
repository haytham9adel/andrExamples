package com.example.andr.andr_example.useCase;

import android.util.Log;

import com.example.andr.andr_example.application.ApplicationComponentImpl;
import com.example.andr.andr_example.helpers.Constants;
import com.example.andr.andr_example.model.GitRepo;
import com.google.gson.Gson;
import java.io.IOException;
import javax.inject.Inject;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dev-haytham on 9/7/2017.
 */


public class SomeUseCase {


    @Inject OkHttpClient client ;

     public SomeUseCase() {
         ApplicationComponentImpl.getInstance().getNetComponent().inject(this);
     }

     public void getGitHubRepo() {

         HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.GIT_REQUEST_EXAMPLE).newBuilder();
           urlBuilder.addQueryParameter("a" , "e") ;
           urlBuilder.addQueryParameter("b" , "f") ;
         String url = urlBuilder.toString() ;

         Request req = new Request.Builder().url(url).build() ;

         client.newCall(req).enqueue(new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {
                 Log.i("error in : " , e.getMessage()+"") ;
             }
             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 GitRepo[] repos =  new Gson().fromJson(response.body().string() ,GitRepo[].class ) ;
                 Log.i("response in : " , repos.length+"" ) ;
             }
         });
    }
}
