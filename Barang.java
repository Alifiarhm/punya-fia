package tokobuku;

public class Barang {

    private String idBarang;
    private String namaBarang;
    private double harga;
    private int stok;
    private String kategori;

    public Barang(String idBarang, String namaBarang, double harga,
                  int stok, String kategori) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
    }

    public boolean cekStok() {
        return stok > 0;
    }

    // validasi: stok tidak boleh menjadi negatif
    public void ubahStok(int jumlah) {
        if (stok + jumlah < 0) {
            System.out.println("Stok tidak boleh negatif.");
            return;
        }
        stok = stok + jumlah;
    }

    // validasi: harga harus lebih dari 0
    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga harus lebih dari 0.");
        }
    }

    public double getHarga() { return harga; }
    public String getNama() { return namaBarang; }
    public int getStok() { return stok; }
    public String getIdBarang() { return idBarang; }
    public String getKategori() { return kategori; }

    public void tampilkanBarang() {
        System.out.println("ID Barang : " + idBarang);
        System.out.println("Nama      : " + namaBarang);
        System.out.println("Harga     : Rp" + harga);
        System.out.println("Stok      : " + stok);
        System.out.println("Kategori  : " + kategori);
    }
}
