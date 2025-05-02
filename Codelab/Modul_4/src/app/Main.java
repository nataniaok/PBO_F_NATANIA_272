package app;

import Perpustakaan.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Buku sudah tetap (tanpa input manual)
        Buku buku1 = new NonFiksi("Madilog", "Tan Malaka");
        Buku buku2 = new Fiksi("HainumLee: Sang Putri Kelapa", "Lilis Hw");

        System.out.println();
        buku1.displayInfo();
        buku2.displayInfo();

        // Input anggota pertama
        System.out.println("\n=== Input Anggota 1 ===");
        System.out.print("Masukkan nama: ");
        String nama1 = input.nextLine();
        System.out.print("Masukkan ID anggota: ");
        String id1 = input.nextLine();
        Anggota anggota1 = new Anggota(nama1, id1);

        // Input anggota kedua
        System.out.println("\n=== Input Anggota 2 ===");
        System.out.print("Masukkan nama: ");
        String nama2 = input.nextLine();
        System.out.print("Masukkan ID anggota: ");
        String id2 = input.nextLine();
        Anggota anggota2 = new Anggota(nama2, id2);

        System.out.println();
        anggota1.displayInfo();
        anggota2.displayInfo();

        // Proses otomatis setelah input
        System.out.println();
        anggota1.pinjamBuku(buku1);
        anggota2.pinjamBuku(buku2, 7);

        // Proses pengembalian otomatis
        System.out.println();
        anggota1.kembalikanBuku(buku1);
        anggota2.kembalikanBuku(buku2);

        input.close();
    }
}
