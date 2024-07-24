package Trees.L24;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

public class Diameter {
    // Method to calculate diameter and height of the tree
    public static int diameter(TreeNode root, int[] height) {
        if (root == null) {
            height[0] = 0;
            return 0;
        }

        int[] leftHeight = new int[1];
        int[] rightHeight = new int[1];

        int leftDiameter = diameter(root.left, leftHeight);
        int rightDiameter = diameter(root.right, rightHeight);

        height[0] = Math.max(leftHeight[0], rightHeight[0]) + 1;

        return Math.max(leftHeight[0] + rightHeight[0] + 1, Math.max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int[] height = new int[1];
        int treeDiameter = diameter(root, height);

        System.out.println("Diameter of the tree: " + treeDiameter);
        System.out.println("Height of the tree: " + height[0]);
    }
}
