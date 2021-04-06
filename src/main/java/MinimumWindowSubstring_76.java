import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {

    public static void main(String[] args) {

    }

    public static String minWindow(String s, String t) {

        // s = "ADOBECODEBANC", t = "ABC"

        // map which keeps a count of all the unique characters in t.
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = mapT.size();

        // Left and Right pointer
        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then current window must have two A's, one B and one C.
        // Thus formed would be = 3 when all key and value are met.
        int left = 0;
        int right = 0;
        int formed = 0;

        // keep 3 values to store the answers;
        int minLenght = Integer.MAX_VALUE;
        int leftIndex = 0;
        int rightIndex = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> currentMap = new HashMap<>();

        while (right < s.length()) {

            // Add one character from the right to the window
            char currentChar = s.charAt(right);
            currentMap.put(currentChar, currentMap.getOrDefault(currentChar, 0) + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (mapT.containsKey(currentChar) && currentMap.get(currentChar).equals(mapT.get(currentChar))) {
                formed++;
            }

            // while the condtions are satisfied start removing characters from left and move left forward.
            // by remove means decreasing the frequency
            while (formed == required) {

                // save the answer only when we get a better solution than previous
                int currentLength = right - left + 1;
                if (currentLength < minLenght) {
                    minLenght = currentLength;
                    leftIndex = left;
                    rightIndex = right;
                }

                char leftChar = s.charAt(left);
                currentMap.put(leftChar, currentMap.get(leftChar) - 1);

                // after decreasing the frequency, if the required chars are not in current window then decrment formed
                // freq of removed char in currentMap is less than freq in mapT, then decrease formed
                if (mapT.containsKey(leftChar) && currentMap.get(leftChar) < mapT.get(leftChar)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLenght < Integer.MAX_VALUE ? s.substring(leftIndex, rightIndex + 1) : "";
    }
}
