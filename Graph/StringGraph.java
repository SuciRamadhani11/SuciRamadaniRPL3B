import java.util.*; // Mengimpor kelas-kelas yang diperlukan dari paket java.util

//  Mendefinisikan kelas StringGraph yang merepresentasikan graf berisi string
class StringGraph {
    // Membuat variabel instance adjacencyList yang merupakan representasi dari daftar ketetanggaan (adjacency list) dalam bentuk Map dengan String sebagai kunci dan List<String> sebagai nilai
    private Map<String, List<String>> adjacencyList;

    public StringGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode addNode untuk menambahkan node baru ke graf. Jika node belum ada dalam adjacencyList, sebuah entry baru ditambahkan dengan daftar kosong sebagai nilai
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode addEdge untuk menambahkan edge (sisi) ke graf. Ini memanipulasi daftar ketetanggaan dari node source dengan menambahkan destination ke dalamnya
    // Jika graf tidak terarah, baris komentar menunjukkan bahwa Anda dapat menambahkan kedua arah (source ke destination dan destination ke source)
    public void addEdge(String source, String destination) {
        adjacencyList.get(source).add(destination);
        // Jika graf tidak terarah, tambahkan baris berikut:
        // adjacencyList.get(destination).add(source);
    }

    // Metode printGraph untuk mencetak graf ke layar,
    // Ini mengiterasi melalui setiap node dan mencetak daftar tetangga setiap node
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
        StringGraph graph = new StringGraph();
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
