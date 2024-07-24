package Trees.L26;

import java.util.*;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode random;

    TreeNode() {
        val = 0;
        left = null;
        right = null;
        random = null;
    }

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
        random = null;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
        this.random = null;
    }
}

public class BinaryTreeProblems {

    // Q3: Building Binary Tree from Inorder and Preorder Traversals
    public static int findIndex(int[] inOrder, int start, int end, int x) {
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static TreeNode buildTree(int[] preOrder, int[] inOrder, int start, int end, int[] currIndex) {
        if (start > end) return null;

        TreeNode newNode = new TreeNode(preOrder[currIndex[0]]);
        currIndex[0]++;

        if (start == end) return newNode;

        int inOrderIndex = findIndex(inOrder, start, end, newNode.val);
        newNode.left = buildTree(preOrder, inOrder, start, inOrderIndex - 1, currIndex);
        newNode.right = buildTree(preOrder, inOrder, inOrderIndex + 1, end, currIndex);

        return newNode;
    }

    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        int[] currIndex = {0};
        return buildTree(preOrder, inOrder, 0, inOrder.length - 1, currIndex);
    }

    // Q4: Finding Root to Leaf Paths
    public static boolean isLeaf(TreeNode node) {
        return (node != null && node.left == null && node.right == null);
    }

    public static void rootToLeafPath(TreeNode root, List<List<Integer>> paths, List<Integer> pathSoFar) {
        if (root == null) return;

        pathSoFar.add(root.val);
        if (isLeaf(root)) {
            paths.add(new ArrayList<>(pathSoFar));
        } else {
            rootToLeafPath(root.left, paths, pathSoFar);
            rootToLeafPath(root.right, paths, pathSoFar);
        }
        pathSoFar.remove(pathSoFar.size() - 1);
    }

    public static List<List<Integer>> rootToLeaf(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> pathSoFar = new ArrayList<>();
        rootToLeafPath(root, paths, pathSoFar);
        return paths;
    }

    // Q5: Populating Random Pointers (Next Pointers)
    public static void populateRandomPointer(TreeNode root) {
        if (root == null || isLeaf(root)) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode prev = null;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (prev != null) {
                    prev.random = curr;
                }
                prev = curr;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        // Q3 Example Usage:
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
        TreeNode root = buildTree(preOrder, inOrder);

        // Q4 Example Usage:
        List<List<Integer>> paths = rootToLeaf(root);
        System.out.println("Root to Leaf Paths:");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

        // Q5 Example Usage:
        populateRandomPointer(root);
        System.out.println("Random pointers populated.");
    }
}
