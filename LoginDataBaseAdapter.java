package com.example.vostro.acap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by VOSTRO on 9/27/2016.
 */
public class LoginDataBaseAdapter
{
    //COLUMNS OF REGISTER
    static final String ROWID = "id";
    static final String FNAME = "name";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";
    static final String EMAIL = "email";
    static final String PHONE = "phone";


    //COLUMNS OF OWNER
    static final String ROWID1 = "id";
    static final String ADDRESS = "address";
   // static final String USERNAME = "username";
    static final String NUMOFROOM = "room";
    static final String PRICE = "price";
    static final String CABLE = "cable";
    static final String INTERNET = "internet";



    //DB PROPERTIES
    static final String DATABASE_NAME = "naya.db";
    static final String TABLE_NAME = "TABLE1";
    static final String TABLE_NAMEE = "TABLE2";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;

    //CREATE TABLE
    static final String TABLE_CREATE3 ="create table TABLE1("
            +"name TEXT NOT NULL,username TEXT NOT NULL, password TEXT NOT NULL, email TEXT NOT NULL, phone INTEGER NOT NULL ); ";


    static final String TABLE_CREATE2 ="create table TABLE2 ("
            +"username TEXT NOT NULL, address TEXT NOT NULL, room INTEGER NOT NULL, price INTEGER NOT NULL, cable INTEGER NOT NULL, internet INTEGER NOT NULL ); ";

    public SQLiteDatabase db;
    private final Context context;
    private DatabaseHelper dbHelper;

    public LoginDataBaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DatabaseHelper(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    public LoginDataBaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }


    //info register
    public void insertEntry(String Fname, String Username, String Password, String Email, String Phone)
    {



            ContentValues newValues = new ContentValues();
            newValues.put(FNAME, Fname);
            newValues.put(USERNAME, Username);
            newValues.put(PASSWORD, Password);
            newValues.put(EMAIL, Email);
            newValues.put(PHONE, Phone);
            db.insert(TABLE_NAME, null, newValues);



        //.....................................
                //....................................
    }



//owner insert
public void insertEntryownerr(String Username, String address, String room, String price, String cable, String net)
{


        ContentValues newValue = new ContentValues();
        newValue.put(USERNAME, Username);
        newValue.put(ADDRESS, address);
        newValue.put(NUMOFROOM, room);
        newValue.put(PRICE, price);
        newValue.put(CABLE, cable);
        newValue.put(INTERNET, net);
        db.insert(TABLE_NAMEE, null, newValue);


}
    //GET ALL VALUE

    ///
    public Cursor getListContents(String location)
    {
       // SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM TABLE2 WHERE "+ "ADDRESS"+ " ='"+location+"'", null);
        return data;
    }

    ///
    public Cursor getAllValues(String Location)
    {
        String[] columns={"address"};
        //return db.query(TABLE_NAMEE, columns, "address=?", null, null, null, null);
        //return db.query(TABLE_NAMEE,columns,null,null,null,null,null );
        return db.query(TABLE_NAMEE, null, " address=?",
                new String[] { Location }, null, null, null);

    }
    public int deleteEntry(String UserName) {

        String where = "USERNAME=?";
        int numberOFEntriesDeleted = db.delete("TABLE1", where,
                new String[] { UserName });
        return numberOFEntriesDeleted;
    }

    public String getSinlgeEntry(String Username)
    {

        Cursor cursor = db.query(TABLE_NAME, null, " username=?",
                new String[] { Username }, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("password"));
        cursor.close();
        return password;
    }
    ////check location
    public String getSinlgeEntry1(String Location)
    {
        Cursor cursor = db.query(TABLE_NAMEE, null, "address=?",
                new String[] { Location }, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String location = cursor.getString(cursor.getColumnIndex("address"));
        cursor.close();
        return location;
    }
//..........................check username.............................
public String checkusername(String username)
{
    Cursor cursor = db.query(TABLE_NAME, null, "username=?",
            new String[] { username }, null, null, null);
    if (cursor.getCount() < 1) {
        cursor.close();
        return "NOT EXIST";
    }
    if (cursor!= null)
    {
        cursor.moveToFirst();
    }
    cursor.moveToFirst();
    String Username = cursor.getString(cursor.getColumnIndex("username"));
    cursor.close();
    return Username;
}

    //.......................................................
    public void updateEntry(String userName, String password)
    {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD", password);

        String where = "USERNAME = ?";
        db.update("TABLE2", updatedValues, where, new String[] { userName });
    }



}
