package com.safewaydrive.derivesafe.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.widget.Toast;

import com.safewaydrive.derivesafe.R;

public class Navbar_Activity extends AppCompatActivity {


    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navbar);

        dl =findViewById(R.id.d1);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.dashboard:
                        Toast.makeText(Navbar_Activity.this, "Dashboard",Toast.LENGTH_SHORT).show();break;
                    case R.id.History:
                        Toast.makeText(Navbar_Activity.this, "History",Toast.LENGTH_SHORT).show();break;
                    case R.id.Google_Map:
                        Toast.makeText(Navbar_Activity.this, "Google Map",Toast.LENGTH_SHORT).show();
                    Intent mintent=new Intent(Navbar_Activity.this,MapsActivity.class);
                        startActivity(mintent);
                    break;
                    case R.id.aboutus:
                        Toast.makeText(Navbar_Activity.this, "About Us",Toast.LENGTH_SHORT).show();break;
                    default:
                        return true;
                }


                return true;

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
    }
