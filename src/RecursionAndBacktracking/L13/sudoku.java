package RecursionAndBacktracking.L13;

public class sudoku{

    private static final int SIZE = 9;

    // Checks if there is an empty cell
    private static boolean isEmpty(int[][] sudoku, int[] row, int[] col) {
        for (row[0] = 0; row[0] < SIZE; row[0]++) {
            for (col[0] = 0; col[0] < SIZE; col[0]++) {
                if (sudoku[row[0]][col[0]] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // Checks if a number is used in the specified row
    private static boolean usedInRow(int[][] sudoku, int row, int fill) {
        for (int j = 0; j < SIZE; j++) {
            if (sudoku[row][j] == fill) {
                return true;
            }
        }
        return false;
    }

    // Checks if a number is used in the specified column
    private static boolean usedInCol(int[][] sudoku, int col, int fill) {
        for (int i = 0; i < SIZE; i++) {
            if (sudoku[i][col] == fill) {
                return true;
            }
        }
        return false;
    }

    // Checks if a number is used in the 3x3 box
    private static boolean usedInBox(int[][] sudoku, int row, int col, int fill) {
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[i + startRow][j + startCol] == fill) {
                    return true;
                }
            }
        }
        return false;
    }

    // Checks if a number can be placed at sudoku[row][col]
    private static boolean isSafe(int[][] sudoku, int row, int col, int fill) {
        return !usedInRow(sudoku, row, fill) &&
                !usedInCol(sudoku, col, fill) &&
                !usedInBox(sudoku, row, col, fill);
    }

    // Solves the Sudoku puzzle using backtracking
    public static boolean solveSudoku(int[][] sudoku) {
        int[] row = new int[1];
        int[] col = new int[1];
        if (!isEmpty(sudoku, row, col)) {
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (isSafe(sudoku, row[0], col[0], num)) {
                sudoku[row[0]][col[0]] = num;
                if (solveSudoku(sudoku)) {
                    return true;
                }
                // Backtracking
                sudoku[row[0]][col[0]] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(sudoku)) {
            System.out.println("Sudoku solved:");
            for (int[] row : sudoku) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists.");
        }
    }
}

