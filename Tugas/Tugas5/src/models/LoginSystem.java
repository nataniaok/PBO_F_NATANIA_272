package com.praktikum;

// Import semua class dari package models
import com.praktikum.models.*;
// Import class Item dari package data
import com.praktikum.data.Item;
// Import class utilitas Java
import java.util.*;
// Import class untuk menulis file
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

// Kelas utama untuk menjalankan sistem login dan pelaporan barang
public class LoginSystem {

    // Daftar semua pengguna (Admin dan Mahasiswa)
    static ArrayList<User> userList = new ArrayList<>();

    // Daftar semua barang yang telah dilaporkannata
    static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        // Tambahkan pengguna default (admin dan mahasiswa)
        userList.add(new Admin("admin", "admin123"));
        userList.add(new Admin("superadmin", "superpass"));
        userList.add(new Mahasiswa("Nata", "272"));
        userList.add(new Mahasiswa("Fira", "263"));
        userList.add(new Mahasiswa("Marlo", "246"));

        // Tambahkan item default ke daftar barang yang dilaporkan
        reportedItems.add(new Item("Laptop", "Lenovo", "Library", "Reported"));
        reportedItems.add(new Item("Phone", "Samsung Galaxy", "Cafeteria", "Reported"));
        reportedItems.add(new Item("Book", "Java Programming", "Classroom 101", "Reported"));

        Scanner scanner = new Scanner(System.in);

        // Login input
        System.out.print("Masukkan Username/Nama: ");
        String userInput = scanner.nextLine();
        System.out.print("Masukkan Password/NIM: ");
        String passInput = scanner.nextLine();

        User loggedIn = null;

        // Verifikasi login
        for (User user : userList) {// Itera
            if (user.login(userInput, passInput)) {
                loggedIn = user;
                break;
            }
        }

        // Jika login gagal
        if (loggedIn == null) {
            System.out.println("Login gagal.");
            return;
        }

        // Jika login berhasil
        System.out.println("Login berhasil.");

        // Menu Admin
        if (loggedIn instanceof Admin) {
            Admin admin = (Admin) loggedIn;
            while (true) {
                System.out.println("\n1. Kelola Barang\n2. Kelola Pengguna\n3. Tambah Barang Baru\n4. Logout");

                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1 -> admin.manageItems(reportedItems, scanner);
                        case 2 -> admin.manageUsers(userList, scanner, reportedItems);
                        case 3 -> {
                            // Admin menambahkan item baru
                            System.out.print("Masukkan nama barang: ");
                            String name = scanner.nextLine();
                            System.out.print("Masukkan deskripsi barang: ");
                            String desc = scanner.nextLine();
                            System.out.print("Masukkan lokasi barang: ");
                            String loc = scanner.nextLine();

                            reportedItems.add(new Item(name, desc, loc, "Reported"));
                            saveReportedItemsToFile(reportedItems);
                            System.out.println("Barang berhasil ditambahkan oleh Admin!");
                        }
                        case 4 -> {
                            System.out.println("Sampai jumpa!");
                            return;
                        }
                        default -> System.out.println("Pilihan tidak valid.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Input harus berupa angka!");
                    scanner.nextLine();
                }
            }
        }

        // Menu Mahasiswa
        else if (loggedIn instanceof Mahasiswa) {// untuk membedakan antara admin dan mahasisawa saat memeriksa kredensial
            Mahasiswa mhs = (Mahasiswa) loggedIn;
            while (true) {
                System.out.println("\n1. Laporkan Barang\n2. Lihat Laporan\n3. Tambah Barang Lagi\n4. Logout");

                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1 -> {
                            mhs.reportItem(scanner, reportedItems);
                            saveReportedItemsToFile(reportedItems);
                        }
                        case 2 -> mhs.viewReportedItems(reportedItems);
                        case 3 -> {
                            System.out.print("Masukkan nama barang: ");
                            String name = scanner.nextLine();
                            System.out.print("Masukkan deskripsi barang: ");
                            String desc = scanner.nextLine();
                            System.out.print("Masukkan lokasi barang: ");
                            String loc = scanner.nextLine();

                            reportedItems.add(new Item(name, desc, loc, "Reported"));
                            saveReportedItemsToFile(reportedItems);
                            System.out.println("Barang berhasil ditambahkan!");
                        }
                        case 4 -> {
                            System.out.println("Sampai jumpa!");
                            return;
                        }
                        default -> System.out.println("Pilihan tidak valid.");
                    }

                } catch (InputMismatchException e) { // Exception Handling
                    System.out.println("Input harus berupa angka!");
                    scanner.nextLine();
                }
            }
        }
    }

    // Simpan data item yang dilaporkan ke file teks
    public static void saveReportedItemsToFile(ArrayList<Item> items) {
        try (FileWriter writer = new FileWriter("reported_items.txt", false)) {
            for (Item item : items) {
                writer.write(item.toString() + System.lineSeparator());
            }
            System.out.println("Data barang berhasil disimpan ke reported_items.txt");
        } catch (IOException e) { //Exception
            System.out.println("Gagal menyimpan data barang: " + e.getMessage());
        }
    }

    // Simpan data user ke file teks
    public static void saveUserListToFile(ArrayList<User> users) {
        try (FileWriter writer = new FileWriter("user_list.txt", false)) {
            for (User user : users) {
                writer.write(user.getClass().getSimpleName() + ": " + user.getUsername() + System.lineSeparator());
            }
            System.out.println("Data pengguna berhasil disimpan ke user_list.txt");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data pengguna: " + e.getMessage());
        }
    }
}