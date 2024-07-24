package Trees.L23;

import java.util.*;

// TreeNode class definition
class TreeNodemy {
    int val;
    TreeNodemy left;
    TreeNodemy right;

    TreeNodemy() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    TreeNodemy(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    TreeNodemy(int x, TreeNodemy left, TreeNodemy right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeOperations {

    // Question 1: Calculate the height of the binary tree
    public static int heightOfTree(TreeNodemy root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    // Question 2: Level Order Traversal (Iterative)
    public static List<List<Integer>> levelOrderIterative(TreeNodemy root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNodemy> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNodemy node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                temp.add(node.val);
            }
            res.add(temp);
        }
        return res;
    }

    // Question 2: Level Order Traversal (Recursive)
    public static void levelOrderRecursive(TreeNodemy root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        levelOrderRecursive(root.left, level + 1, res);
        levelOrderRecursive(root.right, level + 1, res);
    }

    public static List<List<Integer>> levelOrderRecursive(TreeNodemy root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderRecursive(root, 0, res);
        return res;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNodemy root = new TreeNodemy(1);
        root.left = new TreeNodemy(2);
        root.right = new TreeNodemy(3);
        root.left.left = new TreeNodemy(4);
        root.left.right = new TreeNodemy(5);
        root.right.left = new TreeNodemy(6);
        root.right.right = new TreeNodemy(7);

        // Height of Tree
        int height = heightOfTree(root);
        System.out.println("Height of the tree: " + height);

        // Level Order Traversal (Iterative)
        List<List<Integer>> levelOrderIterativeResult = levelOrderIterative(root);
        System.out.println("Level Order Traversal (Iterative):");
        for (List<Integer> level : levelOrderIterativeResult) {
            System.out.println(level);
        }

        // Level Order Traversal (Recursive)
        List<List<Integer>> levelOrderRecursiveResult = levelOrderRecursive(root);
        System.out.println("Level Order Traversal (Recursive):");
        for (List<Integer> level : levelOrderRecursiveResult) {
            System.out.println(level);
        }
    }
}

