package com.praktikum.models; // Mendefinisikan package untuk kelas ini

// Kelas abstrak untuk pengguna (baik Admin maupun Mahasiswa)
public abstract class User {
    protected String username; // Nama pengguna (username atau nama)
    protected String password; // Kata sandi atau NIM untuk pengguna

    // Konstruktor untuk menginisialisasi pengguna
    public User(String username, String password) {
        this.username = username; // Menetapkan username
        this.password = password; // Menetapkan password atau NIM
    }

    // Method abstrak login yang harus diimplementasikan oleh subclass
    public abstract boolean login(String userInput, String passInput); // Memeriksa kredensial login

    // Getter untuk username
    public String getUsername() {
        return username;
    }
}