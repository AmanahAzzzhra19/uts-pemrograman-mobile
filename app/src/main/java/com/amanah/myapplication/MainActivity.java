package com.amanah.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

        ImageButton btnMakanan,btnMinuman;
        public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            inisialisasiView();

        }

        private void inisialisasiView() {
            btnMakanan = findViewById(R.id.btn_buka_Makanan);
            btnMinuman = findViewById(R.id.btn_buka_ras_Minuman);
            btnMakanan.setOnClickListener(view -> bukaGaleri("Makanan"));
            btnMinuman.setOnClickListener(view -> bukaGaleri("Minuman"));
        }

        private void bukaGaleri(String jenisMenu) {
            Log.d("MAIN","Buka activity Makanan");
            Intent intent = new Intent(this, GaleriActivity.class);
            intent.putExtra(JENIS_GALERI_KEY, jenisMenu);
            startActivity(intent);
        }

    }
