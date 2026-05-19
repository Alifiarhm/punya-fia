import java.util.Scanner;

public class NilaiTertinggiArray_25410100010 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

    System.out.print("Masukkan jumlah angka : ");
    int jumlah = sc.nextInt();

    int[] arr = new int[jumlah];

for(int i = 0; i < arr.length; i++){
    System.out.print("Masukkan angka ke-" + (i+1) + " : ");
    arr[i] = sc.nextInt();
}

    System.out.println("Nilai terbesar = " + getNilaiMax(arr));
}
    static int getNilaiMax(int[] arr){

    int max = arr[0];

    for(int i = 1; i < arr.length; i++){
    if(arr[i] > max){
    max = arr[i];
    }
}

    return max;
    }
}