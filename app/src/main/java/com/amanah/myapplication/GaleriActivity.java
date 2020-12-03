package com.amanah.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amanah.myapplication.model.Menu;

import java.util.List;

public class GaleriActivity extends AppCompatActivity {

        List<Menu> menus;
        int indeksTampil = 0;
        String jenisMenu;
        Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
        TextView txJenis,txMenu,txHarga,txDeskripsi,txJudul;
        ImageView ivFotoMenu;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profil_menu);
            Intent intent = getIntent();
            jenisMenu = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
            menus = DataProvider.getMenusByTipe(this,jenisMenu, menus);
            inisialisasiView();
            tampilkanProfil();
        }

        private void inisialisasiView() {
            btnPertama = findViewById(R.id.btnPertama);
            btnSebelumnya = findViewById(R.id.btnSebelumnya);
            btnBerikutnya = findViewById(R.id.btnBerikutnya);
            btnTerakhir = findViewById(R.id.btnTerakhir);

            btnPertama.setOnClickListener(view -> menuPertama());
            btnTerakhir.setOnClickListener(view -> menuTerakhir());
            btnSebelumnya.setOnClickListener(view -> menuSebelumnya());
            btnBerikutnya.setOnClickListener(view -> menuBerikutnya());

            txJenis = findViewById(R.id.txJenis);
            txMenu = findViewById(R.id.txMenu);
            txHarga = findViewById(R.id.txHarga);
            txDeskripsi = findViewById(R.id.txDeskripsi);
            ivFotoMenu = findViewById(R.id.gambarMenu);

            txJudul = findViewById(R.id.txJudul);
            txJudul.setText("Menu Makanan "+jenisMenu);
        }


        private void tampilkanProfil() {
            Menu k = menus.get(indeksTampil);
            Log.d("Minuman","Menampilkan minuman "+k.getJenis());
            txJenis.setText(k.getJenis());
            txMenu.setText(k.getMenu());
            txHarga.setText(k.getHarga());
            txDeskripsi.setText(k.getDeskripsi());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ivFotoMenu.setImageDrawable(this.getDrawable(k.getDrawableRes()));
            }
        }

        private void getDrawable() {
        }

        private void menuPertama() {
            int posAwal = 0;
            if (indeksTampil == posAwal) {
                Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
                return;
            } else {
                indeksTampil = posAwal;
                tampilkanProfil();
            }
        }

        private void menuTerakhir() {
            int posAkhir = menus.size() - 1;
            if (indeksTampil == posAkhir) {
                Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
                return;
            } else {
                indeksTampil = posAkhir;
                tampilkanProfil();
            }
        }

        private void menuBerikutnya() {
            if (indeksTampil == menus.size() - 1) {
                Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
                return;
            } else {
                indeksTampil++;
                tampilkanProfil();
            }
        }

        private void menuSebelumnya() {
            if (indeksTampil == 0) {
                Toast.makeText(this,"Sudah di posisi pertama", Toast.LENGTH_SHORT).show();
                return;
            } else {
                indeksTampil--;
                tampilkanProfil();
            }
        }
    }

