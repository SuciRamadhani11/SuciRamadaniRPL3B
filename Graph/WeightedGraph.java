import java.util.*; // Mengimpor kelas-kelas yang diperlukan dari paket java.util

//  Mendefinisikan kelas Edge yang merepresentasikan sisi berbobot dalam graf. Memiliki atribut destination untuk node tujuan dan weight untuk bobotnya
class Edge {
    String destination;
    int weight;

    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

//Mendefinisikan kelas WeightedGraph yang merepresentasikan graf berbobot
class WeightedGraph {
    // Membuat variabel instance adjacencyList yang merupakan representasi dari daftar ketetanggaan (adjacency list) dalam bentuk Map dengan String sebagai kunci dan List<Edge> sebagai nilai
    private Map<String, List<Edge>> adjacencyList;

    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode addNode untuk menambahkan node baru ke graf,
    // Jika node belum ada dalam adjacencyList, sebuah entry baru ditambahkan dengan daftar kosong sebagai nilai
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode addEdge untuk menambahkan edge (sisi) berbobot ke graf,
    // Ini memastikan bahwa node sumber memiliki entri dalam adjacencyList dan kemudian menambahkan edge berbobot ke daftar ketetanggaan
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    //  Metode printGraph untuk mencetak graf ke layar
    // Ini mengiterasi melalui setiap node dan mencetak daftar tetangga setiap node beserta bobotnya
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (Edge edge : adjacencyList.get(node)) {
                System.out.print(edge.destination + "(" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // Metode main untuk menjalankan program. Membuat objek graf, menambahkan node dan edge berbobot, dan kemudian mencetak graf menggunakan metode printGraph
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        graph.printGraph();
    }
}