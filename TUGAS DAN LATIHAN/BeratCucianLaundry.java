import java.util.Scanner;

public class BeratCucianLaundry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        Sebuah laundry menerima pelanggan sebanyak 3 kali transaksi dalam sehari. Setiap transaksi, pengguna memasukkan berat cucian dan program langsung menampilkan berat tersebut. Setelah semua transaksi selesai, program menghitung total berat cucian.
         */

        //Deklarasi
        String namaPelanggan;
        String jenisCucian;
        double beratCucian=0;
        double totalBerat=0;

        //Pengulangan sebanyak 3 kali
        for (int i = 1; i <= 3; i++) {
            // Input
            System.out.println("Transaksi ke : " + (i));

            System.out.print("Nama Pelanggan : ");
            namaPelanggan = scanner.nextLine();

            System.out.print("Jenis Cucian : ");
            jenisCucian = scanner.nextLine();

            System.out.print("Berat Cucian (Kg) : ");
            beratCucian = scanner.nextDouble(); 

            System.out.println();
            scanner.nextLine(); //resolve debug

            //Menghitung total berat
            totalBerat = totalBerat + beratCucian;
        }
        //output
        System.out.println("Total Berat Cucian : " + totalBerat + "kg");

        scanner.close();
    }
}