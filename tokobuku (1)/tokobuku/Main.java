package tokobuku;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Toko_Buku toko = new Toko_Buku("T001", "Bukit Menoreh", "Surabaya", "081234567890");

        Barang b1 = new Barang("B001", "Blockchain: Teknologi 5.0", 93000, 20, "Teknologi");
        Barang b2 = new Barang("B002", "Cantik itu Luka", 125000, 15, "Novel");
        Barang b3 = new Barang("B003", "The King Bedah Tuntas SNBT dan TPS", 317400, 10, "Pendidikan");
        Barang b4 = new Barang("B004", "Rasa Tanah Air", 108000, 12, "Kuliner");
        Barang b5 = new Barang("B005", "Sejarah Dunia yang Disembunyikan", 169930, 8, "Sejarah");

        toko.kelolaBarang(b1);
        toko.kelolaBarang(b2);
        toko.kelolaBarang(b3);
        toko.kelolaBarang(b4);
        toko.kelolaBarang(b5);

        Customer customer = new Customer("C001", "Wanda", "081234567890", "Surabaya");
        ArrayList<Customer> daftarCustomer = new ArrayList<Customer>();
        customer.tambahCustomer(daftarCustomer);

        Kasir kasir = new Kasir("K001", "Peter Parker", "admin", "12345");

        System.out.println("\n========== LOGIN ==========");
        if (kasir.login()) {

            Nota_Penjualan nota = new Nota_Penjualan("N001", customer, kasir);

            nota.tambahItem(new Detail_Nota("D001", b1, 1));
            nota.tambahItem(new Detail_Nota("D002", b2, 1));
            nota.tambahItem(new Detail_Nota("D003", b3, 1));
            nota.tambahItem(new Detail_Nota("D004", b4, 1));
            nota.tambahItem(new Detail_Nota("D005", b5, 1));

            Pembayaran pembayaran = new Pembayaran("P001", Metode_Pembayaran.TUNAI, 2500000, nota);
            nota.prosesPembayaran(pembayaran);

            if (nota.getStatus() == Status_Nota.LUNAS) {
                toko.kelolaStok(new Stok_Barang("STK1", b1, 1, "KELUAR"));
                toko.kelolaStok(new Stok_Barang("STK2", b2, 1, "KELUAR"));
                toko.kelolaStok(new Stok_Barang("STK3", b3, 1, "KELUAR"));
                toko.kelolaStok(new Stok_Barang("STK4", b4, 1, "KELUAR"));
                toko.kelolaStok(new Stok_Barang("STK5", b5, 1, "KELUAR"));
                nota.cetakNota();
            }

            toko.cetakLaporan();
            toko.kelolaStok();

            System.out.println("\nRIWAYAT NOTA KASIR");
            for (int i = 0; i < kasir.lihatRiwayat().size(); i++) {
                System.out.println(kasir.lihatRiwayat().get(i).getNoNota());
            }

            kasir.logout();
        }

        // Demonstrasi polymorphism: satu tipe Pengguna, perilaku berbeda
        System.out.println("\n========== DAFTAR PENGGUNA ==========");
        ArrayList<Pengguna> daftarPengguna = new ArrayList<Pengguna>();
        daftarPengguna.add(customer);
        daftarPengguna.add(kasir);

        for (int i = 0; i < daftarPengguna.size(); i++) {
            daftarPengguna.get(i).tampilkanInfo();
            System.out.println("------------------------------");
        }
    }
}
