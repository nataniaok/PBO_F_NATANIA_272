import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStock {
    private static final ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        daftarBarang.add(new Barang("Pensil", 10));
        daftarBarang.add(new Barang("Buku", 5));
        daftarBarang.add(new Barang("Penghapus", 8));
        daftarBarang.remove(0);

        int pilihan;

        do {
            tampilkanMenu();
            pilihan = ambilInputAngka("Pilih opsi: ");

            switch (pilihan) {
                case 1 -> tambahBarang();
                case 2 -> tampilkanBarang();
                case 3 -> kurangiStok();
                case 4 -> hapusBarang();
                case 5 -> cariBarang();
                case 6 -> tampilkanTotalStok();
                case 0 -> System.out.println("Terima kasih! Program selesai.");
                default -> System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 0);
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== Menu Manajemen Stok ===");
        System.out.println("1. Tambah Barang Baru");
        System.out.println("2. Tampilkan Semua Barang");
        System.out.println("3. Kurangi Stok Barang");
        System.out.println("4. Hapus Barang");
        System.out.println("5. Cari Barang");
        System.out.println("6. Total Semua Stok");
        System.out.println("0. Keluar");
    }

    private static int ambilInputAngka(String prompt) {
        int input = -1;
        while (true) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }
        return input;
    }

    private static void tambahBarang() {
        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();

        int stok = ambilInputAngka("Masukkan stok awal: ");
        System.out.print("Masukkan deskripsi barang (opsional): ");
        String deskripsi = scanner.nextLine();

        Barang barang = new Barang(nama, stok, deskripsi);
        daftarBarang.add(barang);

        System.out.println("Barang " + nama + " berhasil ditambahkan.\n");
    }

    private static void tampilkanBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Daftar barang kosong.");
            return;
        }

        System.out.println("\n=== Daftar Barang ===");
        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.println((i + 1) + ". " + daftarBarang.get(i));
        }
    }

    private static void kurangiStok() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada barang untuk dikurangi.");
            return;
        }

        tampilkanBarang();
        int index = ambilInputAngka("Pilih indeks barang: ") - 1;

        if (index < 0 || index >= daftarBarang.size()) {
            System.out.println("Indeks tidak valid!");
            return;
        }

        int jumlah = ambilInputAngka("Jumlah yang akan dikurangi: ");
        try {
            daftarBarang.get(index).kurangiStok(jumlah);
            System.out.println("Stok berhasil dikurangi.");
        } catch (StockTidakCukupException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void hapusBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada barang untuk dihapus.");
            return;
        }

        tampilkanBarang();
        int index = ambilInputAngka("Pilih indeks barang yang akan dihapus: ") - 1;

        if (index < 0 || index >= daftarBarang.size()) {
            System.out.println("Indeks tidak valid!");
            return;
        }

        System.out.print("Yakin ingin menghapus barang ini? (y/n): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            Barang removed = daftarBarang.remove(index);
            System.out.println("Barang " + removed.getNama() + " berhasil dihapus.");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    private static void cariBarang() {
        System.out.print("Masukkan kata kunci nama barang: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean ditemukan = false;

        for (Barang b : daftarBarang) {
            if (b.getNama().toLowerCase().contains(keyword)) {
                System.out.println("- " + b);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    private static void tampilkanTotalStok() {
        int total = 0;
        for (Barang b : daftarBarang) {
            total += b.getStock();
        }
        System.out.println("Total seluruh stok barang: " + total);
    }
}
