package com.praktikum.models; // Mendefinisikan package untuk kelas ini

import java.util.Scanner; // Import Scanner untuk input dari pengguna
import java.util.InputMismatchException; // Import exception untuk input tidak valid
import com.praktikum.data.Item; // Import kelas Item
import java.util.ArrayList; // Import ArrayList untuk menyimpan list dinamis
import java.util.Iterator; // Import Iterator untuk manipulasi list

// Kelas Admin mewarisi User dan bisa mengelola item serta user
public class Admin extends User {

    // Konstruktor Admin dengan parameter username dan password
    public Admin(String username, String password) {
        super(username, password); // Memanggil konstruktor induk
    }

    // Method login khusus Admin
    @Override
    public boolean login(String userInput, String passInput) {
        // Cek apakah username dan password cocok
        return this.username.equals(userInput) && this.password.equals(passInput);
    }

    // Method untuk mengelola item yang dilaporkan
    public void manageItems(ArrayList<Item> reportedItems, Scanner scanner) {
        // Menampilkan menu pengelolaan item
        System.out.println("1. Lihat Semua Laporan\n2. Tandai Barang Telah Diambil");

        try {
            int choice = scanner.nextInt(); // Membaca pilihan dari pengguna
            scanner.nextLine(); // Membersihkan newline

            if (choice == 1) {
                // Menampilkan semua item yang dilaporkan
                for (Item item : reportedItems) {
                    System.out.println("Nama: " + item.getItemName() + ", Status: " + item.getStatus());
                }
            } else if (choice == 2) {
                // Menampilkan item yang bisa ditandai sebagai "Claimed"
                int index = 0;
                for (Item item : reportedItems) {
                    if (item.getStatus().equals("Reported")) {
                        System.out.println(index + ". " + item.getItemName());
                    }
                    index++;
                }

                System.out.print("Masukkan indeks barang yang ingin ditandai: ");
                try {
                    int idx = scanner.nextInt(); // Membaca indeks dari pengguna
                    scanner.nextLine(); // Membersihkan newline
                    Item item = reportedItems.get(idx); // Mengambil item berdasarkan indeks
                    item.setStatus("Claimed"); // Mengubah status menjadi "Claimed"
                    System.out.println("Barang berhasil ditandai sebagai telah diambil.");
                } catch (IndexOutOfBoundsException e) {
                    // Menangani kesalahan jika indeks tidak valid
                    System.out.println("Indeks tidak valid!");
                }
            }
        } catch (InputMismatchException e) {
            // Menangani input yang bukan angka
            System.out.println("Input harus berupa angka!");
            scanner.nextLine(); // Membersihkan input yang salah
        }
    }

    // Method untuk mengelola pengguna (khusus Mahasiswa)
    public void manageUsers(ArrayList<User> userList, Scanner scanner, ArrayList<Item> reportedItems) {
        System.out.println("1. Tambah Mahasiswa\n2. Hapus Mahasiswa");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // Menambahkan Mahasiswa baru
                System.out.print("Masukkan Nama: ");
                String name = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();
                userList.add(new Mahasiswa(name, nim));
                System.out.println("Mahasiswa berhasil ditambahkan.");

                // Simpan data ke file (jika diimplementasikan)
                com.praktikum.LoginSystem.saveUserListToFile(userList);
                com.praktikum.LoginSystem.saveReportedItemsToFile(reportedItems);

            } else if (choice == 2) {
                // Menghapus Mahasiswa
                System.out.print("Masukkan NIM Mahasiswa yang ingin dihapus: ");
                String nim = scanner.nextLine();
                Iterator<User> it = userList.iterator();
                while (it.hasNext()) {
                    User user = it.next();
                    if (user instanceof Mahasiswa && ((Mahasiswa) user).getNim().equals(nim)) {
                        it.remove();
                        System.out.println("Mahasiswa berhasil dihapus.");
                        return;
                    }
                }
                System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scanner.nextLine(); // Membersihkan input yang salah
        }
    }
}
