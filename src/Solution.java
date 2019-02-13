import action.IAction;
import problems.LongestSubstringWithoutReapting;
import problems.PalindromicSubstring;
import problems.TwoSum;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wenzhi on 2019/2/11.
 */
public class Solution {
    public static void main(String[] args) {
        testAll();
    }

    private static final String twoNum = "TWO_NUM";
    private static final String longestSubstringWithoutReapting = "LONGGEST_SUBSTRING_WITHOUT_REAPTING";
    private static final String PalindromicSubString = "PALINDROMIC_SUBSTRING";

    private static void testAll() {
        Map<String, IAction> map = new LinkedHashMap<>();
        map.put(twoNum, new TwoSum());
        map.put(longestSubstringWithoutReapting, new LongestSubstringWithoutReapting());
        map.put(PalindromicSubString, new PalindromicSubstring());

        for (String key : map.keySet()) {
            map.get(key).doExecute();
        }
    }
}
