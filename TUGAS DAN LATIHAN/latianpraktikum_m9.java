import java.util.Scanner;
public class latianpraktikum_m9 {
    private static double tambah (double a, double b){
        return a + b;
    }

    private static double kurang (double a, double b){
        return a - b;
    }

     private static double bagi (double a, double b){
        return a / b;
    }

     private static double kali (double a, double b){
        return a * b;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        System.out.print("Masukkan Angka Pertama = ");
        double a = input.nextDouble();

        System.out.print("Masukkan Angka Kedua = ");
        double b = input.nextDouble();

        System.out.println("Pilih Operasi : + - / * ");
        char op = input.next().charAt(0);

        double hasil = 0;

        switch (op) {
            case '+': hasil = tambah (a, b); break;
            case '-': hasil = kurang (a, b); break;
            case '/': hasil = bagi (a, b); break;
            case '*': hasil = kali (a, b); break;
            default:System.err.println("Operator Tidak Valid");
        }

        System.out.println("Hasil : "+a+" "+op+" "+b+" = "+hasil);
        
        //System.out.println("Hasil = "+hasil);
    }

}
