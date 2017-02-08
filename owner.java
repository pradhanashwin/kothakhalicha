package com.example.vostro.acap;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class owner extends AppCompatActivity
{
    EditText taddress, troom, tprice, tcable, tnet;
    TextView tusername;
    Button btsave;
    Context context = this;
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        String username= getIntent().getStringExtra("Username");
        TextView tv = (TextView)(findViewById(R.id.etusername));
        tv.setText(username);
        tusername = (TextView)findViewById(R.id.etusername);
        taddress = (EditText) findViewById(R.id.taddress);
        troom = (EditText) findViewById(R.id.etroom);
        tprice = (EditText) findViewById(R.id.tprice);
        tcable = (EditText) findViewById(R.id.tcable);
        tnet = (EditText) findViewById(R.id.tnet);

        btsave = (Button) findViewById(R.id.btsave);
        btsave.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String Username = tusername.getText().toString();
                String Address = taddress.getText().toString();
                String Room = troom.getText().toString();
                String Price = tprice.getText().toString();
                String Cable = tcable.getText().toString();
                String Net = tnet.getText().toString();

                if (Address.equals("") || Room.equals("")
                        || Price.equals("")|| Cable.equals("")|| Net.equals("") ) {

                    Toast.makeText(getApplicationContext(), "Field Vaccant",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                    loginDataBaseAdapter.insertEntryownerr(Username, Address, Room, Price, Cable,Net);
                    Toast.makeText(getApplicationContext(),
                            "DATA INSERTED ", Toast.LENGTH_LONG)
                            .show();




                    Intent i = new Intent(owner.this,home.class);
                    startActivity(i);
                    finish();


            }
        });
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }

    public void home(View view)
    {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}

