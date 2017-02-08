package com.example.vostro.acap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }
             public void onClick1 (View view)
            {
                Intent intent = new Intent (this, login.class);
                startActivity(intent);
            }
            public void onClick2 (View view)
            {
                Intent intent = new Intent (this, newsfeed.class);
                startActivity(intent);
            }
             public void onClick3 (View view)
            {
                Intent intent = new Intent (this, aboutus.class);
                startActivity(intent);
            }
}

