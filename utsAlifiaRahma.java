//Buatlah sebuah program untuk mengevaluasi kehadiran mahasiswa dalam satu mata u=kuliah. User Perlu memasukkan jumlah total pertemuan selama 1 semester terlebih dahulu yang disimpan dalam variabel (14-16 pertemuan). Kemudian, nama mahasiswa, tanggal pertemuan, dan kehadiran diisi dan disimpan dalam array 1 dimensi. Kehadiran mahasiswa dapat diisi angka 1 (Hadir) dan 0 (Tidak hadir). Program harus dapat menghitung total kehadiran mahasiswa dan persentasenya, dengan rumus persentase sebagai berikut : Persentase = (Total kehadiran / Total pertemuan) * 100. Persentase kehadiran mahasiswa akan dievaluasi dengan program untuk menampilkan status kehadiran. Adapun ketentuan status kehadiran adalah : 1. Jika persentase > 75%, maka status kehadiran menjadi "Baik". 2. Jika persentase < 75% maka status kehadiran menjadi "Kurang"
import java.util.Scanner;
public class utsAlifiaRahma {
public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);

    // 1. Input jumlah pertemuan
        System.out.print("Masukkan jumlah pertemuan (14-16): ");
        int totalPertemuan = sc.nextInt();
        sc.nextLine();

        // 2. Input nama
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = sc.nextLine();

        // 3. Array tanggal & kehadiran
        String[] tanggal = new String[totalPertemuan];
        int[] kehadiran = new int[totalPertemuan];

        // 4. Input data
        for (int i = 0; i < totalPertemuan; i++) {
            System.out.println("\nPertemuan ke-" + (i + 1));

            System.out.print("Tanggal: ");
            tanggal[i] = sc.nextLine();

            System.out.print("Kehadiran (1=Hadir, 0=Tidak): ");
            kehadiran[i] = sc.nextInt();
            sc.nextLine(); // buang enter
        }

        // 5. Hitung total hadir
        int totalHadir = 0;
        for (int i = 0; i < totalPertemuan; i++) {
            if (kehadiran[i] == 1) {
                totalHadir++;
            }
        }

        // 6. Hitung persentase
        double persentase = ((double) totalHadir / totalPertemuan) * 100;

        // 7. Status
        String status;
        if (persentase > 75) {
            status = "Baik";
        } else {
            status = "Kurang";
        }

        // 8. Output
        System.out.println("\n=== DATA KEHADIRAN ===");
        for (int i = 0; i < totalPertemuan; i++) {
            System.out.println("Pertemuan ke-" + (i + 1) +
                    " | Tanggal: " + tanggal[i] +
                    " | Kehadiran: " + kehadiran[i]);
        }

        System.out.println("\n=== HASIL ===");
        System.out.println("Nama Mahasiswa : " + nama);
        System.out.println("Total Hadir    : " + totalHadir);
        System.out.println("Persentase     : " + persentase + "%");
        System.out.println("Status         : " + status);

        sc.close();
    }
}