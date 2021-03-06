package com.example.apnibank;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserHelper extends SQLiteOpenHelper {
    String TABLE_NAME = UserContract.UserEntry.TABLE_NAME;


    private static final String DATABASE_NAME = "User.db";


    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE = "CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " ("
                + UserContract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserContract.UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Ameya Joshi', 'ameya@gmail.com','7584','7895641238', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Rutuja Joshi', 'rutuja@gmail.com','1258','8995641238', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Rupali Joshi', 'rupali@gmail.com','8896','7595645896', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Rajendra Joshi', 'rajendra@gmail.com','7752','9995640038', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Prathamesh Bhosekar', 'prathamesh@gmail.com','3669','9095648962', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Om Gore', 'om@gmail.com','9985','8855640238', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Srishti Yadav', 'srishti@gmail.com','1207','8895640215', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Darshan Zambad', 'darshan@gmail.com','4522','9985021539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Kshiti Oak', 'kshiti@gmail.com','6582','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Rohit Patidar', 'rohit@gmail.com','5450','8292591201', 9900)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserContract.UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserContract.UserEntry.TABLE_NAME + " where " +
                UserContract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }
    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserContract.UserEntry.TABLE_NAME + " set " + UserContract.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserContract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}
