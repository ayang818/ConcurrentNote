package Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/10/14 15:18
 **/
class Solution {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask ^ (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < nums.length; j++) {
//                取前缀32-i位
                set.add(mask & nums[j]);
            }
            int temp = res ^ (1 << i);
            for (Integer num : set) {
                if (set.contains(num ^ temp)) {
                    res = temp;
                }
            }
        }
        return res;
    }
}
