package maneesh.com.patientmanagementsystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtUserName = null;
    private EditText txtPassword = null;
    private EditText txtRegistrationCode = null;
    DBHelperRegistration db = null;
    DBHelperLogin dbLogin = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void showToastMessage(String msg) {
        Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_LONG).show();
    }

    public void OnClickRegisterNewUser(View view) {

        txtUserName = (EditText) findViewById(R.id.edtRegUserName);
        txtPassword = (EditText) findViewById(R.id.editRegPassword);
        txtRegistrationCode = (EditText) findViewById(R.id.edtRegCode);
        String userName = null;
        String userPassword = null;
        String userRegistrationCode = null;

        try {
            db = new DBHelperRegistration(this);
            dbLogin = new DBHelperLogin(this);

            userName = txtUserName.getText().toString();
            userPassword = txtPassword.getText().toString();

            if (txtRegistrationCode != null) {
                userRegistrationCode = txtRegistrationCode.getText().toString();
                Cursor rs = db.getData(userRegistrationCode);
                if (rs.moveToFirst()) {
                    int status = rs.getInt(0);

                    if (status == 1) {
                        //insert into doctor table and registration table set
                        if (userName != null && userPassword != null) {
                            if (dbLogin.insertUser(userName, userPassword)) {
                                db.updateRegistrationStatus(userRegistrationCode);
                                showToastMessage("User successfully registered");
                                Intent intent = new Intent(this, MainActivity.class);
                                startActivity(intent);
                            }

                        }
                    } else {
                        showToastMessage("Registration Code is not active or already used");
                    }
                } else {
                    showToastMessage("Registration Code is invalid");
                }
                if (!rs.isClosed()) {
                    rs.close();
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
}
