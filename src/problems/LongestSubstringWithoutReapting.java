package problems;

import action.IAction;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "w
 */
public class LongestSubstringWithoutReapting implements IAction {
    @Override
    public void doExecute() {
//        System.out.println("longest substring without repeating result : " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("longest substring without repeating result : " + lengthOfLongestSubstring2("abcabcbb"));
    }

    /**
     * 一般解法， 时间复杂度o(n^3)
     *
     * @param s
     * @return
     */
    private int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (!hasRepeatChar(s, i, j)) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    private boolean hasRepeatChar(String s, int start, int end) {
        Set<Character> set = new HashSet<>();

        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) {
                return true;
            }
            set.add(s.charAt(i));
        }
        return false;
    }

    /**
     * 优化解法，时间复杂度o(2n) = o(n)，空间复杂度 o(s.length, 26)
     *
     * @param s
     * @return
     */
    private int lengthOfLongestSubstring2(String s) {
        int maxLen = 0;
        if (s == null || s.isEmpty()) {
            return maxLen;
        }

        int start = 0;
        int end = 0;

        Set<Character> set = new HashSet<>();
        while (start < s.length() && end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                maxLen = Math.max(maxLen, end - start);
            } else {
                set.remove(s.charAt(start++));
            }
        }
        return maxLen;
    }
}
