 import java.util.Scanner;
public class ganjilGenap_25410100010 {
    public static void main(String[] args) {
        /*
        Buatlah fungsi isGanjil() yang menerima satu parameter bertipe int.
        Fungsi mengembalikan nilai boolean: true jika bilangan ganjil, false jika
        genap. Uji dengan beberapa angka. Hint: gunakan operator % (modulus)
        
        Clue:
        - tipe fungsi int
        - return value : boolean
        */
       Scanner sc = new Scanner(System.in);

       int a=0;

       System.out.print("Masukkan Angka = ");
       a = sc.nextInt();

        if (isGanjil(a)){
        System.out.println("Genap");
       } else {
        System.out.println("Ganjil");
       }
    }

    static boolean isGanjil (int angka){
        if (angka % 2 == 0){
            return true;
        } else {
            return false;
        }
    }
}