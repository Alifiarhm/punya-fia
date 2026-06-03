import java.util.Scanner;
public class Latihan1M10 {
    //blok class
    //membuat prosedur atau function, serta variabel class-level(global)
    //variabel class-level : static
    static Scanner sc = new Scanner(System.in);

    //procedur input >> harus ada scanner
    static void inputData() { //int yang ada di dalam juga gabisa pake/minjem di fuction
        //nilai tugas, nilai uts, nilai uas
        System.out.print("Masukkan Nilai Tugas : ");
        int nTugas = sc.nextInt();

        System.out.print("Masukkan Nilai UTS : ");
        int nUTS = sc.nextInt();

        System.out.print("Masukkan Nilai UAS : ");
        int nUAS = sc.nextInt();

        //panggil fungtion 
        nilaiAkhir(nTugas, nUTS, nUAS); //gabisa minjemin ke procedure
    }
    
    //fuction
    static int nilaiAkhir(int tg, int uts, int uas){
        //NA = (30% * tugas) + (30% * uts) + (40% * uas)
        int NA = (tg * 30/100) + (uts * 30/100) + (uas * 40/100);
        System.out.println("Nilai Akhir :" + NA);
        return NA;
    }
    public static void main(String[] args) {

        //memanggil procedur & function
        inputData();

        
    }
}

//kalau soalnya ga disebutin itu termasuk class-level atau tidak, bisa diliat dari rumusnya (opsi 1)