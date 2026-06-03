import java.util.Scanner;
public class Latihan2M10 {

    static Scanner sc = new Scanner(System.in);

    static void InputData(){
        System.out.print("Masukkan Nama Barang :");
        String namaBarang = sc.nextLine(); 

          System.out.print("Masukkan Jumlah Barang :");
        int jumlahBarang = sc.nextInt();

          System.out.print("Masukkan Harga Barang :");
        int hargaBarang = sc.nextInt();

        hitungTotal(jumlahBarang, hargaBarang);
    }

       static int hitungTotal (int jumlah, int harga) {
        int HitungTotal = jumlah * harga;
        System.out.println("Total Bayar :" + HitungTotal);
        return HitungTotal;
       }

    public static void main(String[] args) {
        /*
        1. Procedure InputData Penjualan dengan variabel namaBarang, jumlahBarang, hargaBarang
        2. Function hitungTotal dengan parameter harga dan jumlah bertipe int
        3. Total pembayaran diproses pada procedure Input
        4. Procedure outputData untuk menampilkan data barang dan total pembayaran
        */

        InputData();
    }
    
}
