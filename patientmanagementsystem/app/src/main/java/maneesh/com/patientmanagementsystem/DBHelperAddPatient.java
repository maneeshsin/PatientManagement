package maneesh.com.patientmanagementsystem;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static maneesh.com.patientmanagementsystem.DBHelperLogin.DOCTOR_TABLE_NAME;

/**
 * Created by manish on 22.07.17.
 */

public class DBHelperAddPatient extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "PatientDB";
    public static final String ADD_PATIENT_TABLE_NAME = "addpatient";
    public static final String ADD_PATIENT_ID = "pid";
    public static final String ADD_PATIENT_FNAME = "pfame";
    public static final String ADD_PATIENT_LNAME = "plname";
    public static final String ADD_PATIENT_EMAIL = "pemail";
    public static final String ADD_PATIENT_MOBILE = "pmobile";
    public static final String ADD_PATIENT_AGE = "page";
    public static final String ADD_PATIENT_ADDRESS = "paddress";
    public static final String ADD_PATIENT_BLOOD_GROUP = "pbloodgroup";
    public static final String ADD_PATIENT_GENDER = "pgender";


    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ") ;
        sb.append(ADD_PATIENT_TABLE_NAME);
        sb.append("(");
        sb.append(ADD_PATIENT_ID);
        sb.append(" INTEGAR PRIMARY KEY AUTOINCREMENT, ");
        sb.append(ADD_PATIENT_FNAME); sb.append(" varchar(255),");
        sb.append(ADD_PATIENT_EMAIL); sb.append(" varchar(255),");
        sb.append(ADD_PATIENT_EMAIL); sb.append(" varchar(255),");
        sb.append(ADD_PATIENT_EMAIL); sb.append(" varchar(255),");

        sb.append(ADD_PATIENT_AGE); sb.append(" INTEGAR,");

        sb.append(ADD_PATIENT_ADDRESS); sb.append(" varchar(255),");
        sb.append(ADD_PATIENT_BLOOD_GROUP); sb.append(" varchar(255),");
        sb.append(ADD_PATIENT_GENDER); sb.append(" varchar(255),");
        sb.append(")");

        int i = 0;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ADD_PATIENT_TABLE_NAME);
        onCreate(db);

    }

    public DBHelperAddPatient(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public Cursor getData(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + DOCTOR_TABLE_NAME + " where username " + "=?", new String[]{username});
        return res;
    }

    public boolean insertPatientInfo (String userName, String namePassword) {
        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues user = new ContentValues();
//        user.put(DOCTOR_USERNAME, userName);
//        user.put(DOCTOR_PASSWORD, namePassword);
//        db.insert(DOCTOR_TABLE_NAME, null, user);
        return true;
    }
}
