package com.amanah.myapplication;

import android.content.Context;

import com.amanah.myapplication.model.Makanan;
import com.amanah.myapplication.model.Menu;
import com.amanah.myapplication.model.Minuman;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    private static List<Menu> menus = new ArrayList<>();

    private static List<Makanan> initDataMakanan(Context ctx) {
        List<Makanan> makanans = new ArrayList<>();
        makanans.add(new Makanan("rendang", "Rp 15.000.00",
                "Rendang atau randang adalah masakan daging yang berasal dari Minangkabau", R.drawable.rendang));
        makanans.add(new Makanan("bakpao", "Rp 10.000.00",
                "Bakpao merupakan makanan tradisional Tionghoa.", R.drawable.bakpao));
        makanans.add(new Makanan("mie goreng ", "Rp 20.000.00",
                " Mi goreng berarti adalah makanan yang berasal dari Indonesia yang populer dan juga digemari di Malaysia, dan Singapura.", R.drawable.mie_goreng));
        makanans.add(new Makanan("sate ", "Rp 25.000.00",
                "Sate atau satai adalah makanan yang terbuat dari daging yang dipotong kecil-kecil dan ditusuk sedemikian rupa dengan tusukan lidi tulang daun kelapa atau bambu kemudian dipanggang menggunakan bara arang kayu. ", R.drawable.sate));
        makanans.add(new Makanan("pangsit", "Rp 20.000.00",
                " Pangsit, atau kadang disebut sebagai wonton, adalah makanan berupa daging cincang yang dibungkus lembaran tepung terigu.", R.drawable.pangsit));
        return makanans;
    }

    private static List<Minuman> initDataMinuman(Context ctx) {
        List<Minuman> minumans = new ArrayList<>();
        minumans.add(new Minuman("kopi", "Rp 5.000.00",
                "Kopi adalah minuman hasil seduhan biji kopi yang telah disangrai dan dihaluskan menjadi bubuk.", R.drawable.kopi));
        minumans.add(new Minuman("teh", "Rp 5.000.00",
                "Teh adalah minuman yang mengandung kafeina, sebuah infusi yang dibuat dengan cara menyeduh daun, pucuk daun, atau tangkai daun.", R.drawable.teh));
        minumans.add(new Minuman("jus alpukat", "Rp 10.000.00",
                "Jus buah alpukat disebut mengandung lemak tak jenuh sehingga aman untuk dikonsumsi secara rutin.  ", R.drawable.jus_alpukat));
        minumans.add(new Minuman("jus jeruk", "Rp 15.000.00",
                "Jus jeruk adalah minuman yang luar biasa untuk orang dengan tekanan darah tinggi atau rendah.", R.drawable.jus_jeruk));
        minumans.add(new Minuman("jus apel", "Rp 25.000.00",
                "Jus apel adalah minuman yang cocok diminum saat udara panas. Minuman ini juga dapat menghidrasi tubuh Anda dengan baik sebab mengandung kadar air yang cukup tinggi..", R.drawable.jus_apel));
        return minumans;
    }

    private static void initAllMenus(Context ctx) {
        menus.addAll(initDataMakanan(ctx));
        menus.addAll(initDataMinuman(ctx));
    }

    public static List<Menu> getAllMenu(Context ctx) {
        if (menus.size() == 0) {
            initAllMenus(ctx);
        }
        return menus;
    }

    public static List<Menu> getMenusByTipe(Context ctx, String jenis, List<Menu> menusByType) {
        List<Menu> dapursByType = new ArrayList<>();
        if (menus.size() == 0) {
            initAllMenus(ctx);
        }
        for (Menu h : menus) {
            if (h.getJenis().equals(jenis)) {
                menusByType.add(h);
            }
        }
        return menusByType;
    }

}




