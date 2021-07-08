import java.util.*;

class BSTUsingLinkedList {

    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public void insert(int data) {
        root = insertRecursion(root, data);
    }

    private static Node insertRecursion(Node root, int data) {
        if(root == null)
            return new Node(data);
        if(root.data == data) {
            System.out.println("Duplicates not allowed!");
            return root;
        }
        if(root.data > data) 
            root.left = insertRecursion(root.left, data);
        else
            root.right = insertRecursion(root.right, data);
        return root;
    }

    public void inOrder() {
        inOrderRecursion(this.root);
    }

    private static void inOrderRecursion(Node root) {
        if(root == null)
            return;
        inOrderRecursion(root.left);
        System.out.print(root.data+" ");
        inOrderRecursion(root.right);
    }

    public void preOrder() {
        preOrderRecursion(this.root);
    }

    private static void preOrderRecursion(Node root) {
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }

    public void postOrder() {
        postOrderRecursion(this.root);
    }

    private static void postOrderRecursion(Node root) {
        if(root == null)
            return;
        postOrderRecursion(root.left);
        postOrderRecursion(root.right);
        System.out.print(root.data+" ");
    }

    public void invert() {
        invertRecursion(this.root);
    }

    private static Node invertRecursion(Node root) {
        if(root == null)
            return null;
        Node left = root.left;
        Node right = root.right;     
        root.left = invertRecursion(right);
        root.right = invertRecursion(left);
        return root;
    }

    public void levelOrder() {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(this.root);
        while(!queue.isEmpty()) {
            Node node = queue.removeFirst();
            System.out.print(node.data+" ");
            if(node.left != null) queue.addLast(node.left);
            if(node.right != null) queue.addLast(node.right);
        }  
    }

    public boolean search(int key) {
        if(searchRecursion(this.root, key) == null)
            return false;
        return true;
    }

    private static Node searchRecursion(Node root, int key) {
        if(root == null)
            return null;
        if(root.data == key)
            return root;
        else if(root.data > key)
            return searchRecursion(root.left, key);
        else
            return searchRecursion(root.right, key);
    }

    public void delete(int data) {
        this.root = deleteRecursion(this.root, data);
    }

    public static Node deleteRecursion(Node root, int data) {
        if(root == null)
            return root;
        if(root.data > data)
            root.left = deleteRecursion(root.left, data);
        else if(root.data < data) 
            root.right = deleteRecursion(root.right, data);
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            
            Node succParent = root;
            Node succ = root.right;
            while(succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            if(succParent != root)
                succParent.left = succ.right;
            else
                root.right = succ.right;
            root.data = succ.data;
        }
        return root;
    }

    public int min() {
        if(this.root == null)
            return -1;
        if(this.root.left == null)
            return this.root.data;
        Node min = this.root.left;
        while(min.left != null)
            min = min.left;
        return min.data;
    }

    public int max() {
        if(this.root == null)
            return -1;
        if(this.root.right == null)
            return this.root.data;
        Node max = this.root.right;
        while(max.right != null)
            max = max.right;
        return max.data;
    }
    public int height() {
        return heightRecursion(this.root, 0);
    }

    public int heightRecursion(Node root, int depth) {
        if(root == null)
            return -1;
        return Math.max(heightRecursion(root.left, depth+1), heightRecursion(root.right, depth+1))+1;
    }
    
    public static void main(String[] args) { 
        BSTUsingLinkedList b = new BSTUsingLinkedList();
        b.insert(40);
        b.insert(30);
        b.insert(35);
        b.insert(20);
        b.insert(50);
        b.insert(45);
        b.insert(60);
        b.insert(55);
        b.insert(80);
        b.insert(90);
        b.insert(85);
        System.out.println(b.height());
    }
}
