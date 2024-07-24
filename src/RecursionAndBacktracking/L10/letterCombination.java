package RecursionAndBacktracking.L10;

import java.util.ArrayList;
import java.util.List;

public class letterCombination {

    private static void solve(String digits, String output, int index, List<String> ans, String[] mapping) {
        // Base case
        if (index >= digits.length()) {
            ans.add(output);
            return;
        }

        int number = digits.charAt(index) - '0';
        String value = mapping[number];

        for (int i = 0; i < value.length(); i++) {
            output += value.charAt(i);
            solve(digits, output, index + 1, ans, mapping);
            output = output.substring(0, output.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String output = "";
        int index = 0;

        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        solve(digits, output, index, ans, mapping);
        return ans;
    }

    public static void main(String[] args) {

        String digits = "23";
        List<String> result =letterCombinations(digits);

        for (String combination : result) {
            System.out.println(combination);
        }
    }
}

