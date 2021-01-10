package edu.upc.dsa.minim2_museus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    public TextInputLayout textUser, textPassword;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textUser = findViewById(R.id.userInput);
        textPassword = findViewById(R.id.passwordInput);
        sharedPref = getApplicationContext().getSharedPreferences("minimo2prueba", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public void logIn(View v) {

        String username = textUser.getEditText().getText().toString();
        String password = textPassword.getEditText().getText().toString();

        if (username.equals("user") && password.equals("dsamola")) {
            editor.putBoolean("login", true);
            editor.commit();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        else {
            Toast.makeText(getApplicationContext(), "Usuario y contraseña incorrectos", Toast.LENGTH_LONG).show();
        }
    }
}