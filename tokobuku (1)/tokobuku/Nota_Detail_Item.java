package tokobuku;

public class Nota_Detail_Item {

    private static final int MAKS_ITEM = 5;

    private Detail_Nota[] items;   // array maksimal 5 item berbeda
    private int jumlahItems;

    public Nota_Detail_Item() {
        items = new Detail_Nota[MAKS_ITEM];
        jumlahItems = 0;
    }

    // true jika masih ada tempat kosong di array
    public boolean cekLimitItem() {
        return jumlahItems < MAKS_ITEM;
    }

    public boolean tambahItem(Detail_Nota item) {
        if (!cekLimitItem()) {
            return false;
        }
        items[jumlahItems] = item;
        jumlahItems++;
        return true;
    }

    public void hapusItem(String namaBarang) {
        for (int i = 0; i < jumlahItems; i++) {
            if (items[i].getNamaBarang().equals(namaBarang)) {
                for (int j = i; j < jumlahItems - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[jumlahItems - 1] = null;
                jumlahItems--;
                System.out.println("Item berhasil dihapus.");
                return;
            }
        }
    }

    public int getTotalItem() {
        return jumlahItems;
    }

    public Detail_Nota[] getItems() {
        return items;
    }

    public void tampilkanItems() {
        for (int i = 0; i < jumlahItems; i++) {
            items[i].tampilkanDetail();
        }
    }
}
