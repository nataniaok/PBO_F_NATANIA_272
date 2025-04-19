import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) throws Exception {
        Scanner objInput=new Scanner(System.in);

        String userName= "Admin272";
        String password= "Password272";

        String namaMhs= "Natania Oktaviani";
        String nimMhs= "202410370110272";

        System.out.println("Pilihan login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");

        int pilihan;

        if(objInput.hasNextInt()){
            pilihan=objInput.nextInt();
            objInput.nextLine();
        }else {
            System.out.println("Pilihan tidak valid");
            objInput.close();
            return;
        }

        if (pilihan==1) {
            while (true) {
                System.out.print("Masukkan username: ");
                String intputUserName=objInput.nextLine();
                System.out.print("Masukkan password: ");
                String inputPassword=objInput.nextLine();
                if (intputUserName.equals(userName)&&inputPassword.equals(password)) {
                    System.out.println("Login berhasil sebagai admin");
                    break;
                }else{
                    System.out.println("Login gagal! Username atau password salah");
                }    
            }
            
        }else if (pilihan==2) {
            while (true) {
                System.out.print("Masukkan Nama: ");
                String intputNamaMhs=objInput.nextLine();
                System.out.print("Masukkan Nim: ");
                String inputNim=objInput.nextLine();
                if (intputNamaMhs.equals(namaMhs)&&inputNim.equals(nimMhs)) {
                    System.out.println("Login Mahasiswa berhasil");
                    System.out.println("Nama: " + intputNamaMhs);
                    System.out.println("Nim: " + inputNim);
                    break;
                }else{
                    System.out.println("Login gagal! Nama atau Nim salah");
                }    
            }
        }else{
            System.out.println("inputan tidak valid");
        }
        objInput.close();



    }
}
