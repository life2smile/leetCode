package problems;

import action.IAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

public class TwoSum implements IAction {

    @Override
    public void doExecute() {
        int[] result;
//        result = twoSum(new int[]{2, 7, 11, 15}, 9);
        result = twoSum2(new int[]{2, 8, 7, 15}, 9);

        System.out.println("two sum result : " + result[0] + " " + result[1]);
    }

    /**
     * 常规方案，时间复杂度o(n^2)，空间复杂度o(1)
     */
    private int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("No tow sum solution");
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        throw new IllegalArgumentException("No tow sum solution");
    }

    /**
     * 优化方案，时间复杂度o(n) 空间复杂度o(1)，相当于用空间换取了时间
     */
    private int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("No tow sum solution");
        }

        Map<Integer, Integer> indicesMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int expectVal = target - nums[i];

            if (indicesMap.containsKey(expectVal)) {
                return new int[]{indicesMap.get(expectVal), i};
            }

            indicesMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No tow sum solution");
    }

}
