/**
 * Ini adalah deklarasi kelas Java dengan nama SelectionSort
 */
public class SelectionSort {

    /**
     * @param
     * @return 
     */
    public static int[] selectionSort(int[] array) {
        int ukuran = array.length; // Mendapatkan panjang array

        // Memulai loop utama yang berjalan selama ukuran array lebih dari 0
        while (ukuran > 0) {
            int max = 0; // Mendeklarasikan variabel max yang digunakan untuk menyimpan indeks elemen terbesar dalam subarray yang belum diurutkan

            // Melakukan iterasi untuk mencari elemen terbesar dalam subarray yang belum diurutkan
            for (int i = 1; i < ukuran; i++) {
                if (array[max] < array[i]) {
                    max = i; 
                }
            }

            //Menukar elemen terbesar dengan elemen di akhir yang belum diurutkan, sehingga elemen terbesar dipindahkan ke posisi yang benar
            int temp = array[max];
            array[max] = array[ukuran - 1];
            array[ukuran - 1] = temp;

            // Mengurangi ukuran subarray yang belum diurutkan karena elemen terbesar sudah di posisi yang benar
            ukuran--;
        }
        return array; // Mengembalikan array yang sudah diurutkan
    }

    /*
     * Metode utama yang menjalankan program.
     */
    public static void main(String[] args) {
        // Membuat array dengan nilai awal dan memanggil selectionSort untuk mengurutkanny, hasil pengurutan disimpan di sortedArray
        int[] array = {64, 34, 25, 12, 22, 11, 90}; // 
        int[] sortedArray = selectionSort(array); // 

        // Mencetak data yang sudah diurutkan dalam urutan menurun
        System.out.println("Sorted array in descending order:");
        for (int value : sortedArray) {
            System.out.print(value + " ");
        }
    }
}