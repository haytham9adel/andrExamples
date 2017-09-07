package com.example.andr.andr_example;

import android.os.Bundle;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.andr.andr_example.application.ApplicationComponentImpl;
import com.example.andr.andr_example.helpers.Constants;
import com.example.andr.andr_example.examples.GlideExample;
import com.example.andr.andr_example.examples.GsonExample;
import com.example.andr.andr_example.model.UserModel;
import com.example.andr.andr_example.useCase.SomeUseCase;

import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Inject
    SomeUseCase mSomeUseCase ;

    @BindView(R.id.glidTest)
     ImageView glido ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      try {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_drawer);

          // butterKnif
          ButterKnife.bind(this);
          // end butterKnif

          // start glide test
          GlideExample.loadUrlOnImgView(this, Constants.GLIDE_IMG, glido);
          // end glide test//


          // start GSON test
             GsonExample gsonExample = new GsonExample();
             UserModel userModel = new UserModel( 1L , "haytham" , "naser city" );
             String str = gsonExample.getJsonFromModel(userModel);
             Log.i("json: " , str ) ;
          // End GSON test

          // DAGGER 2
               ApplicationComponentImpl.getInstance().getUseCaseComponent().inject(this);
               mSomeUseCase.getGitHubRepo() ;
          // END DAGGER

          Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
          setSupportActionBar(toolbar);


          DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
          ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                  this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
          drawer.setDrawerListener(toggle);
          toggle.syncState();

          NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
          navigationView.setNavigationItemSelectedListener(this);
      }catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
