package maneesh.com.patientmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_ADDRESS;
import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_AGE;
import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_BLOOD_GROUP;
import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_CONDITION;
import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_EMAIL;
import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_FNAME;
import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_GENDER;
import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_ID;
import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_LAST_VISITED;
import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_LNAME;
import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_MEDICATION;
import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_MOBILE;
import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_NOTE;
import static maneesh.com.patientmanagementsystem.DBHelperAddPatient.ADD_PATIENT_TABLE_NAME;
import static maneesh.com.patientmanagementsystem.DBHelperLogin.DOCTOR_PASSWORD;
import static maneesh.com.patientmanagementsystem.DBHelperLogin.DOCTOR_TABLE_NAME;
import static maneesh.com.patientmanagementsystem.DBHelperLogin.DOCTOR_USERNAME;

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


        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(ADD_PATIENT_TABLE_NAME);
        sb.append("(");
        sb.append(ADD_PATIENT_ID);
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(ADD_PATIENT_FNAME);
        sb.append(" TEXT NOT NULL,");
        sb.append(ADD_PATIENT_LNAME);
        sb.append(" TEXT NOT NULL,");
        sb.append(ADD_PATIENT_EMAIL);
        sb.append(" TEXT NOT NULL,");
        sb.append(ADD_PATIENT_MOBILE);
        sb.append(" TEXT,");

        sb.append(ADD_PATIENT_AGE);
        sb.append(" INTEGAR,");

        sb.append(ADD_PATIENT_ADDRESS);
        sb.append(" TEXT,");
        sb.append(ADD_PATIENT_BLOOD_GROUP);
        sb.append(" TEXT,");
        sb.append(ADD_PATIENT_GENDER);
        sb.append(" TEXT,");
        sb.append(ADD_PATIENT_CONDITION);
        sb.append(" TEXT,");
        sb.append(ADD_PATIENT_MEDICATION);
        sb.append(" TEXT,");
        sb.append(ADD_PATIENT_NOTE);
        sb.append(" TEXT,");
        sb.append(ADD_PATIENT_LAST_VISITED);
        sb.append(" TEXT,");
        sb.append("  UNIQUE ( ");
//        sb.append(ADD_PATIENT_FNAME);
//        sb.append(" , ");
//        sb.append(ADD_PATIENT_LNAME);
//        sb.append(" , ");
        sb.append(ADD_PATIENT_EMAIL);
        sb.append(" ) ");
        sb.append(" ); ");

        db.execSQL(sb.toString());

        db.execSQL(
            "create table " + DOCTOR_TABLE_NAME +
                " (username varchar(25) primary key, password varchar(25))"
        );

        db.execSQL("INSERT INTO " + DOCTOR_TABLE_NAME + " (" + DOCTOR_USERNAME + "," + DOCTOR_PASSWORD + ")VALUES ('maneeshsin', 'test')");
        db.execSQL("INSERT INTO " + DOCTOR_TABLE_NAME + " (" + DOCTOR_USERNAME + "," + DOCTOR_PASSWORD + ")VALUES ('admin', 'admin')");

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
        Cursor res = db.rawQuery("select " + REGISTRATION_STATUS + " from " + REGISTRATION_TABLE_NAME + " where " + REGISTRATION_ID + " =?", new String[]{code});
        return res;
    }

    public boolean updateRegistrationStatus(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(REGISTRATION_STATUS, 0);
        db.update(REGISTRATION_TABLE_NAME, contentValues, REGISTRATION_ID + " = ? ", new String[]{id});
        return true;
    }

}
