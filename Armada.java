
public abstract class Armada {
    protected String noPlat;
    protected String merk;
    protected double kapasitasKG;

    public Armada(String noPlat, String merk, double kapasitasKG) {
        this.noPlat = noPlat;
        this.merk = merk;
        this.kapasitasKG = kapasitasKG;
    }

    public abstract double hitungBiayaOperasional();
    public void tampilkanInfoArmada() {
        System.out.println("No. Plat : " + noPlat);
        System.out.println("Merk : " + merk);
        System.out.println("Kapasitas : " + kapasitasKG + "KG");

    }
}
