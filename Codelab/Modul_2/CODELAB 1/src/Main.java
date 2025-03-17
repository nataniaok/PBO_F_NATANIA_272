public class Main {
    public static  void  main(String[] args) {
        // membuat 2 object
        HEWAN hewan1 = new HEWAN();
        HEWAN hewan2 = new HEWAN();

        //menetapkan nama tiap object
        hewan1.Nama = "Kucing";
        hewan2.Nama = "Anjing";

        hewan1.Jenis = "Mamalia";
        hewan2.Jenis = "Mamalia";

        hewan1.Suara = "Nyann~~";
        hewan2.Suara = "Woof-woof! !";

        //memanggil methode pada kedua object dari kelas hewan
        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}
