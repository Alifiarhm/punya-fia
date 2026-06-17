/*
Minta input jumlah mahasiswa,lalu masukkan nilai tiap mahasioswa ke dalam ArrayList. Hitung dan tampilkan rata-rata nilainya.
 */

//import class Scanner & ArrayList
import java.util.Scanner;
import java.util.ArrayList;
public class Latihan1_M14_ArrayList {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Double> arrayList = new ArrayList<>();

    //prosedur input
    static void prosedurInput(){
        System.out.print("Input Jumlah Mahasiswa : ");
        int jml = sc.nextInt();

        //for loop input ArrayList
        for (int i = 0; i < jml; i++) { 
            System.out.print("Input Nilai Ke-"+(i + 1) + " : ");
            //menambahkan isi elemen --> add()
            //cara 1
            //double n = sc.nextDouble();
            //arrayList.add(n);

            //cara 2
            arrayList.add(sc.nextDouble());
        }
    }
        
    //fungsi 1 : hitung total
    static double hitungTotal(){
        //hitung total atau sum dari semua nilai mahasiswa
        double total = 0;
        //for each
        //bisa digunakan untuk semua data
        for (Double nilaiMhs : arrayList) { //-->mengulang data dari ArrayList, lali disimpan dalam variabel 1()
        total +=nilaiMhs;
        }

        //cara 2
        //for (int index = 0; i < arrayList.size; index++) {
            //total += arrayLisy.get(i);
            
        //}
        return total;
    }

    //fungsi 2 : rata-rata nilai
    static double ratarataNilai(){
        //rata-rata = total / jumlah data
        double rata = hitungTotal() / arrayList.size(); //variabelnya pake fungsi, jadi ga terpaku di variabel biasa aja
        return rata;
    }

    //prosedur output
    static void output(){
        //cetak data ArrayList secara horizontal --> 80, 90, 65, dst (arrayList)
        //cetak data ArrayList secara vertikal --> 90
        //                                         80
        //                                         65       
        //                                         dst (foreach atau fori)
        System.out.println("Daftar Nilai Mahasiswa : "+ arrayList);
        System.out.println("Rata-rata Nilai : "+ ratarataNilai());
    }

    public static void main(String[] args) {
        prosedurInput();
        output();
    }
}