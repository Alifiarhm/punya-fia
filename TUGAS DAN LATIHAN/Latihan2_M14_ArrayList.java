import java.util.Scanner;
public class Latihan2_M14_ArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Jumlah buku: ");
        int jumlahBuku = input.nextInt();
        input.nextLine();

        System.out.print("Telat: ");

        String data = input.nextLine();

        Scanner baca = new Scanner(data);
        baca.useDelimiter(" hari, | hari");

        int totalDenda = 0;

        for (int i = 0; i < jumlahBuku; i++) {
            int hari = baca.nextInt();
            totalDenda += hari * 1000;
        }

        System.out.println("Total denda = Rp" + totalDenda);
    }
}