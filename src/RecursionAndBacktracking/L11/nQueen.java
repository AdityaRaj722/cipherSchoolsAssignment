package RecursionAndBacktracking.L11;

import java.util.*;

class Solution {
    // Check if placing a queen at (row, col) is valid
    public boolean valid(int row, int col, String[] arr) {
        int n = arr.length;

        // Check the row
        for (int i = 0; i < n; i++) {
            if (arr[row].charAt(i) != '.') {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < n; i++) {
            if (arr[i].charAt(col) != '.') {
                return false;
            }
        }

        // Check the diagonal (top-left to bottom-right)
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (arr[i].charAt(j) != '.') {
                return false;
            }
            i--;
            j--;
        }

        // Check the diagonal (top-right to bottom-left)
        i = row;
        j = col;
        while (i >= 0 && j < n) {
            if (arr[i].charAt(j) != '.') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    // Recursive DFS to place queens
    public void dfs(int index, int count, int n, String[] arr, List<List<String>> ans) {
        if (count == n) {
            ans.add(new ArrayList<>(Arrays.asList(arr)));
            return;
        }
        if (index >= n) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (valid(index, i, arr)) {
                char[] row = arr[index].toCharArray();
                row[i] = 'Q';
                arr[index] = new String(row);
                dfs(index + 1, count + 1, n, arr, ans);
                row[i] = '.';
                arr[index] = new String(row);
            }
        }
    }

    // Solve N-Queens problem
    public List<List<String>> solveNQueens(int n) {
        String[] arr = new String[n];
        StringBuilder curr = new StringBuilder();
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            curr.append('.');
        }
        for (int i = 0; i < n; i++) {
            arr[i] = curr.toString();
        }

        dfs(0, 0, n, arr, ans);

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4; // Example size
        List<List<String>> results = solution.solveNQueens(n);
        for (List<String> result : results) {
            for (String row : result) {
                System.out.println(row);
            }
            System.out.println(); // Print an empty line between solutions
        }
    }
}
