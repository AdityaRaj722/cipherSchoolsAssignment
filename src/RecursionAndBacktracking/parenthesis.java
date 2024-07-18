package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class parenthesis {

    private static void solve(String op, int open, int close, List<String> ans) {
        if (open == 0 && close == 0) {
            ans.add(op);
            return;
        }
        if (open == close) {
            solve(op + "(", open - 1, close, ans);
        }
        // Only choice is to put close brackets
        else if (open == 0) {
            solve(op + ")", open, close - 1, ans);
        }
        // Only choice is to use open bracket
        else if (close == 0) {
            solve(op + "(", open - 1, close, ans);
        }
        // Otherwise, we have two choices, to put either open or close bracket
        else {
            solve(op + "(", open - 1, close, ans);
            solve(op + ")", open, close - 1, ans);
        }
    }

    public static List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;
        List<String> ans = new ArrayList<>();
        solve("", open, close, ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 3; // Example usage
        List<String> result =generateParenthesis(n);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
