package maneesh.com.patientmanagementsystem;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public static final String ADD_PATIENT_CONDITION = "pcondition";
    public static final String ADD_PATIENT_MEDICATION = "pmedication";
    public static final String ADD_PATIENT_NOTE = "pnote";
    public static final String ADD_PATIENT_LAST_VISITED = "plastvisit";


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public DBHelperAddPatient(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public Cursor getData(String firstName, String lastName) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + ADD_PATIENT_TABLE_NAME + " where " + ADD_PATIENT_FNAME + "=?" + " AND " + ADD_PATIENT_LNAME + "=?", new String[]{firstName, lastName});
        return res;
    }

    public Cursor getData(String firstName, String lastName, String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + ADD_PATIENT_TABLE_NAME + " where " + ADD_PATIENT_FNAME + "=?" + " AND " + ADD_PATIENT_LNAME + "=?" + " AND " + ADD_PATIENT_EMAIL + "=?", new String[]{firstName, lastName, email});
        return res;
    }

    public boolean insertPatientInfo(PatientInfo p) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues patient = new ContentValues();
        patient.put(ADD_PATIENT_FNAME, p.getFirstName());
        patient.put(ADD_PATIENT_LNAME, p.getLastName());
        patient.put(ADD_PATIENT_EMAIL, p.getEmail());
        patient.put(ADD_PATIENT_MOBILE, p.getMobileNumber());
        patient.put(ADD_PATIENT_AGE, p.getAge());
        patient.put(ADD_PATIENT_ADDRESS, p.getAddress());
        patient.put(ADD_PATIENT_BLOOD_GROUP, p.getBloodGroup());
        patient.put(ADD_PATIENT_GENDER, p.getGender());
        patient.put(ADD_PATIENT_CONDITION, p.getCondition());
        patient.put(ADD_PATIENT_MEDICATION, p.getMedication());
        patient.put(ADD_PATIENT_NOTE, p.getNote());
        patient.put(ADD_PATIENT_LAST_VISITED, p.getLastVisited().toString());
        db.insert(ADD_PATIENT_TABLE_NAME, null, patient);
        return true;
    }
}
