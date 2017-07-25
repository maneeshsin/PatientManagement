package maneesh.com.patientmanagementsystem;

import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPatientActivity extends AppCompatActivity {

    private EditText txtFirstName = null;
    private EditText txtLastName = null;
    private EditText txtEmail = null;
    private EditText txtGender = null;
    private EditText txtAddress = null;
    private EditText txtMobileNumber = null;
    private EditText txtAge = null;
    private EditText txtBloodGroup = null;
    private DBHelperAddPatient db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
    }

    public void OnClickSave(View view){

        assignEditField();

        String firstName = txtFirstName.getText().toString();
        String lastName = txtLastName.getText().toString();
        String email = txtEmail.getText().toString();
        String gender = txtGender.getText().toString();
        String address = txtAddress.getText().toString();
        String mobileNumber = txtMobileNumber.getText().toString();
        String age = txtAge.getText().toString();
        String bloodGroup = txtBloodGroup.getText().toString();

        validateUserInput(firstName, lastName, email, mobileNumber);

        //insert into db
        PatientInfo p = setPatientInfo(firstName, lastName, email, gender, address, mobileNumber, age, bloodGroup);
        db = new DBHelperAddPatient(this);

        try {

            if (db != null) {
                if (db.insertPatientInfo(p)) {
                    showToastMessage("Patient Data successfully saved.");
                }
            }

        } catch (SQLException e) {
            Log.e("ERROR", e.toString());
        } catch (Exception e) {
            Log.e("ERROR", e.toString());
        } finally {
            db.close();
        }
    }

    @NonNull
    private PatientInfo setPatientInfo(String firstName, String lastName, String email, String gender, String address, String mobileNumber, String age, String bloodGroup) {
        PatientInfo p = new PatientInfo();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setEmail(email);
        p.setGender(gender);
        p.setAddress(address);
        p.setMobileNumber(mobileNumber);
        p.setBloodGroup(bloodGroup);
        p.setAge(Integer.parseInt(age));
        return p;
    }

    private void validateUserInput(String firstName, String lastName, String email, String mobileNumber) {
        if (firstName.equals("")){
            showToastMessage("First Name is blank");
            return;
        }
        if (lastName.equals("")){
            showToastMessage("Last Name is blank");
            return;
        }

        if (mobileNumber.equals("")){
            showToastMessage("Mobile  Number is blank");
            return;
        }

        if (email.equals("")){
            showToastMessage("email is blank");
            return;
        }
    }

    public void showToastMessage(String msg) {
        Toast.makeText(AddPatientActivity.this, msg, Toast.LENGTH_LONG).show();
    }

    private void assignEditField() {
        txtFirstName = (EditText) findViewById(R.id.edtFirstName);
        txtLastName = (EditText) findViewById(R.id.edtLastName);
        txtEmail = (EditText) findViewById(R.id.edtEmail);
        txtGender = (EditText) findViewById(R.id.edtGender);
        txtAddress = (EditText) findViewById(R.id.edtAddress);
        txtMobileNumber = (EditText) findViewById(R.id.edtMobile);
        txtAge = (EditText) findViewById(R.id.edtAge);
        txtBloodGroup = (EditText) findViewById(R.id.edtBloodGroup);
    }
}
