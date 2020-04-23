package com.example.helloworld;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SinopsisFilmActivity extends AppCompatActivity {
    ImageView mainImageView;
    TextView judul, deskripsi, tulisanSinopsis;

    String judul2, sinopsis2;
    int foto2;

    String tulisanSinopsis2 = "Sinopsis";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinopsis_film);

        mainImageView = findViewById(R.id.img_item_photo);
        judul = findViewById(R.id.tv_item_name);
        deskripsi = findViewById(R.id.tv_item_detail);
        tulisanSinopsis = findViewById(R.id.tv_item_name3);
        getData();
        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("foto") && getIntent().hasExtra("judul") && getIntent().hasExtra("sinopsis")) {
            judul2 = getIntent().getStringExtra("judul");
            sinopsis2 = getIntent().getStringExtra("sinopsis");
            foto2 = getIntent().getIntExtra("foto", 1);
        } else {
            Toast.makeText(this, "no Data", Toast.LENGTH_SHORT).show();
        }

    }

    private void setData() {
        judul.setText(judul2);
        deskripsi.setText(sinopsis2);
        tulisanSinopsis.setText(tulisanSinopsis2);
        mainImageView.setImageResource(foto2);
    }
}
