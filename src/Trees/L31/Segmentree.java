package Trees.L31;

class SegmentTree {
    private int[] arr;
    private int[] tree;
    private int arrSize;

    // Constructor
    public SegmentTree(int[] arr) {
        this.arr = arr;
        this.arrSize = arr.length;
        this.tree = new int[4 * arrSize];
        buildTree(0, 0, arrSize - 1);
    }

    // Build the segment tree
    private void buildTree(int nodeIndex, int start, int end) {
        if (start == end) {
            tree[nodeIndex] = arr[start];
        } else {
            int mid = start + (end - start) / 2;
            int leftIndex = getLeftChild(nodeIndex);
            int rightIndex = getRightChild(nodeIndex);
            buildTree(leftIndex, start, mid);
            buildTree(rightIndex, mid + 1, end);
            tree[nodeIndex] = tree[leftIndex] + tree[rightIndex];
        }
    }

    // Update a value in the segment tree
    public void update(int indexToUpdate, int delta) {
        updateTree(0, 0, arrSize - 1, indexToUpdate, delta);
    }

    private void updateTree(int nodeIndex, int start, int end, int indexToUpdate, int delta) {
        if (indexToUpdate < start || indexToUpdate > end) {
            return;
        }
        tree[nodeIndex] += delta;
        if (start < end) {
            int mid = start + (end - start) / 2;
            int leftIndex = getLeftChild(nodeIndex);
            int rightIndex = getRightChild(nodeIndex);
            if (indexToUpdate <= mid) {
                updateTree(leftIndex, start, mid, indexToUpdate, delta);
            } else {
                updateTree(rightIndex, mid + 1, end, indexToUpdate, delta);
            }
        }
    }

    // Query the sum in a given range
    public int getSum(int qStart, int qEnd) {
        return getSum(0, 0, arrSize - 1, qStart, qEnd);
    }

    private int getSum(int nodeIndex, int start, int end, int qStart, int qEnd) {
        if (qStart > end || qEnd < start) {
            return 0;
        } else if (qStart <= start && end <= qEnd) {
            return tree[nodeIndex];
        } else {
            int mid = start + (end - start) / 2;
            int leftIndex = getLeftChild(nodeIndex);
            int rightIndex = getRightChild(nodeIndex);
            return getSum(leftIndex, start, mid, qStart, qEnd) +
                    getSum(rightIndex, mid + 1, end, qStart, qEnd);
        }
    }

    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private int getRightChild(int index) {
        return 2 * index + 2;
    }

    // Print the segment tree for debugging
    public void printSegmentTree() {
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }
}

// Example usage
public class Segmentree {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);
        st.printSegmentTree();

        // Query sum from index 1 to 3
        System.out.println("Sum of range (1, 3): " + st.getSum(1, 3));

        // Update value at index 2 by adding 10
        st.update(2, 10);
        st.printSegmentTree();

        // Query sum again after the update
        System.out.println("Sum of range (1, 3) after update: " + st.getSum(1, 3));
    }
}

