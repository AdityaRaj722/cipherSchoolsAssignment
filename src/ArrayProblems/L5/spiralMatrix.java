package ArrayProblems.L5;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int sx = 0, sy = 0, ex = matrix.length - 1, ey = matrix[0].length - 1;

        while (sx <= ex && sy <= ey) {
            // Traverse from left to right along the top row
            for (int j = sy; j <= ey; j++) {
                result.add(matrix[sx][j]);
            }
            sx++;

            // Traverse from top to bottom along the right column
            for (int i = sx; i <= ex; i++) {
                result.add(matrix[i][ey]);
            }
            ey--;

            // Traverse from right to left along the bottom row, if there is a bottom row remaining
            if (sx <= ex) {
                for (int j = ey; j >= sy; j--) {
                    result.add(matrix[ex][j]);
                }
                ex--;
            }

            // Traverse from bottom to top along the left column, if there is a left column remaining
            if (sy <= ey) {
                for (int i = ex; i >= sx; i--) {
                    result.add(matrix[i][sy]);
                }
                sy++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = spiralOrder(matrix);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
