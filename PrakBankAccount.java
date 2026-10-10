public class PrakBankAccount {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public PrakBankAccount(String accountNumber, String ownerName, double initialBalance) {

        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Nomor rekening tidak boleh null atau kosong !");
        }

        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama pemilik tidak boleh null atau kosong !");
        }

        if (initialBalance < 0) {
            throw new IllegalArgumentException("Saldo awal tidak boleh negatif !");
        }

        // Inisialisasi atribut
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public PrakBankAccount(String accountNumber, String ownerName) {
        this(accountNumber, ownerName, 0.0);
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public double getBalance() {
        return this.balance;
    }


    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Jumlah penarikan harus lebih dari 0 !");
        } 

        if (amount > this.balance) {
            throw new IllegalArgumentException("Saldo tidak mencukupi !");
        }

        this.balance -= amount;
    }
}