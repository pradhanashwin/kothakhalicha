package com.example.vostro.acap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class choice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);
        String username= getIntent().getStringExtra("Username");
        TextView tv = (TextView)(findViewById(R.id.etusername));
        tv.setText(username);
    }
    public void owner (View view)
    {
        TextView ed1;
        ed1 = (TextView)findViewById(R.id.etusername);
        String value = ed1.getText().toString();
        Intent intent = new Intent (this, owner.class);
        intent.putExtra("Username",value);
        startActivity(intent);
    }

    public void tenant (View view)
    {
        TextView ed1;
        ed1 = (TextView)findViewById(R.id.etusername);
        String value = ed1.getText().toString();
        Intent intent = new Intent (this, tenant.class);
        intent.putExtra("Username",value);
        startActivity(intent);
    }
}
