package tokobuku;

import java.util.ArrayList;

public class Kasir extends Pengguna implements Autentikasi {

    private String username;
    private String password;

    private ArrayList<Nota_Penjualan> daftarNota;

    public Kasir(String idKasir, String nama, String username, String password) {
        super(idKasir, nama);   // inheritance
        this.username = username;
        this.password = password;
        daftarNota = new ArrayList<Nota_Penjualan>();
    }

    @Override
    public boolean login() {
        if (username.equals("admin") && password.equals("12345")) {
            System.out.println("Login berhasil. Selamat bekerja, " + getNama());
            return true;
        } else {
            System.out.println("Login gagal.");
            return false;
        }
    }

    @Override
    public void logout() {
        System.out.println("Kasir " + getNama() + " berhasil logout.");
    }

    public void buatNota(Nota_Penjualan nota) {
        daftarNota.add(nota);
        System.out.println("Nota " + nota.getNoNota() + " dibuat oleh kasir " + getNama() + ".");
    }

    public ArrayList<Nota_Penjualan> lihatRiwayat() {
        return daftarNota;
    }

    public String getIdKasir() { return getId(); }

    @Override
    public void tampilkanInfo() {
        System.out.println("[Kasir]");
        System.out.println("ID Kasir : " + getId());
        System.out.println("Nama     : " + getNama());
        System.out.println("Username : " + username);   // password tidak ditampilkan
    }
}
