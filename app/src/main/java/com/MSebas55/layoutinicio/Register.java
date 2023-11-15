package com.MSebas55.layoutinicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.MSebas55.layoutinicio.Database.DatabaseAux;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageView icono = findViewById(R.id.iconoreg);

        Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
        icono.startAnimation(zoomAnimation);

    }
    public void openMain(View view) {
        Intent nIntent = new Intent(Register.this, Login.class);
        startActivity(nIntent);
    }
    public void insertValues(View v) {

        TextView nameTextView = findViewById(R.id.usuarioreg);
        TextView emailTextView = findViewById(R.id.mailreg);
        TextView passTextView = findViewById(R.id.passreg);

        String nameString = nameTextView.getText().toString();
        String emailString = emailTextView.getText().toString();
        String passString = passTextView.getText().toString();

        DatabaseAux aux = new DatabaseAux(Register.this);
        SQLiteDatabase db = aux.getWritableDatabase();

        if(db != null && !nameString.isEmpty() && !emailString.isEmpty() && !passString.isEmpty()) {
            ContentValues values = new ContentValues();
            values.put("name", nameString);
            values.put("email", emailString);
            values.put("pass", passString);

            long res = db.insert("users", null, values);
            System.out.println(res);
            if(res >= 0) {
                Toast.makeText(this, "Insertado correctamente", Toast.LENGTH_LONG).show();
                nameTextView.setText("");
                emailTextView.setText("");
                passTextView.setText("");
                Intent nIntent = new Intent(Register.this, Login.class);
                startActivity(nIntent);
            }
            else {
                Toast.makeText(this, "Fallo al insertar", Toast.LENGTH_LONG).show();
            }
            db.close();
        }
    }
}