import java.util.Scanner;
public class latihan1_m9 {
    //variabel class-level : variabel dibaca/digunakan di semua blok kode
    //keyword static
    static int pj, lb;
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        //memanggil fungsi
        int panjang=0,lebar=0;
        System.out.print("Masukkan panjang (cm) : ");
        panjang = sc.nextInt();
        System.out.print("Masukkan lebar (cm) : ");
        lebar = sc.nextInt();
        System.out.println();//baris kosong

        //memanggil fungsi
        System.out.println("Luas persegi panjang : "+ hitungLuas(panjang, lebar));
    }

    //membuat fungsi 
    //tipe data pada parameter sama denganb tipe data pada fungsi
    //rumus = panjang * lebar
    static int hitungLuas(int p, int l) {
        int luas = p * l; //hasil dari rumus akan dihitung sesuai angka dari user
        return luas; //hasil luas akan terus dikembalikan nilainya
    }

    /*overloading function : pembuatan fungsi dengan nama yang sama
    namun dengan jumlah parameter yang berbeda
    */

    //fungsi hitung luas tanpa parameter
    static int hitungLuas() {
        int luas = pj * lb;
        return luas;
    }

}
