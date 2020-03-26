package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText username, email, password, confirmPassword;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db= new DatabaseHelper(this);
        username= findViewById(R.id.emailRegister);
        email= findViewById(R.id.emailRegister);
        password=findViewById(R.id.passwordRegister);
        confirmPassword=findViewById(R.id.confirmPasswordRegister);
        button=findViewById(R.id.buttonRegister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameData= username.getText().toString();
                String emailData= email.getText().toString();
                String passwordData= password.getText().toString();
                String confirmPassData= confirmPassword.getText().toString();
                if(usernameData.equals("")|| emailData.equals("")|| passwordData.equals("")|| confirmPassData.equals("") ){
                    Toast.makeText(getApplicationContext(), "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(passwordData.equals(confirmPassData)){
                        Boolean checkmail= db.checkmail(emailData);
                        if(checkmail==true){
                            Boolean insert = db.insert(emailData,usernameData,passwordData);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Akun Berhasil Dibuat", Toast.LENGTH_SHORT).show();
                                //lempar ke main kalo berhasil buat akun
                                Intent gotoprofile = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(gotoprofile);
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Email Sudah Terdaftar", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Password Harus Sama", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
