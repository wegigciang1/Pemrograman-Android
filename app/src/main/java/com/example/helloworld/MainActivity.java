package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    TextView signUp;
    Button buttonLogin;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = getSharedPreferences("masuk",MODE_PRIVATE);
        String cek = preferences.getString("ingat","");

        if(cek.equals("true")){
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        buttonLogin= findViewById(R.id.btnlogin);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signUp = findViewById(R.id.signUpMainText);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailData = email.getText().toString();
                String passwordData = password.getText().toString();
                Boolean Checkmailpass= db.emailPass(emailData,passwordData);
                if(Checkmailpass==true) {
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent gotoprofile = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(gotoprofile);

                    SharedPreferences preference = getSharedPreferences("masuk",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preference.edit();
                    editor.putString("ingat","true");
                    editor.apply();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Email atau Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //untuk Sign Up
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoprofile = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(gotoprofile);
            }
        });
    }
}
