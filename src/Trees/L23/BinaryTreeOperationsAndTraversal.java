package Trees.L23;

import java.util.*;

// TreeNode class definition
class TreeNode {
    int val;
    TreeNodemy left;
    TreeNodemy right;

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

    TreeNode(int x, TreeNodemy left, TreeNodemy right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeOperationsAndTraversal {

    // Inorder Traversal (Recursive)
    public static void inorder(TreeNodemy root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static List<Integer> inorder(TreeNodemy root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    // Preorder Traversal (Iterative)
    public static List<Integer> preorder(TreeNodemy root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNodemy> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNodemy node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    // Inorder Traversal (Iterative)
    public static List<Integer> inorderIterative(TreeNodemy root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNodemy> stack = new Stack<>();
        TreeNodemy node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }

    // Height of the tree
    public static int height(TreeNodemy root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Print nodes at a given level
    public static void printGivenLevel(TreeNodemy root, int level, List<Integer> levelH) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            levelH.add(root.val);
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1, levelH);
            printGivenLevel(root.right, level - 1, levelH);
        }
    }

    // Level Order Traversal (Recursive)
    public static List<List<Integer>> levelOrder(TreeNodemy root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        int H = height(root);
        for (int h = 1; h <= H; h++) {
            List<Integer> levelH = new ArrayList<>();
            printGivenLevel(root, h, levelH);
            levelOrder.add(levelH);
        }
        return levelOrder;
    }

    // Level Order Traversal (Iterative)
    public static List<Integer> levelOrderIterative(TreeNodemy root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNodemy> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNodemy node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    // Level Order Traversal (Line by Line Iterative)
    public static List<List<Integer>> levelOrderLineByLineIterative(TreeNodemy root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNodemy> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // Marker for end of level
        List<Integer> currLevel = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNodemy node = queue.poll();
            if (node == null) {
                result.add(new ArrayList<>(currLevel));
                currLevel.clear();
                if (!queue.isEmpty()) {
                    queue.add(null); // Add marker for next level
                }
            } else {
                currLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
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

        // Inorder Traversal
        List<Integer> inorderResult = inorder(root);
        System.out.println("Inorder Traversal: " + inorderResult);

        // Preorder Traversal
        List<Integer> preorderResult = preorder(root);
        System.out.println("Preorder Traversal: " + preorderResult);

        // Inorder Traversal (Iterative)
        List<Integer> inorderIterativeResult = inorderIterative(root);
        System.out.println("Inorder Traversal (Iterative): " + inorderIterativeResult);

        // Level Order Traversal (Recursive)
        List<List<Integer>> levelOrderRecursiveResult = levelOrder(root);
        System.out.println("Level Order Traversal (Recursive):");
        for (List<Integer> level : levelOrderRecursiveResult) {
            System.out.println(level);
        }

        // Level Order Traversal (Iterative)
        List<Integer> levelOrderIterativeResult = levelOrderIterative(root);
        System.out.println("Level Order Traversal (Iterative): " + levelOrderIterativeResult);

        // Level Order Traversal (Line by Line Iterative)
        List<List<Integer>> levelOrderLineByLineResult = levelOrderLineByLineIterative(root);
        System.out.println("Level Order Traversal (Line by Line Iterative):");
        for (List<Integer> level : levelOrderLineByLineResult) {
            System.out.println(level);
        }
    }
}

