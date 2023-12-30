import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Kelas Node merepresentasikan simpul atau node dalam pohon biner yang menyimpan string
 * Setiap node memiliki nilai (string), serta dua referensi ke simpul anak (left dan right)
 */
class Node {
    String value;
    Node left;
    Node right;

    /**
     * Konstruktor untuk kelas Node.
     * @param value Nilai dari node.
     */
    public Node(String value) {
        this.value = value;
        left = null;
        right = null;
    }
}

// Kelas StringBst menyediakan implementasi untuk pohon biner yang menyimpan string, properti root adalah referensi ke simpul akar dari pohon
class StringBst {
    Node root;

    public StringBst() {
        root = null;
    }

    // Metode insert digunakan untuk menyisipkan node baru dengan nilai tertentu ke dalam pohon biner,nilai string dibandingkan untuk menentukan apakah node harus ditempatkan di sebelah kiri atau kanan dari simpul saat ini
    public Node insert(Node root, String value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value.compareTo(root.value) < 0) {
            root.left = insert(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = insert(root.right, value);
        }

        return root;
    }

   // 
    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    /**
     * Melakukan traversal in-order pada pohon biner.
     * @param root Node root saat ini.
     */
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    /**
     * Melakukan traversal post-order pada pohon biner.
     * @param root Node root saat ini.
     */
    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + " ");
        }
    }

    /**
     * Melakukan traversal level-order pada pohon biner.
     * @param root Node root saat ini.
     */
    public void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        
    }

    /**
     * Mencetak pohon biner dalam bentuk struktur tree folder.
     * @param node Node awal (biasanya root).
     * @param prefix Prefix untuk baris saat ini.
     * @param isTail Apakah node ini adalah anak terakhir dari parentnya.
     */
    public void printTree(Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.value);
            List<Node> children = new ArrayList<>();
            if (node.left != null) children.add(node.left);
            if (node.right != null) children.add(node.right);
            for (int i = 0; i < children.size() - 1; i++) {
                printTree(children.get(i), prefix + (isTail ? "    " : "│   "), false);
            }
            if (children.size() > 0) {
                printTree(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    /**
     * Metode main untuk mengeksekusi kode.
     * @param args Argumen dari baris perintah.
     */
    public static void main(String[] args) {
        StringBst tree = new StringBst();
        tree.root = tree.insert(tree.root, "Mango");
        tree.insert(tree.root, "Apple");
        tree.insert(tree.root, "Orange");
        tree.insert(tree.root, "Banana");
        tree.insert(tree.root, "Grapes");
        tree.insert(tree.root, "Pineapple");
        tree.insert(tree.root, "Peach");

        System.out.println("Struktur pohon biner:");
        tree.printTree(tree.root, "", true);

        System.out.println("Traversal pre-order:");
        tree.preorder(tree.root);

        System.out.println("\nTraversal in-order:");
        tree.inorder(tree.root);

        System.out.println("\nTraversal post-order:");
        tree.postorder(tree.root);

        System.out.println("\nTraversal level-order:");
        tree.levelOrder(tree.root);
    }
}
