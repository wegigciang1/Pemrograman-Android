package com.example.helloworld;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentKosong extends Fragment {


    public FragmentKosong() {
        // Required empty public constructor
    }

    private EditText noMhs;
    private EditText namaMhs;
    private EditText phoneMhs;
    private Button buttonSimpan;
    private Button buttonHapus;
    private Button buttonCek;
    FirebaseFirestore firebaseFirestoreDb;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_kosong, container, false);
        noMhs = view.findViewById(R.id.noMhs);
        namaMhs = view.findViewById(R.id.namaMhs);
        phoneMhs = view.findViewById(R.id.phoneMhs);
        buttonSimpan = view.findViewById(R.id.simpanButton);
        buttonHapus = view.findViewById(R.id.hapusButton);
        buttonCek = view.findViewById(R.id.cekButton);
        return view;
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseFirestoreDb = FirebaseFirestore.getInstance();

        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sanity check
                if (!noMhs.getText().toString().isEmpty() && !namaMhs.getText().toString().isEmpty() && !phoneMhs.getText().toString().isEmpty()) {
                   tambahDataPlusChek();
                } else {
                    Toast.makeText(requireActivity(), "Semua Data Wajib Diisi",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sanity check
                if (!noMhs.getText().toString().isEmpty() && !namaMhs.getText().toString().isEmpty() && !phoneMhs.getText().toString().isEmpty()) {
                  checkDataDiDataBase();
                } else {
                    Toast.makeText(requireActivity(), "Semua Data Wajib Diisi",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteDataMahasiswa();
            }
        });

    }

    private void tambahMahasiswa() {

        Mahasiswa mhs = new Mahasiswa(noMhs.getText().toString(),
                namaMhs.getText().toString(), phoneMhs.getText().toString());

        firebaseFirestoreDb.collection("DaftarMhs").document(String.valueOf(noMhs.getText())).set(mhs)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //berhasil masuk datanya
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(requireActivity(), "ERROR" + e.toString(),
                                Toast.LENGTH_SHORT).show();
                        Log.d("TAG", e.toString());
                    }
                });


    }

    private void getDataMahasiswa() {
        DocumentReference docRef = firebaseFirestoreDb.collection("DaftarMhs").document("mhs1");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Mahasiswa mhs = document.toObject(Mahasiswa.class);
                        noMhs.setText(mhs.getNim());
                        namaMhs.setText(mhs.getNama());
                        phoneMhs.setText(mhs.getPhone());
                    } else {
                        Toast.makeText(requireActivity(), "Document Tidak Ditemukan",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(requireActivity(), "Document error : " + task.getException(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void tambahDataPlusChek(){
        Mahasiswa mhs = new Mahasiswa(noMhs.getText().toString(),
                namaMhs.getText().toString(), phoneMhs.getText().toString());
        DocumentReference docRef = firebaseFirestoreDb.collection("DaftarMhs").document(String.valueOf(noMhs.getText()));
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        tambahMahasiswa();
                        Toast.makeText(getActivity(),"Data Berhasil Diperbaharui",Toast.LENGTH_SHORT).show();
                        //Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        tambahMahasiswa();
                        Toast.makeText(getActivity(),"Data Berhasil Ditambahkan",Toast.LENGTH_SHORT).show();
                        //Log.d(TAG, "No such document");
                    }
                } else {
                    Toast.makeText(requireActivity(), "Document error : " + task.getException(),
                            Toast.LENGTH_SHORT).show();
                    //Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }
    private void checkDataDiDataBase(){
        Mahasiswa mhs = new Mahasiswa(noMhs.getText().toString(),
                namaMhs.getText().toString(), phoneMhs.getText().toString());
        DocumentReference docRef = firebaseFirestoreDb.collection("DaftarMhs").document(String.valueOf(noMhs.getText()));
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Toast.makeText(getActivity(),"Data Ditemukan di Database",Toast.LENGTH_SHORT).show();
                        //Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Toast.makeText(getActivity(),"Data Tidak Ditemukan",Toast.LENGTH_SHORT).show();
                        //Log.d(TAG, "No such document");
                    }
                } else {
                    Toast.makeText(requireActivity(), "Document error : " + task.getException(),
                            Toast.LENGTH_SHORT).show();
                    //Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }
    private void deleteDataMahasiswa() {
        Mahasiswa mhs = new Mahasiswa(noMhs.getText().toString(),
                namaMhs.getText().toString(), phoneMhs.getText().toString());
        firebaseFirestoreDb.collection("DaftarMhs")
                .document(String.valueOf(noMhs.getText())).delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        noMhs.setText("");
                        namaMhs.setText("");
                        phoneMhs.setText("");
                        Toast.makeText(requireActivity(), "Mahasiswa berhasil dihapus",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(requireActivity(), "Error deleting document: " + e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });


        }


    }