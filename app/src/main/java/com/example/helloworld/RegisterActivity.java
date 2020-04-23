package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    //DatabaseHelper db;
    EditText username, email, password, confirmPassword;
    Button button;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseFirestore firebaseFirestoreDb;
    private String UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //  db= new DatabaseHelper(this);
        username = findViewById(R.id.usernameRegister);
        email = findViewById(R.id.emailRegister);
        password = findViewById(R.id.passwordRegister);
        confirmPassword = findViewById(R.id.confirmPasswordRegister);
        button = findViewById(R.id.buttonRegister);
        firebaseFirestoreDb = FirebaseFirestore.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usernameData = username.getText().toString();
                final String emailData = email.getText().toString();
                String passwordData = password.getText().toString();
                String confirmPassData = confirmPassword.getText().toString();

                if (usernameData.equals("") || emailData.equals("") || passwordData.equals("") || confirmPassData.equals("")) {
                    Toast.makeText(getApplicationContext(), "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    if (passwordData.equals(confirmPassData)) {
                        mFirebaseAuth.createUserWithEmailAndPassword(emailData, passwordData).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    UserID = mFirebaseAuth.getCurrentUser().getUid();
                                    Map<String, Object> user = new HashMap<>();
                                    user.put("username", usernameData);
                                    user.put("email", emailData);
                                    firebaseFirestoreDb.collection("ListUsers").document(UserID).set(user)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Log.d("TAG", "Berhasil dibuat : " + UserID);
                                                    Toast.makeText(getApplicationContext(), "Akun Berhasil Dibuat", Toast.LENGTH_SHORT).show();
                                                    FirebaseAuth.getInstance().signOut();
                                                    finish();
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Log.d("TAG", e.toString());
                                                }
                                            });
                                } else {
                                    Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    } else {
                        Toast.makeText(getApplicationContext(), "Password Harus Sama", Toast.LENGTH_SHORT).show();
                    }
                }
                        /*Boolean checkmail= db.checkmail(emailData);
                        if(checkmail==true){
                            Boolean insert = db.insert(emailData,usernameData,passwordData);
                            if(insert==true){

                                Toast.makeText(getApplicationContext(),"Akun Berhasil Dibuat", Toast.LENGTH_SHORT).show();

                                //lempar ke main kalo berhasil buat akun
                                Intent gotoprofile = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(gotoprofile);
                            }
                        }*/
//                        else{
//                            Toast.makeText(getApplicationContext(),"Email Sudah Terdaftar", Toast.LENGTH_SHORT).show();
//                        }


            }

        });
    }
}



