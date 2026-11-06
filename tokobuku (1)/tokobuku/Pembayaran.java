package tokobuku;

import java.util.Date;

public class Pembayaran {

    private String idPembayaran;
    private Metode_Pembayaran metode;
    private double jumlahBayar;
    private Date waktuBayar;
    private Status_Pembayaran status;

    private Nota_Penjualan nota;   // nota yang dibayar

    public Pembayaran(String idPembayaran, Metode_Pembayaran metode,
                      double jumlahBayar, Nota_Penjualan nota) {
        this.idPembayaran = idPembayaran;
        this.metode = metode;
        this.jumlahBayar = jumlahBayar;
        this.nota = nota;
        this.waktuBayar = new Date();
        this.status = Status_Pembayaran.MENUNGGU;
    }

    // jumlah yang harus dibayar mengacu pada totalSetelahPPN nota
    public void prosesPembayaran() {
        double tagihan = nota.hitungGrandTotal();
        waktuBayar = new Date();

        if (jumlahBayar >= tagihan) {
            status = Status_Pembayaran.BERHASIL;
            System.out.println("Pembayaran berhasil.");
        } else {
            status = Status_Pembayaran.GAGAL;
            System.out.println("Pembayaran gagal. Uang tidak cukup.");
        }
    }

    public double hitungKembalian() {
        double tagihan = nota.hitungGrandTotal();
        if (jumlahBayar >= tagihan) {
            return jumlahBayar - tagihan;
        }
        return 0;
    }

    public Metode_Pembayaran getMetode() { return metode; }
    public Status_Pembayaran getStatus() { return status; }
    public double getJumlahBayar() { return jumlahBayar; }
    public Date getWaktuBayar() { return waktuBayar; }
}
