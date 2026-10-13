public class MainBuku {
    public static void main(String[] args) {

        Buku buku = new Buku("Laskar Pelangi", "Andrea Hirata", 529);
        Majalah majalah = new Majalah("National Geographic", "Susan Goldberg", "Edisi Oktober 2026");

        System.out.println("=== STATUS AWAL PERPUSTAKAAN ===");
        System.out.println(buku);
        System.out.println(majalah);

        System.out.println("\n=== PROSES PEMINJAMAN BUKU ===");
        System.out.println("Buku dipinjam oleh seorang mahasiswa.");

        buku.setTersedia(false);

        System.out.println("\n=== STATUS SETELAH PEMINJAMAN ===");
        System.out.println(buku);
        System.out.println(majalah);
    }
}
