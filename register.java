package com.example.vostro.acap;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class register extends AppCompatActivity {
    EditText tfname, tusername, tpassword, tpassword1, temail, tphone;
    Button btregister;
    Context context = this;
    LoginDataBaseAdapter loginDataBaseAdapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        tfname = (EditText) findViewById(R.id.tfname);
        tusername = (EditText) findViewById(R.id.etusername);
        tpassword = (EditText) findViewById(R.id.tpassword);
        tpassword1 = (EditText) findViewById(R.id.tpassword1);
        temail = (EditText) findViewById(R.id.temail);
        tphone = (EditText) findViewById(R.id.tphone);

        btregister = (Button) findViewById(R.id.btregister);
        btregister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String Fname = tfname.getText().toString();
                String Username = tusername.getText().toString();
                String Password = tpassword.getText().toString();
                String Confirmpassword = tpassword1.getText().toString();
                String Email = temail.getText().toString();
                String Phone = tphone.getText().toString();

                if (Fname.equals("") || Username.equals("")
                        || Password.equals("") || Confirmpassword.equals("") || Email.equals("") || Phone.equals("")) {

                    Toast.makeText(getApplicationContext(), "Field Vaccant",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                final EditText etusername = (EditText) findViewById(R.id.etusername);
                String username = etusername.getText().toString();
                String checkname = loginDataBaseAdapter.checkusername(Username);

                if (username.equals(checkname))
                {
                    Toast.makeText(register.this, "USERNAME ALREADY TAKEN!! TRY NEW ONE", Toast.LENGTH_LONG).show();

                } else
                {

                    if (!Password.equals(Confirmpassword)) {
                        Toast.makeText(getApplicationContext(),
                                "Password does not match", Toast.LENGTH_LONG)
                                .show();
                        return;
                    } else {

                        loginDataBaseAdapter.insertEntry(Fname, Username, Password, Email, Phone);
                        Toast.makeText(getApplicationContext(),
                                "Account Successfully Created ", Toast.LENGTH_LONG)
                                .show();
                        Intent i = new Intent(register.this, login.class);
                        startActivity(i);
                        finish();

                    }
                }
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "register Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.vostro.acap/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "register Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.vostro.acap/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

