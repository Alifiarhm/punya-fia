
public class Majalah extends Pustaka {
    private String edisi;

    public Majalah(String judul, String pengarang, String edisi) {
        super(judul, pengarang);
        this.edisi = edisi;
    }

    @Override
    public String toString() {
        return super.toString() + " | Edisi: " + edisi;
    }
}