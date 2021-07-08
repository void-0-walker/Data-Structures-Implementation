class AVLTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { 
            this.val = val; 
        }
    }

    private TreeNode root;

    public void toBST(int[] nums) {
        
        for(int i: nums)
            root = insert(root, i);
    }
    
    private TreeNode insert(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        
        if(val < root.val) {
            root.left = insert(root.left, val);
            root = balance(root);
        }
        else {
            root.right = insert(root.right, val);
            root = balance(root);
        }
        
        return root;
    }
        
    private int height(TreeNode root) {
        if(root == null)
            return 0;
        
        return Math.max(height(root.left), height(root.right))+1;
    }
        
    private TreeNode balance(TreeNode root) {
        int left = height(root.left);
        int right = height(root.right);
        
        if(Math.abs(left-right) > 1) {
            if(left > right) {
                if(height(root.left.left) > height(root.left.right))
                   root = LL(root);
                else
                   root = LR(root);
            } else {
                if(height(root.right.right) > height(root.right.left))
                    root = RR(root);
                else
                    root = RL(root);
            }
        }
        
        return root;
    }
                   
    private TreeNode LL(TreeNode root) {
        TreeNode newRoot = root.left;
        TreeNode save = newRoot.right;
        
        newRoot.right = root;
        root.left = save;
        
        return newRoot;
    }
                   
    private TreeNode LR(TreeNode root) {
        TreeNode root_left = root.left;
        TreeNode root_left_right = root_left.right;
        TreeNode save = root_left_right.left;
        
        root.left = root_left_right;
        root_left.right = save;
        root_left_right.left = root_left;
        
        return LL(root);
    }
                   
    private TreeNode RR(TreeNode root) {
        TreeNode newRoot = root.right;
        TreeNode save = newRoot.left;
        
        newRoot.left = root;
        root.right = save;
        
        return newRoot;
    }
    
    private TreeNode RL(TreeNode root) {
        TreeNode root_right = root.right;
        TreeNode root_right_left = root_right.left;
        TreeNode save = root_right_left.right;
        
        root.right = root_right_left;
        root_right.left = save;
        root_right_left.right = root_right;
        
        return RR(root);
    }

    public void inorder() {
        inorderHelper(root);
    }

    private void inorderHelper(TreeNode root) {
        if(root != null) {
            inorderHelper(root.left);
            System.out.println(root.val);
            inorderHelper(root.right);
        }
    }

    public static void main(String[] args) {
        AVLTree t = new AVLTree();
        int[] nums = {14,17,11,7,53,4,13,12,8,60,19,16,20,23};
        t.toBST(nums);
        t.inorder();
    }
}