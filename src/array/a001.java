package array;

import java.util.HashMap;
import java.util.Map;

// 1、两数之和
public class a001 {
    // ①暴力解法 时间O(n2) 空间O(1)
//    public int[] twoSum(int[] nums, int target) {
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]+nums[j]==target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }

    // ②两遍哈希表 时间O(n) 空间O(n)
    // 先存后查(略LisNode)

    // ③一遍哈希表 时间O(n) 空间O(n)
    // 边存边查
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int tmp = target-nums[i];
            if (map.containsKey(tmp)){
                return new int[]{map.get(tmp),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
