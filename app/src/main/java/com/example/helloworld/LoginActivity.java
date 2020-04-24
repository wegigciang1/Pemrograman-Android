package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    TextView signUp;
    Button buttonLogin;
    DatabaseHelper db;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    /*    SharedPreferences preferences = getSharedPreferences("masuk",MODE_PRIVATE);
        String cek = preferences.getString("ingat","");

        if(cek.equals("true")){
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        } */
        mFirebaseAuth = FirebaseAuth.getInstance();
        if (mFirebaseAuth.getCurrentUser() != null) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView myimageView = findViewById(R.id.gambarLogin);
        myimageView.setImageResource(R.drawable.gambar_login);
        db = new DatabaseHelper(this);
        buttonLogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signUp = findViewById(R.id.signUpMainText);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailData = email.getText().toString();
                String passwordData = password.getText().toString();
                /*Boolean Checkmailpass= db.emailPass(emailData,passwordData);
                if(Checkmailpass) {
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                */
                //pertemeuan 6
                //broadcester();

                //Bundle extras= new Bundle();
                //extras.putString("KEY", "test");
                mFirebaseAuth.signInWithEmailAndPassword(emailData, passwordData).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                            // startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                            Intent gotoprofile = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(gotoprofile);
                            //agar tidak bisa balik ke act sebelumnya dengan back button
                            finish();

                        } else {
                            Toast.makeText(getApplicationContext(), "Email atau Password Salah", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //Intent gotoprofile = new Intent(getApplicationContext(), HomeActivity.class);

                //Pertemuan 6
                //gotoprofile.putExtras(extras);
                //

                // startActivity(gotoprofile);

                /*    SharedPreferences preference = getSharedPreferences("masuk",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preference.edit();
                    editor.putString("ingat","true");
                    editor.apply(); */
                //}

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
