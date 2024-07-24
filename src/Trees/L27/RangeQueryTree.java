package Trees.L27;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        val = 0;
        left = null;
        right = null;
    }

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}

public class RangeQueryTree {

    // Method to find all values in the tree within the given range
    public static void range(TreeNode root, int low, int high, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.val < low) {
            range(root.right, low, high, result);
        } else if (root.val > high) {
            range(root.left, low, high, result);
        } else {
            result.add(root.val);
            range(root.left, low, high, result);
            range(root.right, low, high, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        List<Integer> result = new ArrayList<>();
        range(root, 5, 15, result);

        System.out.println("Values in range [5, 15]: " + result);
    }
}

