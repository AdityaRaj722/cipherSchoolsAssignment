package Trees.L28;

import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class TreeProblems {

    // Function to find the index in the sorted array where elements become greater than 'x'
    public static int find(int[] preorder, int start, int end, int x) {
        int index = start;
        while (index <= end && preorder[index] < x) {
            index++;
        }
        return index;
    }

    // Function to build a BST from a sorted array
    public static TreeNode buildTree(int[] sortedArr, int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;
        TreeNode newNode = new TreeNode(sortedArr[mid]);
        newNode.left = buildTree(sortedArr, start, mid - 1);
        newNode.right = buildTree(sortedArr, mid + 1, end);
        return newNode;
    }

    // Function to find the least common ancestor (LCA) of two values in a BST
    public static TreeNode leastCommonAncestor(TreeNode root, int l, int r) {
        if (root == null)
            return null;
        if (root.val < l)
            return leastCommonAncestor(root.right, l, r);
        else if (root.val > r)
            return leastCommonAncestor(root.left, l, r);
        else
            return root;
    }

    public static void main(String[] args) {
        // Example usage
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = buildTree(sortedArr, 0, sortedArr.length - 1);

        TreeNode lca = leastCommonAncestor(root, 2, 6);
        System.out.println("LCA of 2 and 6: " + (lca != null ? lca.val : "None"));
    }
}

