import action.IAction;
import problems.LongestSubstringWithoutReapting;
import problems.TwoSum;

import java.util.HashMap;
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

    private static void testAll() {
        Map<String, IAction> map = new HashMap<>();
        map.put(twoNum, new TwoSum());
        map.put(longestSubstringWithoutReapting, new LongestSubstringWithoutReapting());

        for (String key : map.keySet()) {
            map.get(key).doExecute();
        }
    }
}
