/**
 * Ini adalah deklarasi kelas Java dengan nama BubbleSort
 */
public class BubbleSort { 
    /** 
     * @param 
     */
    void bubbleSort(int arr[]) { // Ini adalah deklarasi fungsi bernama bubbleSort. Fungsi ini tidak mengembalikan nilai dan hanya menerima yang bertipe data int
        int n = arr.length; // Panjang dari array

        for (int i = 0; i < n-1; i++) { // Ini adalah perulangan pertama yang digunakan untuk mengulangi proses Bubble Sort
            
            for (int j = 0; j < n-i-1; j++) { //  Ini adalah perulangan kekedua yang digunakan untuk membandingkan dan menukar elemen-elemen yang tidak terurut
                
                if (arr[j] > arr[j+1]) { // Memeriksa kondisi
                    
                   // proses penukaran elemen
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * Metode utama untuk menjalankan program.
     *
     * @param args Argumen baris perintah tidak digunakan.
     */
    public static void main(String args[]) {
        BubbleSort ob = new BubbleSort(); // Membuat kelas baru dengan nama ob
        int arr[] = {64, 34, 25, 12, 22, 11, 90}; // Data yang akan diurutkan

        ob.bubbleSort(arr); // Memanggil metode bubbleSort

        System.out.println("Sorted array"); // Mencetak pesan

        // Untuk mencetak setiap elemen dalam array yang setelah diurutkan.
        for (int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}