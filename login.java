package com.example.vostro.acap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity
{
    Button btLogin;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        final EditText etUsername = (EditText)findViewById(R.id.etusername);
        final EditText etPassword = (EditText)findViewById(R.id.etpassword);
        Button btLogin = (Button)findViewById(R.id.btlogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String storedPassword = loginDataBaseAdapter
                        .getSinlgeEntry(userName);
                if (password.equals(storedPassword)) {
                    Toast.makeText(login.this,
                            "Congrats: Login Successful", Toast.LENGTH_LONG)
                            .show();

                    Intent main = new Intent(login.this, choice.class);
                    startActivity(main);
                }
                else
                {
                    Toast.makeText(login.this,
                            "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }




        }



               });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }
    public void register1(View view)
    {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
}

