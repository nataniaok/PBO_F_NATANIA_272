public class Barang {
    private String nama;
    private int stock;
    private String deskripsi;

    public Barang(String nama, int stock) {
        this.nama = nama;
        this.stock = stock;
        this.deskripsi = ""; // default kosong
    }

    // ✅ Tambahkan konstruktor 3 parameter
    public Barang(String nama, int stock, String deskripsi) {
        this.nama = nama;
        this.stock = stock;
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public int getStock() {
        return stock;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void kurangiStok(int jumlah) throws StockTidakCukupException {
        if (jumlah > stock) {
            throw new StockTidakCukupException("Stok tidak mencukupi!");
        }
        this.stock -= jumlah;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Stok: " + stock + (deskripsi.isEmpty() ? "" : ", Deskripsi: " + deskripsi);
    }
}

