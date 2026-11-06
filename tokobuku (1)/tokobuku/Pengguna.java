package tokobuku;

// Superclass abstrak: data umum Customer dan Kasir
public abstract class Pengguna {

    private String id;      // private = encapsulation
    private String nama;

    public Pengguna(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        }
    }

    // method abstrak: tiap subclass punya tampilan sendiri (polymorphism)
    public abstract void tampilkanInfo();
}
