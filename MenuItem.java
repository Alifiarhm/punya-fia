public class MenuItem {
  
    private String namaMenu;
    private String kategori;
    private double harga;
    private int stok;

    public MenuItem() {
        this("Menu Belum Dinamai", "Umum", 0.0, 0);
    }

    public MenuItem(String namaMenu, double harga) {
        this(namaMenu, "Makanan", harga, 10);
    }

    public MenuItem(String namaMenu, String kategori, double harga, int stok) {
        this.namaMenu = namaMenu; // Keyword 'this' membedakan atribut kelas dan parameter
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    public void tampilInformasi() {
        System.out.println("==========================================");
        System.out.println("Nama Menu : " + this.namaMenu);
        System.out.println("Kategori  : " + this.kategori);
        System.out.printf( "Harga     : Rp %,.2f\n", this.harga);
        System.out.println("Stok      : " + this.stok + " porsi");
        System.out.println("==========================================");
    }

    public void updateStok(int jumlah) {
        if (jumlah < 0 && (this.stok + jumlah) < 0) {
            System.out.println("❌ Gagal mengupdate stok! Stok " + this.namaMenu + " tidak mencukupi.");
        } else {
            this.stok += jumlah;
            System.out.println("✅ Stok " + this.namaMenu + " berhasil diperbarui. Stok saat ini: " + this.stok);
        }
    }

    public String getNamaMenu() { return namaMenu; }
    public String getKategori() { return kategori; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
}