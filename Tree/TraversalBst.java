import java.util.LinkedList;
import java.util.Queue;

// Kelas Node merepresentasikan simpul atau node dalam BST
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

// Kelas TraversalBst menyediakan implementasi untuk BST
public class TraversalBst {
    Node root;

    // Metode insert digunakan untuk menambahkan node baru ke dalam BST
    // Jika sub-pohon kosong, metode membuat node baru sebagai akar sub-pohon
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

    // Metode inOrder, postOrder, dan levelOrder masing-masing melakukan traversal in-order, post-order, dan level-order pada BST, setiap metode mencetak nilai node sesuai dengan urutan traversal yang diinginkan
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public static void main(String[] args) {
        TraversalBst bst = new TraversalBst();
        
        // Membuat struktur BST
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 35);
        bst.insert(bst.root, 65);
        bst.insert(bst.root, 80);

        System.out.println("In-Order traversal:");
        bst.inOrder(bst.root);
        System.out.println();

        System.out.println("Post-Order traversal:");
        bst.postOrder(bst.root);
        System.out.println();

        System.out.println("Level-Order traversal:");
        bst.levelOrder(bst.root);
        System.out.println();
    }
}
