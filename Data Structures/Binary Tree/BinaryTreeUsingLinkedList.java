import java.util.*;

class BinaryTreeUsingLinkedList {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    Node root;
    private static Scanner s = new Scanner(System.in);

    public Node create() {
        System.out.println("Enter data(-1 for no node): ");
        int data = s.nextInt();
        if(data == -1) 
            return null;
        Node node = new Node(data);
        System.out.print("For left node: ");
        node.left = create();
        System.out.print("For right node: ");
        node.right = create();
        return node;
    }

    public void preOrder(Node root) {
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static void main(String[] args) {
        BinaryTreeUsingLinkedList b = new BinaryTreeUsingLinkedList();
        b.root = b.create();
        b.preOrder(b.root);
        System.out.println();
        b.inOrder(b.root);
        System.out.println();
        b.postOrder(b.root);
    }
}