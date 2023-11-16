package com.MSebas55.layoutinicio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    public TextView forgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        forgotPassword = (TextView) findViewById(R.id.forgotPasswordText);
        forgotPassword.setOnClickListener(view -> {
            new AlertDialog.Builder(this)
                    .setTitle("¿Olvidaste tu contraseña?")
                    .setMessage("Puedes recuperarla a través de tu correo electrónico.")
                    //.setView(taskEditText)

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(android.R.string.search_go, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        });
    }
    public void openRegister(View view) {
        Intent nIntent = new Intent(Login.this, Register.class);
        startActivity(nIntent);
    }
    public void openPrincipal(View view) {
        Toast toast = Toast.makeText(Login.this, "Entrar a Principal", Toast.LENGTH_LONG);
        toast.show();
    }
}