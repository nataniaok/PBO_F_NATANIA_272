public class Mahasiswa {
    private String nama = "Natania Oktaviani";
    private String nim = "202410370110272";

    public boolean verify(String nama, String nim) {
        return this.nama.equalsIgnoreCase(nama) && this.nim.equals(nim);
    }

    public void displayInfo() {
        System.out.println("Login berhasil!");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}
