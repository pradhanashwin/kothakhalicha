package com.example.vostro.acap;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class listview extends AppCompatActivity
{
    LoginDataBaseAdapter loginDataBaseAdapter;
    ListView listView;
    TextView tusername;
    TextView address;
   // String Location;
    Context context = this;
    ArrayList<String> names = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);

        listView = (ListView) findViewById(R.id.listView);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        address = (TextView) findViewById(R.id.address);
        final Intent intent = getIntent();
        String Location = intent.getStringExtra("address");
        address.setText(Location);
        String location = address.getText().toString();
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = loginDataBaseAdapter.getListContents(location);

        if (data.getCount() == 0)
        {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        }
        else
        {
            while (data.moveToNext())
            {
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android. R.layout.simple_list_item_1,theList);
                //ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.display,theList);
                listView.setAdapter(listAdapter);

            }
        }
      //  listView.setAdapter(listAdapter);
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int position, long id)
            {

                Toast.makeText(getBaseContext(),parentView.getItemIdAtPosition(position)+"selected",Toast.LENGTH_SHORT).show();
                Intent ii = new Intent(listview.this, match.class);
                startActivity(ii);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
