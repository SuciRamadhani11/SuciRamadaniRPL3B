// Kelas Node merepresentasikan simpul atau node dalam pohon biner
// Setiap node memiliki data (nilai), serta dua referensi ke simpul anak (left dan right)
// Konstruktor Node digunakan untuk membuat node baru dengan data tertentu
class Node {
    int data;  
    Node left, right;  

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}


  // Kelas BinaryTree digunakan untuk merepresentasikan sebuah pohon biner
public class BinaryTree {

    Node root;  // Akar dari pohon biner

    // Metode main membuat objek BinaryTree dan membangun pohon biner dengan menambahkan beberapa node
    // Setiap node memiliki nilai yang disesuaikan
    // Setelahnya, metode memanggil printTree untuk mencetak struktur pohon biner
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();  // Membuat objek pohon biner

        // Membuat atau menambah data
        tree.root = new Node(1);
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.right.left = new Node(9);
        tree.root.right.left.left = new Node(10);

        // Print tree untuk verifikasi
        printTree(tree.root, "", true);
    }

    /**
     * Metode untuk mencetak struktur pohon biner.
     *
     * @param node Node yang akan dicetak
     * @param indent Indentasi yang digunakan untuk mencetak
     * @param last Menandakan apakah node adalah node terakhir dalam tingkatannya
     */
    public static void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.println(indent + "+-- " + node.data);  // Mencetak data node
            indent += last ? "    " : "|   ";  // Menyesuaikan indentasi
            printTree(node.right, indent, false);  // Mencetak anak kanan
            printTree(node.left, indent, true);  // Mencetak anak kiri
        }
    }
}