public class Main {
    public static void main(String[] args) {

         MenuItem menuCamilan = new MenuItem("Kentang Goreng", "Camilan", 8000.0, 30);
        MenuItem menuMakanan = new MenuItem("Mi Ayam", "Makanan", 12000.0, 50);
        MenuItem menuMinuman = new MenuItem("Es Teh", "Minuman", 5000.0, 50);

        System.out.println("=== INFORMASI AWAL ===");
        menuCamilan.tampilkanInformasi();
        menuMakanan.tampilkanInformasi();
        menuMinuman.tampilkanInformasi();

        System.out.println("\n=== UPDATE STOK CAMILAN ===");
        menuCamilan.updateStok(10);
        menuCamilan.tampilkanInformasi();
        menuCamilan.updateStok(-5);
        menuCamilan.tampilkanInformasi();


        System.out.println("\n=== UPDATE STOK MI AYAM ===");
        menuMakanan.updateStok(10);
        menuMakanan.tampilkanInformasi();
        menuMakanan.updateStok(-5);
        menuMakanan.tampilkanInformasi();

        System.out.println("\n=== UPDATE STOK ES TEH ===");
        menuMinuman.updateStok(-10);
        menuMinuman.tampilkanInformasi();
    }
}