package tokobuku;

public class Detail_Nota {

    private String idDetail;
    private String namaBarang;
    private double hargaSatuan;
    private int jumlah;
    private double subTotal;

    private Barang barang; // relasi ke Barang (0..* detail -> 1 barang)

    public Detail_Nota(String idDetail, Barang barang, int jumlah) {
        this.idDetail = idDetail;
        this.barang = barang;
        this.namaBarang = barang.getNama();
        this.hargaSatuan = barang.getHarga();
        this.jumlah = jumlah;
        this.subTotal = hitungSubTotal();
    }

    public double hitungSubTotal() {
        subTotal = hargaSatuan * jumlah;
        return subTotal;
    }

    public String getNamaBarang() { return namaBarang; }
    public Barang getBarang() { return barang; }
    public int getJumlah() { return jumlah; }
    public double getSubTotal() { return subTotal; }

    public void tampilkanDetail() {
        System.out.println(namaBarang + " x " + jumlah + " = Rp" + hitungSubTotal());
    }
}
