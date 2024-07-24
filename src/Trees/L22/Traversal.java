package Trees.L22;

import java.util.*;

// TreeNode class definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

public class Traversal {

    // Inorder Traversal (Recursive)
    public static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);  // Traverse left subtree
        result.add(root.val);        // Visit current node
        inorder(root.right, result); // Traverse right subtree
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);  // Call helper function
        return result;
    }

    // Preorder Traversal (Iterative)
    public static List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);  // Visit current node

            // Push right child first so that left child is processed first
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Inorder Traversal
        List<Integer> inorderResult = inorder(root);
        System.out.print("Inorder Traversal: ");
        for (int val : inorderResult) {
            System.out.print(val + " ");
        }
        System.out.println();

        // Preorder Traversal
        List<Integer> preorderResult = preorder(root);
        System.out.print("Preorder Traversal: ");
        for (int val : preorderResult) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

