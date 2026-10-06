public class MainBankTest {

    public static void main(String[] args) {

        System.out.println("=== DATA AKUN 1 ===");

        BankAccount acc1 = new BankAccount(
            "REK-001",
            "Alifia",
            1000000
        );

        System.out.println("Nomor Rekening : " + acc1.getAccountNumber());
        System.out.println("Nama Pemilik   : " + acc1.getOwnerName());
        System.out.println("Saldo          : " + acc1.getBalance());


        System.out.println("\n=== DATA AKUN 2 ===");

        BankAccount acc2 = new BankAccount(
            "REK-002",
            "Xandria"
        );

        System.out.println("Nomor Rekening : " + acc2.getAccountNumber());
        System.out.println("Nama Pemilik   : " + acc2.getOwnerName());
        System.out.println("Saldo          : " + acc2.getBalance());

        System.out.println("\n=== PENGUJIAN DEPOSIT ===");

        acc1.deposit(500000);

        System.out.println(
            "Saldo setelah deposit : " + acc1.getBalance()
        );

        System.out.println("\n=== PENGUJIAN WITHDRAW ===");

        acc1.withdraw(250000);

        System.out.println(
            "Saldo setelah withdraw : " + acc1.getBalance()
        );

        System.out.println("\n=== WITHDRAW MELEBIHI SALDO ===");

        try {

            acc2.withdraw(100000);

        } catch (IllegalArgumentException e) {

            System.out.println("Penolakan ! " + e.getMessage());

        }

        System.out.println("\n=== SALDO AWAL NEGATIF ===");

        try {

            BankAccount acc3 = new BankAccount(
                "REK-003",
                "Kezia",
                -5000000
            );

        } catch (IllegalArgumentException e) {

            System.out.println("Penolakan ! " + e.getMessage());

        }

        System.out.println("\n=== NAMA NULL ===");

        try {

            BankAccount acc4 = new BankAccount(
                "REK-004",
                null,
                500000
            );

        } catch (IllegalArgumentException e) {

            System.out.println("Penolakan ! " + e.getMessage());

        }
    }
}