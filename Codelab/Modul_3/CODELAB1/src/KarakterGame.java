public class KarakterGame {
    private int kesehatan;
    private String nama;

    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public String getNama() {
        return nama;
    }

    public void serang(KarakterGame target) {
        System.out.println(nama + " menyerang " + target.getNama());
    }
}


