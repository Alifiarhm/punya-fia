package tokobuku;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Satu objek = satu catatan perubahan stok untuk satu Barang
public class Stok_Barang {

    private String idStok;
    private int jumlah;
    private String jenisMutasi;   // "MASUK" / "KELUAR"
    private Date tanggal;

    private Barang barang;        // relasi: 1 barang -> 0..* catatan stok

    public Stok_Barang(String idStok, Barang barang, int jumlah, String jenisMutasi) {
        this.idStok = idStok;
        this.barang = barang;
        this.jumlah = jumlah;
        this.jenisMutasi = jenisMutasi;
        this.tanggal = new Date();
    }

    public void tambahStok() {
        barang.ubahStok(jumlah);
        jenisMutasi = "MASUK";
        System.out.println("Stok " + barang.getNama() + " bertambah " + jumlah);
    }

    public void kurangStok() {
        if (barang.getStok() >= jumlah) {
            barang.ubahStok(-jumlah);
            jenisMutasi = "KELUAR";
            System.out.println("Stok " + barang.getNama() + " berkurang " + jumlah);
        } else {
            System.out.println("Stok tidak mencukupi.");
        }
    }

    public List<Stok_Barang> getRiwayat() {
        List<Stok_Barang> hasil = new ArrayList<Stok_Barang>();
        hasil.add(this);
        return hasil;
    }

    public Barang getBarang() { return barang; }
    public String getJenisMutasi() { return jenisMutasi; }

    public void tampilkanRiwayat() {
        System.out.println("ID Stok      : " + idStok);
        System.out.println("Barang       : " + barang.getNama());
        System.out.println("Jumlah       : " + jumlah);
        System.out.println("Jenis Mutasi : " + jenisMutasi);
        System.out.println("Tanggal      : " + tanggal);
    }
}
