
public class Pustaka {
    private String judul;
    private String pengarang;
    private boolean tersedia;

    public Pustaka(String judul, String pengarang) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tersedia = true;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    @Override
    public String toString() {
        String status = tersedia ? "Tersedia" : "Dipinjam";

        return "Judul : " + judul + " | Pengarang : " + pengarang + " | Status : " + status;
    }
}
