public class PrakMainBankTest {

    public static void main(String[] args) {

        System.out.println("=== AKUN 1 ===");

        BankAccount acc1 = new BankAccount("REK-001", "Alifia", 1000000);

        System.out.println("Nomor Rekening : " + acc1.getAccountNumber());
        System.out.println("Nama Pemilik   : " + acc1.getOwnerName());
        System.out.println("Saldo Awal     : Rp " + acc1.getBalance());

        System.out.println("\n=== AKUN 2 ===");

        BankAccount acc2 = new BankAccount("REK-002", "Alexandria");

        System.out.println("Nomor Rekening : " + acc2.getAccountNumber());
        System.out.println("Nama Pemilik   : " + acc2.getOwnerName());
        System.out.println("Saldo Awal     : Rp " + acc2.getBalance());

        System.out.println("\n=== PENGUJIAN WITHDRAW ===");

        System.out.println("Saldo sebelum tarik : Rp " + acc1.getBalance());

        try {

            acc1.withdraw(300000);

            System.out.println("Penarikan Rp 300000 berhasil !");
            System.out.println("Saldo setelah tarik : Rp " + acc1.getBalance());

        } catch (IllegalArgumentException e) {

            System.out.println("Penarikan gagal ! " + e.getMessage());
        }

        System.out.println("\n=== WITHDRAW MELEBIHI SALDO ===");

        try {

            acc1.withdraw(10000000);

            System.out.println("Penarikan berhasil !");

        } catch (IllegalArgumentException e) {

            System.out.println("Penarikan ditolak ! " + e.getMessage());
        }

        System.out.println("\n=== DATA NAMA NULL ===");

        try {

            BankAccount acc3 = new BankAccount("REK-003", null, 500000);

            System.out.println("Object berhasil dibuat !");

        } catch (IllegalArgumentException e) {

            System.out.println("Pembuatan akun ditolak ! " + e.getMessage());
        }

        System.out.println("\n=== SALDO AWAL NEGATIF ===");

        try {

            BankAccount acc4 = new BankAccount("REK-004", "Kezia", -500000);

            System.out.println("Object berhasil dibuat !");

        } catch (IllegalArgumentException e) {

            System.out.println("Pembuatan akun ditolak ! " + e.getMessage());
        }

        System.out.println("\n=== WITHDRAW 0 ===");

        try {

            acc1.withdraw(0);

            System.out.println("Penarikan berhasil !");

        } catch (IllegalArgumentException e) {

            System.out.println("Penarikan ditolak ! " + e.getMessage());
        }
    }
}