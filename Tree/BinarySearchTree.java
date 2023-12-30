/**
Kelas Node merepresentasikan simpul atau node dalam BST,setiap node memiliki data (nilai), serta dua referensi ke simpul anak (left dan right)
 */
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}


 //Kelas BinarySearchTree 
public class BinarySearchTree {

    Node root;  // Node akar dari BST

    // Metode insert
    // Metode insert digunakan untuk menambahkan node baru ke dalam BST,Jika sub-pohon kosong,
    // Metode membuat node baru sebagai akar sub-pohon
    // Jika tidak, metode secara rekursif menambahkan node ke sub-pohon kiri atau kanan berdasarkan perbandingan nilai data
    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // Metode printTree
    // Metode printTree mencetak struktur pohon dalam bentuk hirarki
    // Setiap simpul dicetak dengan format "indent + data". Metode ini dipanggil rekursif untuk mencetak subtree kanan dan kiri
    public void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.println(indent + "+-- " + node.data);
            indent += last ? "    " : "|   ";
            printTree(node.right, indent, false);
            printTree(node.left, indent, true);
        }
    }
    
    // Metode main
    // Metode main membuat objek BinarySearchTree (bst) dan membangun struktur BST dengan menambahkan beberapa node. Kemudian, struktur pohon dicetak menggunakan metode printTree
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();  

        // Membangun struktur BST sesuai contoh
        //        50
        //      /    \
        //     30     70
        //    /  \   /  \
        //   10  35 65   80
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 35);
        bst.insert(bst.root, 65);
        bst.insert(bst.root, 80);

        // Mencetak struktur pohon dalam bentuk folder
        bst.printTree(bst.root, "", true);

    }
}