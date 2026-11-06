package tokobuku;

import java.util.ArrayList;

public class Toko_Buku {

    private String idToko;
    private String namaToko;
    private String alamat;
    private String noTelp;

    private ArrayList<Barang> daftarBarang;
    private ArrayList<Stok_Barang> daftarStok;   // agregasi 1 -> 0..* Stok_Barang

    public Toko_Buku(String idToko, String namaToko, String alamat, String noTelp) {
        this.idToko = idToko;
        this.namaToko = namaToko;
        this.alamat = alamat;
        this.noTelp = noTelp;
        daftarBarang = new ArrayList<Barang>();
        daftarStok = new ArrayList<Stok_Barang>();
    }

    public ArrayList<Barang> cariBarang(String nama) {
        ArrayList<Barang> hasil = new ArrayList<Barang>();
        for (Barang b : daftarBarang) {
            if (b.getNama().equalsIgnoreCase(nama)) {
                hasil.add(b);
            }
        }
        return hasil;
    }

    // mencatat perubahan stok (masuk / keluar)
    public void kelolaStok(Stok_Barang catatan) {
        if (catatan.getJenisMutasi().equals("MASUK")) {
            catatan.tambahStok();
        } else {
            catatan.kurangStok();
        }
        daftarStok.add(catatan);
    }

    // menampilkan riwayat stok
    public void kelolaStok() {
        System.out.println("\nRiwayat Stok Barang:");
        for (int i = 0; i < daftarStok.size(); i++) {
            System.out.println("------------------------------");
            daftarStok.get(i).tampilkanRiwayat();
        }
    }

    public void kelolaBarang(Barang barang) {
        daftarBarang.add(barang);
        System.out.println("Barang berhasil ditambahkan: " + barang.getNama());
    }

    public void cetakLaporan() {
        System.out.println("\n========== LAPORAN " + namaToko + " ==========");
        System.out.println("ID Toko : " + idToko);
        System.out.println("Alamat  : " + alamat);
        System.out.println("No Telp : " + noTelp);
        System.out.println("\nDAFTAR BARANG");
        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.println("------------------------------");
            daftarBarang.get(i).tampilkanBarang();
        }
        System.out.println("====================================");
    }

    public ArrayList<Barang> getDaftarBarang() { return daftarBarang; }
}
