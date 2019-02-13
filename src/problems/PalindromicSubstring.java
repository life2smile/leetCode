package problems;

import action.IAction;

/**
 * Created by wenzhi on 2019/2/13.
 */
public class PalindromicSubstring implements IAction {
    @Override
    public void doExecute() {
        System.out.println(solution("babad"));
    }

    /**
     * In fact, we could solve it in O(n^2)O(n
     * 2
     * ) time using only constant space.
     * <p>
     * We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center,
     * and there are only 2n - 12n−1 such centers.
     * <p>
     * You might be asking why there are 2n - 12n−1 but not nn centers? The reason is the center of a palindrome
     * can be in between two letters.Such palindromes have even number of letters (such as "abba") and its center are
     * between the two 'b's.
     */
    private String solution(String s) {

        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    /**
     * @param s
     * @param left
     * @param right
     * @return 返回 回文长度
     */
    private int expandAroundCenter(String s, int left, int right) {
        while ((left >= 0 && right < s.length())
                && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
