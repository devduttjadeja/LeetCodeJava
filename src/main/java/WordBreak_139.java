import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {

    public static void main(String[] args) {
        String input = "aaaaaaa";
        // wordDict = ["leet","code"]
        boolean ans = wordBreak(input, Arrays.asList("aaaa", "aaa"));
        System.out.println(ans);
    }

    public static boolean wordBreak(String input, List<String> wordDict) {
        // assume input and wordDict are non-empty
        Set<String> wordSet = new HashSet<>(wordDict);
        return helper(input, wordSet, 0);
    }

    public static boolean helper(String input, Set<String> wordSet, int depth) {

        if (depth == input.length()) {
            return true;
        }

        for (int i = depth; i < input.length(); i++) {
            String substring = input.substring(depth, i + 1); // substring[depth, i] "l", "le", "lee", "leet"
            if (wordSet.contains(substring)) {
                //return helper(input, wordSet, i + 1);
                if (helper(input, wordSet, i + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}
