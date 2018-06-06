package com.example.user.mydelicious3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPlace extends AppCompatActivity {
    EditText pName, pAddress, pPrice, pPoint, pDescription, pImage;
    Button add, cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place);
        final Intent intent = new Intent (this,ListPlace.class);

        pName = (EditText)findViewById(R.id.edName);
        pAddress = (EditText)findViewById(R.id.edAddress);
        pPrice = (EditText)findViewById(R.id.edPrice);
        pPoint = (EditText)findViewById(R.id.edPoint);
        pDescription = (EditText)findViewById(R.id.edDescription);
        pImage = (EditText)findViewById(R.id.edImage);
        add = (Button)findViewById(R.id.btAdd);
        cancel = (Button)findViewById(R.id.btCancel);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, address,price, description, image;
                int point;
                name = pName.getText().toString();
                address = pAddress.getText().toString();
                price = pPrice.getText().toString();
                point = Integer.parseInt(pPoint.getText().toString());
                description = pDescription.getText().toString();
                image = pImage.getText().toString();
                Place nplace = new Place(AddPlace.this);
                nplace.addPlace(name,address,price,point,description,image);
                startActivity(intent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
