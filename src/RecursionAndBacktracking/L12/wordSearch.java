package RecursionAndBacktracking.L12;

public class wordSearch {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (find(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean find(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '-'; // Mark the cell as visited

        boolean found = find(board, word, i + 1, j, index + 1) ||
                find(board, word, i, j + 1, index + 1) ||
                find(board, word, i - 1, j, index + 1) ||
                find(board, word, i, j - 1, index + 1);

        board[i][j] = temp; // Unmark the cell

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean result =exist(board, word);
        System.out.println("Word exists: " + result);
    }
}
