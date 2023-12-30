import java.util.LinkedList;
import java.util.Queue;

// Kelas Node merepresentasikan simpul atau node dalam Binary Tree
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

/**
 * Kelas BinaryTree untuk operasi-operasi pada Binary Tree.
 */
public class TraversalBt {

    Node root;

    // Metode inOrder, postOrder, dan levelOrder masing-masing melakukan traversal in-order, post-order, dan level-order pada Binary Tree, setiap metode mencetak nilai node sesuai dengan urutan traversal yang diinginkan
    public static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void levelOrder(Node root) {
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
        TraversalBt tree = new TraversalBt();

        // Membuat nodes
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

        // Menampilkan traversal in-order
        System.out.println("In-Order traversal:");
        inOrder(tree.root);
        System.out.println();

        // Menampilkan traversal post-order
        System.out.println("Post-Order traversal:");
        postOrder(tree.root);
        System.out.println();

        // Menampilkan traversal level-order
        System.out.println("Level-Order traversal:");
        levelOrder(tree.root);
        System.out.println();
    }
}