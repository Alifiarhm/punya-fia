public class DronePengirim extends Armada {
    private int batasKetinggianMaksimal; // Atribut khusus dalam meter

    public DronePengirim(String noPlat, String merk, double kapasitasKg, int batasKetinggianMaksimal) {
        super(noPlat, merk, kapasitasKg); // Memanggil constructor class Armada[cite: 2]
        this.batasKetinggianMaksimal = batasKetinggianMaksimal;
    }

    @Override
    public double hitungBiayaOperasional() {
        // Rumus: (kapasitasKg * 10.000) + 50.000
        return (this.kapasitasKg * 10000) + 50000;
    }

    @Override
    public void tampilkanInfoArmada() {
        System.out.println("[DRONE PENGIRIM]");
        super.tampilkanInfoArmada(); // Memanggil tampilan standar noPlat, merk, kapasitas[cite: 2]
        System.out.println("Batas Ketinggian : " + batasKetinggianMaksimal + " meter");
        System.out.println("Biaya/Hari       : Rp " + String.format("%,.2f", hitungBiayaOperasional()));
    }

    public int getBatasKetinggianMaksimal() {
        return batasKetinggianMaksimal;
    }
}
