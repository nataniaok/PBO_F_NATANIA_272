import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        admin admin = new admin();
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.print("Pilih jenis login (1. Admin \n 2. Mahasiswa): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // buang newline

        if (pilihan == 1) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            if (admin.verify(username, password)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Username atau password salah.");
            }

        } else if (pilihan == 2) {
            System.out.print("Masukkan nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            if (mahasiswa.verify(nama, nim)) {
                mahasiswa.displayInfo();
            } else {
                System.out.println("Nama atau NIM salah.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}
