public class MenuItem {
    private String namaMenu;
    private String kategori;
    private Double harga;
    private int stok;

    public MenuItem(String namaMenu, String kategori, Double harga, int stok){
        this.namaMenu = namaMenu;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    public MenuItem(){
        this("Menu Tidak Ada", "Umum", 0.0, 0);
    }
    
    public void tampilkanInformasi(){
        System.out.println("============================");
        System.out.println("Nama Menu : " + this.namaMenu);
        System.out.println("Kategori : " + this.kategori);
        System.out.println("Harga : " + this.harga);
        System.out.println("Sisa Stok : " + this.stok);
        System.out.println("============================");
    }

    public void updateStok(int jumlah){
        this.stok += jumlah;
        if(this.stok < 0){
            this.stok = 0;
        }
        System.out.println("Informasi Stok " + this.namaMenu + " Berhasil Diupdate");
    }
}
