public class RekeningBank {
    // membuat atribut dengan tipe data string dan double
    String nomorRekening;
    String namaPemilik;
    double saldo;

    //membuat methodee yang mencetak informasi rekening
    void tampilkanInfor() {
        System.out.println("\nNomor Rekening : " + nomorRekening);
        System.out.println("Nama Pemilik : " + namaPemilik);
        System.out.println("Saldo : " + saldo + "\n");
    }
     // membuat methode yang mencetak informai transaksi (menambhkan  jumlah setoran dan saldo awal)
    void setorUang (double jumlah) {
        saldo += jumlah;
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang : Rp" + saldo);
    }
    //membuat methode yang mencetak transaksi (mengurangi jumlah penarikan dengan saldo awal)
    void  tarikUang (double jumlah) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("\n" + namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang : Rp" + saldo);
        } else {
            //apabila saldo yang ingin ditarik kurang dari saldo awal, maka saldo tidak akan berkurang
            System.out.println("\n" + namaPemilik + " menarik Rp" + jumlah + ". (Gagal, saldo tidak mencukupi) saldo saat ini : Rp" + jumlah);

        }
    }
}
