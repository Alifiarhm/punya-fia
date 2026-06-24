
    /*
    minta input jumlah buku yang dipinjam. untuk tiap buku, 
    masukkan jumlah hari keterlambatan ke arrayList. Hitung total denda
    denda = hari telat* 1000;
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Latihan2_M14_ArrayList {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> aList = new ArrayList<Integer>();
    
    //proc input
    static void input(){
        System.out.print("input jumlah buku : ");
        int jml = sc.nextInt();
        for (int i = 0; i < jml; i++) {
            System.out.print("input hari buku ke-"+(i+1)+": ");
            aList.add(sc.nextInt());
        }

    }

    //func hitung denda (hari telat per buku*1000)
    static Integer hitungDenda(){
        int denda = 0;

        for (Integer dendaTelat : aList) {
            denda = dendaTelat*1000;
        }
        return denda;
    }
    //func hitung total denda(sum hitung denda)
    static Integer hitungTotal(){
        int total = 0;
        for (Integer totalDenda : aList) {
            total += (totalDenda*1000);
        }
            
        return total;
    }
    //proc output
    static void output(){
        System.out.println("Telat : " +aList);
        System.out.println("Total denda perbuku "+hitungDenda());
        System.out.println("Total denda : "+hitungTotal());
    }

    public static void main(String[] args) {
        input();
        output();
    }
}