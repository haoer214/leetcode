package array;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class a034 {
    // 要求：时间复杂度为O(logN)
    // 方法：「二分查找」
    // 问：用二分找到一个 target，然后向左或向右线性搜索不行吗？
    // 答：可以，但是不好，因为这样难以保证二分查找对数级的复杂度
    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeftRange(nums,target),searchRightRange(nums,target)};
    }
    public int searchLeftRange(int[] nums, int target){
        int left = 0, right = nums.length, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (target == nums[mid])
                right = mid;
            else if(target < nums[mid])
                right = mid;
            else if(target > nums[mid])
                left = mid + 1;
        }
        if (left == nums.length)
            return -1;
        return nums[left] == target ? left : -1;
    }
    public int searchRightRange(int[] nums, int target){
        int left = 0, right = nums.length, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (target == nums[mid])
                left = mid + 1;
            else if(target > nums[mid])
                left = mid +1;
            else if(target < nums[mid])
                right = mid;
        }
        if (left == 0)
            return -1;
        return nums[left - 1] == target ? left - 1 : -1;
    }
}
