package com.example.vostro.acap;

import android.database.Cursor;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class match extends AppCompatActivity {


    LoginDataBaseAdapter loginDataBaseAdapter;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match);

     //   sp= (Spinner) findViewById(R.id.spinner);
        final LoginDataBaseAdapter db  = new LoginDataBaseAdapter(this);


        String location= getIntent().getStringExtra("LOCATION");
        TextView tv = (TextView)(findViewById(R.id.etlocation));
        tv.setText(location);

    }



}
