public class MainMenu {
    public static void main(String[] args) {
        System.out.println("=== SISTEM PEMESANAN QUICKBITE ===");
        System.out.println("Membuat objek menu menggunakan berbagai jenis Constructor...\n");

        MenuItem menu1 = new MenuItem();

        MenuItem menu2 = new MenuItem("Burger Ayam Crispy", 25000.0);

        MenuItem menu3 = new MenuItem("Es Teh Manis Jumbo", "Minuman", 8000.0, 20);

        System.out.println("--- INFORMASI AWAL MENU ---");
        menu1.tampilInformasi();
        menu2.tampilInformasi();
        menu3.tampilInformasi();

        System.out.println("\n--- OPERASI UPDATE STOK ---");
        System.out.println("1. Penambahan stok sebanyak 15 porsi pada Burger Ayam Crispy:");
        menu2.updateStok(15);

        System.out.println("\n2. Pengurangan stok (penjualan) sebanyak 7 porsi pada Burger Ayam Crispy:");
        menu2.updateStok(-7);

        System.out.println("\n--- INFORMASI MENU SETELAH UPDATE STOK ---");
        menu2.tampilInformasi();
    }
}