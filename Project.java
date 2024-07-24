import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int key) {
        this.val = key;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private TreeNode insert(TreeNode node, int key) {
        if (node == null) return new TreeNode(key);
        if (key < node.val) {
            node.left = insert(node.left, key);
        } else if (key > node.val) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    public TreeNode search(int key) {
        return search(root, key);
    }

    private TreeNode search(TreeNode node, int key) {
        if (node == null || node.val == key) return node;
        if (key < node.val) return search(node.left, key);
        return search(node.right, key);
    }

    public void deleteNode(int key) {
        root = deleteNode(root, key);
    }

    private TreeNode deleteNode(TreeNode node, int key) {
        if (node == null) return node;

        if (key < node.val) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.val) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;

            TreeNode minNode = findMin(node.right);
            node.val = minNode.val;
            node.right = deleteNode(node.right, minNode.val);
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void displayInOrder() {
        System.out.print("In-order: ");
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.val + " ");
            inOrderTraversal(node.right);
        }
    }

    public void displayPreOrder() {
        System.out.print("Pre-order: ");
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void displayPostOrder() {
        System.out.print("Post-order: ");
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.val + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        int choice, key;

        do {
            System.out.println("Menu: ");
            System.out.println("1. Insert ");
            System.out.println("2. Search ");
            System.out.println("3. Delete ");
            System.out.println("4. Display In-Order ");
            System.out.println("5. Display Pre-Order ");
            System.out.println("6. Display Post-Order ");
            System.out.println("7. Exit ");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    key = scanner.nextInt();
                    bst.insert(key);
                    System.out.println("Inserted " + key);
                    break;
                case 2:
                    System.out.print("Enter key to search: ");
                    key = scanner.nextInt();
                    System.out.println(bst.search(key) != null ? "Found" : "Not found");
                    break;
                case 3:
                    System.out.print("Enter key to delete: ");
                    key = scanner.nextInt();
                    bst.deleteNode(key);
                    System.out.println("Deleted node with key " + key);
                    break;
                case 4:
                    bst.displayInOrder();
                    break;
                case 5:
                    bst.displayPreOrder();
                    break;
                case 6:
                    bst.displayPostOrder();
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
        
        scanner.close();
    }
}