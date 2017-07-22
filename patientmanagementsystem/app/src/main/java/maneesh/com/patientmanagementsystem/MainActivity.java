package maneesh.com.patientmanagementsystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsername = null;
    private EditText txtUserPassword = null;
    private DBHelperLogin db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickLogin(View view) {
        String userName = null;
        String userPassword = null;
        boolean isAdmin = false;

        txtUsername = (EditText) findViewById(R.id.edtUserName);
        txtUserPassword = (EditText) findViewById(R.id.edtPassword);

        if (txtUsername != null) {
            userName = txtUsername.getText().toString();
            if (userName.equals("admin")) {
                isAdmin = true;
            }
        }
        if (txtUsername != null) {
            userPassword = txtUserPassword.getText().toString();
        }
        try {
            db = new DBHelperLogin(this);
            Cursor rs = db.getData(userName);
            if (rs.moveToFirst()) {
                String pwd = rs.getString(rs.getColumnIndex(DBHelperLogin.DOCTOR_PASSWORD));

                if (!rs.isClosed()) {
                    rs.close();
                }

                if (pwd.equals(userPassword)) {
                    Intent intent = new Intent(this, DoctorMenuActivity.class);
                    intent.putExtra("admin", isAdmin);
                    startActivity(intent);
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

    public void onClickRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
