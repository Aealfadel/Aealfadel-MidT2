package alfaisal.aealfadel.aealfadel_midt2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Acces2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        setContentView(R.layout.activity_acces2);
        setTitle("You are in Activity3");

        Button go1 = findViewById(R.id.btn_go_3act1);
        Button go2 = findViewById(R.id.btn_go_3act2);

        Button delete = findViewById(R.id.btn_delete);
        Button select = findViewById(R.id.btn_select);

        EditText inp_iqama = findViewById(R.id.inp_iqama);
        EditText inp_name = findViewById(R.id.inp_name);


        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = databaseHelper.getResult(inp_name.getText() + "");

                if (c == null) {
                    Toast.makeText(Acces2.this, "There is no such record.", Toast.LENGTH_SHORT).show();
                    return;
                }
                String message = c.getInt(0) + " " +
                        c.getString(1) + " " +
                        c.getString(2) + " " +
                        c.getString(3) + " " +
                        c.getString(4) + " ";

                Toast.makeText(Acces2.this, "Record found: " + message, Toast.LENGTH_LONG).show();


            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.delete(inp_iqama.getText() + "");
            }
        });

        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Acces2.this, Home.class));
            }
        });
        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Acces2.this, Acces.class));
            }
        });



