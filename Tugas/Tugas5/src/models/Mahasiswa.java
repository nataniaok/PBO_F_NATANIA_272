package com.praktikum.models; // Mendefinisikan package untuk kelas ini

import java.util.Scanner; // Import Scanner untuk input dari pengguna
import com.praktikum.data.Item; // Import kelas Item
import java.util.ArrayList; // Import ArrayList untuk menyimpan item

// Kelas Mahasiswa yang mewarisi User dan dapat melapor serta melihat barang
public class Mahasiswa extends User {
    private String nim; // Nomor Induk Mahasiswa

    // Konstruktor
    public Mahasiswa(String name, String nim) {
        super(name, nim); // Memanggil konstruktor induk dengan nama dan nim
        this.nim = nim;   // Menetapkan NIM
    }

    // Getter untuk NIM
    public String getNim() {
        return nim; // Mengembalikan NIM mahasiswa
    }

    // Method login untuk Mahasiswa
    @Override
    public boolean login(String name, String nimInput) {
        // Memeriksa apakah nama dan NIM cocok
        return this.username.equals(name) && this.nim.equals(nimInput);
    }

    // Method untuk melaporkan barang
    public void reportItem(Scanner scanner, ArrayList<Item> reportedItems) {
        System.out.print("Masukkan nama barang: "); // Minta input nama barang
        String name = scanner.nextLine(); // Baca nama barang
        System.out.print("Masukkan deskripsi: "); // Minta deskripsi
        String description = scanner.nextLine(); // Baca deskripsi
        System.out.print("Masukkan lokasi: "); // Minta lokasi
        String location = scanner.nextLine(); // Baca lokasi

        // Tambahkan barang ke list dengan status "Reported"
        reportedItems.add(new Item(name, description, location, "Reported"));
        System.out.println("Barang berhasil dilaporkan."); // Pesan konfirmasi
    }

    // Method untuk melihat barang-barang yang dilaporkan
    public void viewReportedItems(ArrayList<Item> reportedItems) {
        if (reportedItems.isEmpty()) {
            // Jika belum ada laporan
            System.out.println("Belum ada laporan barang.");
        } else {
            // Iterasi item yang dilaporkan
            for (Item item : reportedItems) {
                // Hanya tampilkan item yang statusnya "Reported"
                if (item.getStatus().equals("Reported")) {
                    System.out.println("Nama: " + item.getItemName() +
                            ", Deskripsi: " + item.getDescription() +
                            ", Lokasi: " + item.getLocation());
                }
            }
        }
    }
}