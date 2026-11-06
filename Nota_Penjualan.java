package tokobuku;

import java.util.Date;

public class Nota_Penjualan {

    private String noNota;
    private String namaCustomer;
    private String noHP;
    private Date tanggal;
    private int totalItem;
    private double grandTotal;        // total sebelum PPN
    private double ppn;               // 11%
    private double totalSetelahPPN;
    private Status_Nota status;

    private Customer customer;        // relasi: customer 1 -> 0..* nota
    private Kasir kasir;              // relasi: kasir 1 -> 0..* nota
    private Nota_Detail_Item daftarItem;  // pengelola 1..5 DetailNota
    private Pembayaran pembayaran;
    private Nota_Penjualan notaLanjutan;  // nota baru jika item > 5

    public Nota_Penjualan(String noNota, Customer customer, Kasir kasir) {
        this.noNota = noNota;
        this.customer = customer;
        this.kasir = kasir;
        this.namaCustomer = customer.getNama();
        this.noHP = customer.getNoHP();
        this.tanggal = new Date();

        daftarItem = new Nota_Detail_Item();
        status = Status_Nota.DRAFT;

        kasir.buatNota(this);
    }

    public double hitungTotal() {
        double total = 0;
        Detail_Nota[] items = daftarItem.getItems();
        for (int i = 0; i < daftarItem.getTotalItem(); i++) {
            total = total + items[i].hitungSubTotal();
        }
        grandTotal = total;
        return grandTotal;
    }

    public double hitungPPN() {
        ppn = hitungTotal() * 0.11;
        return ppn;
    }

    public double hitungGrandTotal() {
        totalSetelahPPN = hitungTotal() + hitungPPN();
        return totalSetelahPPN;
    }

    public void tambahItem(Detail_Nota item) {
        if (daftarItem.cekLimitItem()) {
            daftarItem.tambahItem(item);
            totalItem = daftarItem.getTotalItem();
        } else {
            // sudah 5 item berbeda -> catat di nota baru
            if (notaLanjutan == null) {
                buatNotaBaru();
            }
            notaLanjutan.tambahItem(item);
        }
    }

    // membuat nota baru (untuk item ke-6 dst)
    public void buatNotaBaru() {
        notaLanjutan = new Nota_Penjualan(noNota + "-L", customer, kasir);
        System.out.println("Item melebihi 5, nota baru dibuat: " + notaLanjutan.getNoNota());
    }

    public void prosesPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
        pembayaran.prosesPembayaran();

        if (pembayaran.getStatus() == Status_Pembayaran.BERHASIL) {
            status = Status_Nota.LUNAS;
        }
    }

    public void cetakNota() {
        System.out.println("\n========== NOTA PENJUALAN ==========");
        System.out.println("No Nota      : " + noNota);
        System.out.println("Nama Customer: " + namaCustomer);
        System.out.println("No HP        : " + noHP);
        System.out.println("Tanggal      : " + tanggal);
        System.out.println("------------------------------------");

        daftarItem.tampilkanItems();

        System.out.println("------------------------------------");
        System.out.println("Total Item   : " + totalItem);
        System.out.println("Total        : Rp" + hitungTotal());
        System.out.println("PPN 11%      : Rp" + hitungPPN());
        System.out.println("Total Bayar  : Rp" + hitungGrandTotal());

        if (pembayaran != null) {
            System.out.println("Metode       : " + pembayaran.getMetode());
            System.out.println("Status Bayar : " + pembayaran.getStatus());
            System.out.println("Kembalian    : Rp" + pembayaran.hitungKembalian());
        }

        System.out.println("Status Nota  : " + status);
        System.out.println("====================================");
    }

    public String getNoNota() { return noNota; }
    public Status_Nota getStatus() { return status; }
    public Nota_Penjualan getNotaLanjutan() { return notaLanjutan; }
}
