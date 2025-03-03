import java.util.Scanner;
import java.time.LocalDate;

public class DataDiriSederhana {
    public static void main(String[] args) {
        // Membuat Scanner untuk input data
        Scanner scanner = new Scanner(System.in);

        // Meminta input nama
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        // Meminta input jenis kelamin ('P' atau 'L')
        System.out.print("Masukkan jenis kelamin (P/L): ");
        char jenisKelaminInput = scanner.next().charAt(0);

        // Menentukan jenis kelamin berdasarkan input
        String jenisKelamin = (jenisKelaminInput == 'L' || jenisKelaminInput == 'l') ? "Laki-Laki" :
                (jenisKelaminInput == 'P' || jenisKelaminInput == 'p') ? "Perempuan" :
                        "Tidak valid";

        // Meminta input tahun lahir
        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = scanner.nextInt();

        // Menghitung umur berdasarkan tahun sekarang
        int tahunSekarang = LocalDate.now().getYear();
        int umur = tahunSekarang - tahunLahir;

        // Menutup Scanner
        scanner.close();

        // Menampilkan output
        System.out.println("\nData Diri:");
        System.out.println("Nama         : " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Umur         : " + umur + " tahun");
    }
}
