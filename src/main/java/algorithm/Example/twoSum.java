package algorithm.Example;

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0;i < nums.length;i++) {
            int sort = target - nums[i];
            Integer sortIndex = map.get(sort);
            // 避免重复
            if (null != sortIndex) {
                // 两个数下标存进数组
                result[0] = sortIndex;
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
