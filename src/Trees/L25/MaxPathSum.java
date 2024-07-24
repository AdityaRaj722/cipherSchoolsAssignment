package Trees.L25;

public class MaxPathSum {

    // Helper method to check if a node is a leaf
    public static boolean isLeaf(TreeNode node) {
        return (node != null && node.left == null && node.right == null);
    }

    // Method to find the maximum root-to-leaf sum
    public static void maxSumPath(TreeNode root, int sum, int[] maxSum) {
        if (root == null) return;

        sum += root.val;

        if (isLeaf(root)) {
            maxSum[0] = Math.max(maxSum[0], sum);
        } else {
            maxSumPath(root.left, sum, maxSum);
            maxSumPath(root.right, sum, maxSum);
        }
    }

    public static int maxPath(TreeNode root) {
        int[] maxSum = new int[1];  // Use an array to hold the maximum sum since Java passes by value
        maxSumPath(root, 0, maxSum);
        return maxSum[0];
    }

    // Method to find the maximum leaf-to-leaf sum
    public static int leafToLeafMaxSum(TreeNode root, int[] sum) {
        if (root == null) {
            sum[0] = 0;
            return 0;
        }

        if (isLeaf(root)) {
            sum[0] = 0;
            return root.val;
        }

        int[] lSum = new int[1];
        int[] rSum = new int[1];
        int lMaxSum = leafToLeafMaxSum(root.left, lSum);
        int rMaxSum = leafToLeafMaxSum(root.right, rSum);

        if (root.left != null && root.right != null) {
            sum[0] = Math.max(sum[0], lSum[0] + rSum[0] + root.val);
            return Math.max(lSum[0], rSum[0]) + root.val;
        } else if (root.left != null) {
            return root.val + lSum[0];
        } else {
            return root.val + rSum[0];
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int[] height = new int[1];
        int maxRootToLeafSum = maxPath(root);
        System.out.println("Max Root to Leaf Path Sum: " + maxRootToLeafSum);

        int[] maxLeafToLeafSum = new int[1];
        int maxLeafToLeaf = leafToLeafMaxSum(root, maxLeafToLeafSum);
        System.out.println("Max Leaf to Leaf Path Sum: " + maxLeafToLeaf);
    }
}


