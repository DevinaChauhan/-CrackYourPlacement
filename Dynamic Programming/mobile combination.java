import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final String[] mapping = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, "", digits, 0);
        return result;
    }

    public void backtrack(List<String> result, String combination, String digits, int index) {
        if (index == digits.length()) {
            result.add(combination);
        } else {
            char digit = digits.charAt(index);
            String letters = mapping[digit - '0'];
            for (int i = 0; i < letters.length(); i++) {
                backtrack(result, combination + letters.charAt(i), digits, index + 1);
            }
        }
    }
}
