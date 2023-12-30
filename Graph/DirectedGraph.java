import java.util.*; // Package dan Import untuk kelas yang digunakan

// Deklarasi kelas DirectedGraph
class DirectedGraph {
    // Deklarasi atribut adjacencyList yang merupakan representasi dari graf sebagai Map dengan String sebagai kunci (node) dan List<String> sebagai nilai (daftar tetangga)
    private Map<String, List<String>> adjacencyList;

    // Konstruktor kelas DirectedGraph untuk inisialisasi adjacencyList sebagai HashMap
    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode addNode untuk menambahkan node baru ke dalam graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode addEdge untuk menambahkan edge (sisi) ke dalam graf
    // Hanya satu arah untuk graf berarah, jadi hanya dari sumber ke tujuan
    public void addEdge(String source, String destination) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan
        adjacencyList.get(source).add(destination);
    }

    // Metode getNeighbors untuk mendapatkan daftar tetangga dari suatu node
    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Metode printGraph untuk mencetak graf, menampilkan node dan tetangganya
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Metode main sebagai contoh penggunaan kelas DirectedGraph. Membuat objek graf, menambahkan node dan edge, lalu mencetak graf
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

        graph.printGraph();
    }
}
