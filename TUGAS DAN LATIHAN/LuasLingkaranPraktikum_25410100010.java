import java.util.Random;
import java.util.Scanner;
public class LuasLingkaranPraktikum_25410100010 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Masukkan Batas Random = ");
        int batas = sc.nextInt();

        System.out.println("--------------------------");

        int r = 3;

        // luas lingkaran
        double luas = Math.PI * Math.pow(r, 2);

        System.out.println("r = " + r);
        System.out.println("Luas Lingkaran = " + luas);

        sc.close();
    }
}
    

