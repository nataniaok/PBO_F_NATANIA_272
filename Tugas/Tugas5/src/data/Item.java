package com.praktikum.data; // Mendefinisikan package untuk kelas ini

// Kelas ini merepresentasikan barang yang dilaporkan oleh Mahasiswa
public class Item {
    // Detail barang
    private String itemName;      // Nama barang
    private String description;   // Deskripsi barang
    private String location;      // Lokasi ditemukan atau hilangnya barang
    private String status;        // Status barang: "Reported" (Dilaporkan) atau "Claimed" (Diambil)

    // Konstruktor untuk menginisialisasi objek barang
    public Item(String itemName, String description, String location, String status) {
        this.itemName = itemName;         // Menetapkan nama barang
        this.description = description;   // Menetapkan deskripsi
        this.location = location;         // Menetapkan lokasi
        this.status = status;             // Menetapkan status
    }

    // Method getter untuk mengakses atribut barang
    public String getItemName() { return itemName; }         // Mengambil nama barang
    public String getDescription() { return description; }   // Mengambil deskripsi barang
    public String getLocation() { return location; }         // Mengambil lokasi barang
    public String getStatus() { return status; }             // Mengambil status barang

    // Method setter untuk mengubah status barang
    public void setStatus(String status) { this.status = status; } // Mengatur status barang

    // Override method toString() untuk menampilkan informasi barang
    @Override
    public String toString() {
        return getItemName() + " | " + getDescription() + " | " + getLocation() + " | " + getStatus();
    }
}