public class Main {
    public static  void main(String[] arsg){
        RekeningBank rekening1 = new RekeningBank();
        RekeningBank rekening2 = new RekeningBank();

        rekening1.nomorRekening = "202410370110272";
        rekening2.nomorRekening = "202410370110272";

        rekening1.namaPemilik = "Natania oktaviani";
        rekening2.namaPemilik = "Yunus";

        rekening1.saldo = 2000000;
        rekening2.saldo = 1200000;

        rekening1.tampilkanInfor();
        rekening2.tampilkanInfor();

        rekening1.setorUang(300000);
        rekening2.setorUang(500000);

        rekening1.tarikUang(3000000);
        rekening2.tarikUang(90000);

        rekening1.tampilkanInfor();
        rekening2.tampilkanInfor();
    }
}
