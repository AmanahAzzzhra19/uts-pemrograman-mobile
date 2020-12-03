package com.amanah.myapplication.model;

public class Menu {

        private String jenis;
        private String menu;
        private String harga;
        private String deskripsi;
        private int drawableRes;

        public Menu(String jenis, String menu, String harga, String deskripsi, int drawableRes) {
            this.jenis = jenis;
            this.menu = menu;
            this.harga = harga;
            this.deskripsi = deskripsi;
            this.drawableRes = drawableRes;
        }

        public String getJenis() {
            return jenis;
        }

        public void setJenis(String jenis) {
            this.jenis = jenis;
        }

        public String getMenu() {
            return menu;
        }

        public void setMenu(String menu) {
            this.menu = menu;
        }

        public String getHarga() {
            return harga;
        }

        public void setHarga(String harga) {
            this.harga = harga;
        }

        public String getDeskripsi() {
            return deskripsi;
        }

        public void setDeskripsi(String deskripsi) {
            this.deskripsi = deskripsi;
        }

        public int getDrawableRes() {
            return drawableRes;
        }

        public void setDrawableRes(int drawableRes) {
            this.drawableRes = drawableRes;
        }
    }


