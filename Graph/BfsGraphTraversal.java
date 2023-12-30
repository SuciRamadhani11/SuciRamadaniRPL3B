import java.util.*; // Package dan import untuk kelas yang digunakan

// Kelas Edges untuk merepresentasikan edge (sisi) dari graph,
// Memiliki atribut destination untuk menyimpan node tujuan dan weight untuk menyimpan bobot
class Edges {
    String destination;
    int weight;

    public Edges(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}
// Kelas BfsGraphTraversal yang berisi implementasi algoritma BFS pada graph

// Deklarasi atribut adjacencyList untuk menyimpan daftar tetangga setiap node
public class BfsGraphTraversal {
    private Map<String, List<Edges>> adjacencyList;

    //  Konstruktor untuk inisialisasi adjacencyList sebagai HashMap
    public BfsGraphTraversal() {
        adjacencyList = new HashMap<>();
    }

    // Metode addNode untuk menambahkan node baru ke dalam graph
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode addEdge untuk menambahkan edge berbobot ke dalam graph
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot
        adjacencyList.get(source).add(new Edges(destination, weight));
    }

    // Metode getNeighbors untuk mendapatkan daftar tetangga dan bobot dari suatu node
    public List<Edges> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // BFS traversal dari node sumber
    // Metode bfsTraversal untuk melakukan BFS traversal dari suatu node
    // Menggunakan Set untuk melacak node yang sudah dikunjungi dan Queue untuk menjalankan BFS
    public void bfsTraversal(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            // Menambahkan semua tetangga yang belum dikunjungi ke antrian
            for (Edges edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(edge.destination)) {
                    queue.add(edge.destination);
                    visited.add(edge.destination);
                    //System.out.print("-> (" + edge.weight + ") " + edge.destination + " ");
                }
            }
        }
        System.out.println();
    }

    // Metode main sebagai contoh penggunaan kelas BfsGraphTraversal
    // Membuat objek graph, menambahkan node dan edge, lalu melakukan BFS traversal dari node "A"
    public static void main(String[] args) {
        BfsGraphTraversal graph = new BfsGraphTraversal();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        graph.bfsTraversal("A");
    }
}