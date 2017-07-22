package maneesh.com.patientmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by manish on 22.07.17.
 */

public class DBHelperLogin extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PatientDB";
    public static final String DOCTOR_TABLE_NAME = "doctor";
    public static final String DOCTOR_USERNAME = "username";
    public static final String DOCTOR_PASSWORD = "password";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            "create table " + DOCTOR_TABLE_NAME +
                " (username varchar(25) primary key, password varchar(25))"
        );

        db.execSQL("INSERT INTO " + DOCTOR_TABLE_NAME + " (" + DOCTOR_USERNAME + "," + DOCTOR_PASSWORD + ")VALUES ('maneeshsin', 'test')");
        db.execSQL("INSERT INTO " + DOCTOR_TABLE_NAME + " (" + DOCTOR_USERNAME + "," + DOCTOR_PASSWORD + ")VALUES ('admin', 'admin')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS doctor");
        onCreate(db);

    }

    public DBHelperLogin(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    public Cursor getData(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + DOCTOR_TABLE_NAME + " where username " + "=?", new String[]{username});
        return res;
    }

    public boolean insertUser (String userName, String namePassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues user = new ContentValues();
        user.put(DOCTOR_USERNAME, userName);
        user.put(DOCTOR_PASSWORD, namePassword);
        db.insert(DOCTOR_TABLE_NAME, null, user);
        return true;
    }
}
