import java.util.*; // Mengimpor kelas-kelas yang diperlukan dari paket java.util

//  Mendefinisikan kelas UndirectedGraph yang merepresentasikan graf tidak terarah
class UndirectedGraph {
    // Membuat variabel instance adjacencyList yang merupakan representasi dari daftar ketetanggaan (adjacency list) dalam bentuk Map dengan String sebagai kunci dan List<String> sebagai nilai
    private Map<String, List<String>> adjacencyList;

    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode addNode untuk menambahkan node baru ke graf. Jika node belum ada dalam adjacencyList, sebuah entry baru ditambahkan dengan daftar kosong sebagai nilai
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode addEdge untuk menambahkan edge (sisi) ke graf,
    // Ini memastikan bahwa kedua node yang terhubung memiliki entri dalam adjacencyList dan kemudian menambahkan keterhubungan di kedua arah
    public void addEdge(String source, String destination) {
        // Pastikan kedua node ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan dan sebaliknya
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // Metode getNeighbors untuk mendapatkan daftar tetangga dari suatu node. Jika node tidak ditemukan, akan dikembalikan daftar kosong
    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Metode printGraph untuk mencetak graf ke layar. Ini mengiterasi melalui setiap node dan mencetak daftar tetangga setiap node
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Metode main untuk menjalankan program. Membuat objek graf, menambahkan node dan edge, dan kemudian mencetak graf menggunakan metode printGraph
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");

        graph.printGraph();
    }
}
