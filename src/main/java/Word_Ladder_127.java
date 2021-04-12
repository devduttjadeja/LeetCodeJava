import java.util.*;

public class Word_Ladder_127 {
    public static void main(String[] args) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            // number of nodes at each level
            for (int i = 0; i < size; i++) {

                String current = queue.poll();
                char[] currentChars = current.toCharArray();

                // "h i t"
                for (int j = 0; j < currentChars.length; j++) {

                    // save h temporarily
                    char original = currentChars[j];

                    // "ait", "bit", "cit" etc
                    for (char c = 'a'; c <= 'z'; c++) {

                        // skip if c = h, for "hit"
                        if (currentChars[j] == c) {
                            continue;
                        }

                        currentChars[j] = c;
                        String newWord = new String(currentChars); // "ait"

                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }

                    }

                    currentChars[j] = original;

                }
            }

            level++;
        }
        return 0;
    }
}
