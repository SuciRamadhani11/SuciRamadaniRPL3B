import java.util.LinkedList; // Mengimport kelas LinkedList dari paket java.util

/**
 * Kelas StringHash
 */
public class StringHash {
    
    
     // Deklarasi atribut kelas table sebagai array dari LinkedList untuk menyimpan data
    private LinkedList<String>[] table;

    
     // Konstruktor StringHash
     // Menginisialisasi array dan LinkedList di setiap indeks array
     // Konstruktor StringHash yang menerima parameter size
     // Menginisialisasi array table dan membuat objek LinkedList di setiap indeks array
    
    public StringHash(int size) {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    
     // Fungsi hash untuk menghitung indeks dari string
     // Metode hashFunction untuk menghitung indeks dari string
     // Menggunakan karakter pertama dari string dan operasi modulo untuk menentukan indeks
   
    public int hashFunction(String key) {
        return key.charAt(0) % table.length;
    }

    
     // Metode untuk menyisipkan string ke dalam hash table
     // Metode insert untuk menyisipkan string ke dalam hash table
     // Menggunakan hashFunction untuk menghitung indeks, lalu menambahkan string ke LinkedList di indeks tersebut
    public void insert(String value) {
        int index = hashFunction(value); // Hitung indeks
        table[index].add(value); // Tambahkan ke LinkedList di indeks tersebut
        System.out.println("Data "+value+" ditambahkan di index: "+index);
    }

    
     // Metode search untuk mencari string dalam hash table
     // Menggunakan hashFunction untuk menghitung indeks dan mengembalikan indeks tersebut
   
    public int search(String value) {
        int index = hashFunction(value); // Hitung indeks
        return index; // Cek apakah nilai ada di LinkedList di indeks tersebut
    }

    // Metode main sebagai contoh penggunaan kelas StringHash
    // Membuat objek StringHash dengan ukuran array 26 (mewakili A-Z), menyisipkan beberapa string, dan mencari string "Kelinci"
    public static void main(String[] args) {
        // String Hash with Separate Chaining
        StringHash stringHash = new StringHash(26); // Membuat objek dengan ukuran 26 (A-Z)
        stringHash.insert("Kucing"); // Menyisipkan string "Kucing"
        stringHash.insert("Ayam"); // Menyisipkan string "Ayam"
        stringHash.insert("Kelinci");// Menyisipkan string "Kelinci"
        System.out.println("String Kelinci ditemukan di index: " + stringHash.search("Kelinci")); // Mencari string "Kelinci"
    }
}
