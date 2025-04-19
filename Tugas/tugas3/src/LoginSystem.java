import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Natania Oktaviani", "202410370110272", "admin272", "pass272");
        Mahasiswa mhs = new Mahasiswa("Natania Oktaviani", "202410370110272");

        System.out.println("Login sebagai: (1) Admin  (2) Mahasiswa");
        String pilihan = scanner.nextLine();

        boolean berhasil = false;

        if (pilihan.equals("1")) {
            System.out.print("Username: ");
            String user = scanner.nextLine();
            System.out.print("Password: ");
            String pass = scanner.nextLine();

            berhasil = admin.login(user, pass);
            if (berhasil) {
                System.out.println("Login berhasil!");
                admin.displayInfo();
            }
        } else if (pilihan.equals("2")) {
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("NIM: ");
            String nim = scanner.nextLine();

            berhasil = mhs.login(nama, nim);
            if (berhasil) {
                mhs.displayInfo();
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        if (!berhasil) {
            System.out.println("Login gagal. Periksa kembali data yang dimasukkan.");
        }

        scanner.close();
    }
}
