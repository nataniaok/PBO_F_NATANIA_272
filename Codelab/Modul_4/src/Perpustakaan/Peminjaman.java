package Perpustakaan;

public interface Peminjaman {
    void pinjamBuku(Buku buku);
    void pinjamBuku(Buku buku, int durasi);
    void kembalikanBuku(Buku buku);
}

