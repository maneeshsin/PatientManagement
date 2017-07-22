package maneesh.com.patientmanagementsystem;

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
        if (isAdmin) {
            btnShowRegistration = (Button) findViewById(R.id.btnGenerateCode);
            if (btnShowRegistration != null) {
                btnShowRegistration.setVisibility(View.VISIBLE);
            }
        }
    }
}
