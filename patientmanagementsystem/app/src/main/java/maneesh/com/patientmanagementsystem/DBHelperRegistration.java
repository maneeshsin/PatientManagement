package maneesh.com.patientmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by manish on 22.07.17.
 */

public class DBHelperRegistration extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PatientDB";
    public static final String REGISTRATION_TABLE_NAME = "registration";
    public static final String REGISTRATION_ID = "registration_id";
    public static final String REGISTRATION_STATUS = "status";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            "create table " + REGISTRATION_TABLE_NAME +
                " (registration_id varchar(25) primary key, status INTEGAR NOT NULL default 0 )"
        );

        db.execSQL("INSERT INTO " + REGISTRATION_TABLE_NAME + " (" + REGISTRATION_ID + "," + REGISTRATION_STATUS + ")VALUES ('001', 1)");
        db.execSQL("INSERT INTO " + REGISTRATION_TABLE_NAME + " (" + REGISTRATION_ID + "," + REGISTRATION_STATUS + ")VALUES ('002', 1)");
        db.execSQL("INSERT INTO " + REGISTRATION_TABLE_NAME + " (" + REGISTRATION_ID + "," + REGISTRATION_STATUS + ")VALUES ('003', 1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + REGISTRATION_TABLE_NAME);
        onCreate(db);

    }

    public DBHelperRegistration(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public Cursor getData(String code) {
        SQLiteDatabase db = this.getReadableDatabase();
        //onUpgrade(db,0,0);
        Cursor res = db.rawQuery("select "+ REGISTRATION_STATUS +" from " + REGISTRATION_TABLE_NAME + " where " + REGISTRATION_ID  + " =?", new String[]{code});
        return res;
    }
    public boolean updateRegistrationStatus (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(REGISTRATION_STATUS, 0);
        db.update(REGISTRATION_TABLE_NAME, contentValues, REGISTRATION_ID+ " = ? ", new String[] { id } );
        return true;
    }

}
