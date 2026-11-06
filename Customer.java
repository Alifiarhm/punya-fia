package tokobuku;

import java.util.ArrayList;

public class Customer extends Pengguna {

    private String noHP;
    private String alamat;

    public Customer(String idCustomer, String nama, String noHP, String alamat) {
        super(idCustomer, nama);   // inheritance
        this.noHP = noHP;
        this.alamat = alamat;
    }

    public void tambahCustomer(ArrayList<Customer> daftarCustomer) {
        daftarCustomer.add(this);
        System.out.println("Customer berhasil ditambahkan.");
    }

    public void ubahCustomer(String nama, String noHP, String alamat) {
        setNama(nama);
        this.noHP = noHP;
        this.alamat = alamat;
        System.out.println("Data customer berhasil diubah.");
    }

    public void hapusCustomer(ArrayList<Customer> daftarCustomer) {
        daftarCustomer.remove(this);
        System.out.println("Customer berhasil dihapus.");
    }

    public Customer cariCustomer(ArrayList<Customer> daftarCustomer, String id) {
        for (int i = 0; i < daftarCustomer.size(); i++) {
            if (daftarCustomer.get(i).getId().equals(id)) {
                return daftarCustomer.get(i);
            }
        }
        return null;
    }

    public String getIdCustomer() { return getId(); }
    public String getNoHP() { return noHP; }
    public String getAlamat() { return alamat; }

    @Override
    public void tampilkanInfo() {
        System.out.println("[Customer]");
        System.out.println("ID Customer : " + getId());
        System.out.println("Nama        : " + getNama());
        System.out.println("No HP       : " + noHP);
        System.out.println("Alamat      : " + alamat);
    }
}
