package maneesh.com.patientmanagementsystem;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchByNameActivity extends AppCompatActivity {

    private EditText txtFirstName = null;
    private EditText txtLastName = null;
    private static final String EMPTY_STRING = "";
    DBHelperAddPatient db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_name);

    }

    public void OnClickSearch(View view) {

        txtFirstName = (EditText) findViewById(R.id.edtSearchFirstName);
        txtLastName = (EditText) findViewById(R.id.edtSearchLastName);

        String firstName = txtFirstName.getText().toString();
        String lastName = txtLastName.getText().toString();
        ArrayList<String> name = new ArrayList<>();

        if ((firstName != null && firstName != EMPTY_STRING) &&
            (lastName != null && lastName != EMPTY_STRING)) {
            db = new DBHelperAddPatient(this);
            try {
                if (db != null) {
                    Cursor rs = db.getData(firstName, lastName);

                    if (rs != null) {
                        if (rs.moveToFirst()) {
                            do {
                                StringBuilder sb = new StringBuilder();
                                sb.append(rs.getInt(0));
                                sb.append(" ");
                                sb.append(rs.getString(1));
                                sb.append(" ");
                                sb.append(rs.getString(2));
                                name.add(sb.toString());
                            } while (rs.moveToNext());
                        }
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

            ArrayAdapter adapter = new ArrayAdapter<String>(SearchByNameActivity.this, R.layout.activity_listview_search_by_name, name);
            ListView listView = (ListView) findViewById(R.id.patient_list);
            listView.setAdapter(adapter);

        }

    }

}
