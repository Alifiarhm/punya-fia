import java.util.Scanner;

public class LatihanSurabayaZooArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] kategori = new String[100];
        int[] harga = new int[100];
        int[] jumlah = new int[100];

        int n = 0;
        int pilihan;

        do {
            System.out.println("\n=== Pemesanan Tiket SurabayaZoo ===");
            System.out.println("1. Input Kategori dan Harga");
            System.out.println("2. Input Jumlah Beli");
            System.out.println("3. Lihat Total Bayar");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jumlah kategori: ");
                    n = input.nextInt();
                    input.nextLine(); // buang newline

                    for (int i = 0; i < n; i++) {
                        System.out.print("Kategori ke-" + (i + 1) + ": ");
                        kategori[i] = input.nextLine();

                        System.out.print("Harga: ");
                        harga[i] = input.nextInt();
                        input.nextLine(); // buang newline
                    }
                    break;

                case 2:
                    for (int i = 0; i < n; i++) {
                        System.out.print("Jumlah tiket untuk " + kategori[i] + ": ");
                        jumlah[i] = input.nextInt();
                    }
                    break;

                case 3:
                    int total = 0;
                    System.out.println("\n=== Detail Pembayaran ===");
                    for (int i = 0; i < n; i++) {
                        int subtotal = harga[i] * jumlah[i];
                        System.out.println(kategori[i] + " = " + jumlah[i] + 
                                           " x " + harga[i] + " = " + subtotal);
                        total += subtotal;
                    }
                    System.out.println("Total Bayar = " + total);
                    break;

                case 4:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 4);

        input.close();
    }
}
