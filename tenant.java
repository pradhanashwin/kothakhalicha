package com.example.vostro.acap;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class tenant extends AppCompatActivity
{
    LoginDataBaseAdapter loginDataBaseAdapter;
    Button btmatch;
   // Spinner sp;
   ListView listview;
    TextView text;
    ArrayList<String> names = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tenant);

       loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
         String username= getIntent().getStringExtra("Username");
        TextView tv = (TextView)(findViewById(R.id.etusername));
        tv.setText(username);
        final EditText etlocation = (EditText)findViewById(R.id.etlocation);
        final EditText etroom = (EditText)findViewById(R.id.etroom);
       // final TextView txt = (TextView)findViewById(R.id.txt);
        Button btmatch = (Button)findViewById(R.id.btmatch);

        btmatch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                String Location = etlocation.getText().toString();
                String Room = etroom.getText().toString();
               // String text = txt.getText().toString();

                String storedlocation = loginDataBaseAdapter.getSinlgeEntry1(Location);
                // sp.setAdapter(adapter);
                if (Location.equals(storedlocation))
                {

                    Toast.makeText(tenant.this, "Congrats: Match Found", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(tenant.this, listview.class);
                    intent.putExtra("address", etlocation.getText().toString());
                    startActivity(intent);

                   // etlocation.setText("");
                   // etroom.setText("");
                   // txt.setText("FAVOURABLE MATCHING");
                   // names.clear();

                  //  loginDataBaseAdapter.open();
                   // populate();
                    //here


                   /*  while (c.moveToNext())
                    {
                        String name = c.getString(1);
                        names.add(name);
                    }*/
                   // loginDataBaseAdapter.close();
                    //set
                    //  sp.setAdapter(adapter);


                }


                else
                {
                    etlocation.setText("");
                    etroom.setText("");
                    names.clear();
                    Toast.makeText(tenant.this,"No Match found.. Please try again later.",
                            Toast.LENGTH_LONG).show();
                }


            }


        });



}







    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }

}