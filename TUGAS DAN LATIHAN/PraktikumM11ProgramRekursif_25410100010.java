import java.util.Scanner;

public class PraktikumM11ProgramRekursif_25410100010 {

    public static int faktorial(int n){
        if (n==1) { //kondisi berhenti (base case)
            return 1;
        } else {
            return n * faktorial(n-1); //pemanggilan dirinya sendiri (rekursif)
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        System.out.print("Masukkan Angka = ");
        int angka = input.nextInt();

        int hasil = faktorial(angka);
        System.out.println("Hasil faktorial dari " + angka + " adalah: " + hasil);
    }
}
