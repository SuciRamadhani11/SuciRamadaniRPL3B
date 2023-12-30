import java.util.*; // Mengimpor kelas-kelas yang diperlukan dari paket java.util

// Mendefinisikan kelas SimpleGraph yang merepresentasikan graf sederhana
class SimpleGraph {
    // Membuat variabel instance adjacencyList yang merupakan representasi dari daftar ketetanggaan (adjacency list) dalam bentuk Map dengan Integer sebagai kunci dan List<Integer> sebagai nilai
    private Map<Integer, List<Integer>> adjacencyList;

    public SimpleGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode addNode untuk menambahkan node baru ke graf. Jika node belum ada dalam adjacencyList, sebuah entry baru ditambahkan dengan daftar kosong sebagai nilai
    public void addNode(Integer node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode addEdge untuk menambahkan edge (sisi) ke graf. Ini memanipulasi daftar ketetanggaan dari node source dengan menambahkan destination ke dalamnya
    // Jika graf tidak terarah, baris komentar menunjukkan bahwa Anda dapat menambahkan kedua arah (source ke destination dan destination ke source)
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        // Jika graf tidak terarah, tambahkan baris berikut:
        // adjacencyList.get(destination).add(source);
    }

    // Metode getNeighbors untuk mendapatkan daftar tetangga dari suatu node
    // Menggunakan getOrDefault untuk menghindari NullPointerException jika node tidak ditemukan
    public List<Integer> getNeighbors(int node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Mencetak graf
    // Metode printGraph untuk mencetak graf ke layar. Ini mengiterasi melalui setiap node dan mencetak daftar tetangga setiap node
    public void printGraph() {
        for (int node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (int neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Metode main untuk menjalankan program. Membuat objek graf, menambahkan node dan edge, dan kemudian mencetak graf menggunakan metode printGraph
    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        graph.printGraph();
    }
}
