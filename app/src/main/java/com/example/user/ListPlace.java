package com.example.user.mydelicious3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListPlace extends AppCompatActivity {
    ListView listPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_place);
        listPlace = (ListView) findViewById(R.id.lsPlace);

        int count =0;
        int i=0;

        Place place = new Place(this);
        Cursor contro = place.getAllPlace();
        contro.moveToFirst();
        while(contro.moveToNext()) {
            count++;
        };
        contro.moveToFirst();
        String[] names = new String[count];
        String[] images = new String[count];
        while(contro.moveToNext()) {
            names[i]=contro.getString(1);
            images[i]=contro.getString(6);
            i++;
        } ;
        PlaceAdapter placeAdapter = new PlaceAdapter(this, names, images);

        listPlace.setAdapter(placeAdapter);

        // Close the cursor to avoid a resource leak.
        contro.close();

        final Intent intent = new Intent(this,AddPlace.class);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_naviggation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        break;
                    case R.id.action_add:
                        Toast.makeText(ListPlace.this,"Action Add Clicked",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        break;
                    case R.id.action_account:
                        Toast.makeText(ListPlace.this,"Action Account Clicked",Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });


    }
}
