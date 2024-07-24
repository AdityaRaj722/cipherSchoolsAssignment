package Trees.L24;

import java.util.*;

// TreeNode class definition
class TreeNodedis {
    int data;
    TreeNodedis left;
    TreeNodedis right;

    TreeNodedis(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeOperations {

    // Height of the tree
    public static int height(TreeNodedis root) {
        if (root == null) {
            return 0;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        return Math.max(lheight, rheight) + 1;
    }

    // Diameter of the tree (Naive approach)
    public static int diameter(TreeNodedis root) {
        if (root == null) {
            return 0;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        int curdia = lheight + rheight + 1;

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
        return Math.max(curdia, Math.max(ldiameter, rdiameter));
    }

    // Diameter of the tree (Optimal approach)
    public static int diameterOptimal(TreeNodedis root, int[] height) {
        if (root == null) {
            height[0] = 0;
            return 0;
        }

        int[] lh = new int[1];
        int[] rh = new int[1];
        int ldiameter = diameterOptimal(root.left, lh);
        int rdiameter = diameterOptimal(root.right, rh);

        int curdia = lh[0] + rh[0] + 1;
        height[0] = Math.max(lh[0], rh[0]) + 1;
        return Math.max(curdia, Math.max(ldiameter, rdiameter));
    }

    // Vertical Order Traversal
    public static void verticalOrderTraversal(TreeNodedis root, int hd, Map<Integer, List<Integer>> mp) {
        if (root == null) {
            return;
        }
        mp.computeIfAbsent(hd, k -> new ArrayList<>()).add(root.data);
        verticalOrderTraversal(root.left, hd - 1, mp);
        verticalOrderTraversal(root.right, hd + 1, mp);
    }

    public static List<List<Integer>> verticalTraversal(TreeNodedis root) {
        Map<Integer, List<Integer>> mp = new TreeMap<>();
        verticalOrderTraversal(root, 0, mp);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> topview = new ArrayList<>();
        List<Integer> bottomview = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
            List<Integer> temp = entry.getValue();
            topview.add(temp.get(0));
            bottomview.add(temp.get(temp.size() - 1));
            Collections.sort(temp);
            res.add(temp);
        }

        System.out.println("Top view: " + topview);
        System.out.println("Bottom view: " + bottomview);
        return res;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNodedis root = new TreeNodedis(1);
        root.left = new TreeNodedis(2);
        root.right = new TreeNodedis(3);
        root.left.left = new TreeNodedis(4);
        root.left.right = new TreeNodedis(5);
        root.right.left = new TreeNodedis(6);
        root.right.right = new TreeNodedis(7);
        root.right.right.right = new TreeNodedis(10);

        // Height of the tree
        int height = height(root);
        System.out.println("Height of tree: " + height);

        // Diameter of the tree (Naive approach)
        int diameter1 = diameter(root);
        System.out.println("Diameter of tree (Naive): " + diameter1);

        // Diameter of the tree (Optimal approach)
        int[] heightArr = new int[1];
        int diameter2 = diameterOptimal(root, heightArr);
        System.out.println("Diameter of tree (Optimal): " + diameter2);

        // Vertical Order Traversal
        List<List<Integer>> verticalOrderResult = verticalTraversal(root);
        System.out.println("Vertical Order Traversal:");
        for (List<Integer> level : verticalOrderResult) {
            System.out.println(level);
        }
    }
}
