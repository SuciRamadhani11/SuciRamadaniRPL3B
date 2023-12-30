/**
 * Ini adalah deklarasi kelas Java dengan nama InsertionSort
 */
public class InsertionSort {

    /**
     * @param 
     * @return 
     */
    public static int[] insertion(int[] array) { // Ini adalah deklarasi metode Insertion
        // Mendeklarasikan beberapa variabel, termasuk ukuran yang menyimpan panjang array,
        // max untuk menyimpan nilai maksimum sementara, 
        // j untuk indeks dalam array, dan i sebagai indeks luar untuk iterasi.
        int ukuran = array.length;
        int max, j;
        int i = 1;

        while (i < ukuran) {
            max = array[i];
            j = i;
            // Elemen-elemen yang lebih besar dari max digeser ke kanan
            while (j > 0 && array[j - 1] > max) {
                array[j] = array[j - 1];
                j--;
            }
            // Ditempatkan pada posisi yang sesuai.
            array[j] = max;
            i++;
        }
        return array; // Mengembalikan array yang sudah diurutkan.
    }
 // Menjalankan program
    public static void main(String[] args) {
        // Membuat array array dengan nilai awal dan memanggil Insertion untuk mengurutkannya,hasil pengurutan disimpan di array sortedArray
        int[] array = { 9, 5, 1, 4, 3 };
        int[] sortedArray = insertion(array);
        
        // Mencetak pesan "Sorted array:" ke layar, diikuti oleh elemen-elemen array yang sudah diurutkan.
        System.out.println("Sorted array:");
        for (int value : sortedArray) {
            System.out.print(value + " ");
        }
    }
}