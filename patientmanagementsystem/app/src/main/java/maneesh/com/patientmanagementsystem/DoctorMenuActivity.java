package maneesh.com.patientmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DoctorMenuActivity extends AppCompatActivity {
    Button btnShowRegistration = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_menu);
        boolean isAdmin = getIntent().getExtras().getBoolean("admin");
        if (!isAdmin) {
            btnShowRegistration = (Button) findViewById(R.id.btnGenerateCode);
            if (btnShowRegistration != null) {
                btnShowRegistration.setVisibility(View.GONE);
            }
        }
    }

    public void OnClickSearchByName(View view) {
        Intent intent = new Intent(this, SearchByNameActivity.class);
        startActivity(intent);

    }

    public void OnClickSearchByDate(View view) {
        Intent intent = new Intent(this, SearchByDateActivity.class);
        startActivity(intent);
    }

    public void OnClickAddPatient(View view) {
        Intent intent = new Intent(this, AddPatientActivity.class);
        startActivity(intent);

    }

    public void OnClickGenerateRegistrationCode(View view) {

    }

}
