import java.util.*;

public class Most_Common_word_819 {

    public static void main(String[] args) {
        String[] banned = {"a"};
        String answer = mostCommonWord("a, a, a, a, b,b,b,c, c", banned);
        System.out.println(answer);
    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        // clear . , space and other things and replace with empty space
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] paragraphWords = paragraph.split("\\s+");

        // create a set of banned words
        // NOTE : set because we use contains() method repeatedly --> O(1)
        Set<String> bannedWords = new HashSet<>();
        bannedWords.retainAll(bannedWords);
        bannedWords.addAll(Arrays.asList(banned));

        // count the frequency of words that are not banned

        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : paragraphWords) {

            if (!bannedWords.contains(word)) {

                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        String answer = Collections.max(wordMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        return answer;
    }
}
