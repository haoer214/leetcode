package array;

/**
 * 33. 搜索旋转排序数组
 */
public class a033 {
    // 要求：时间复杂度为O(logN)
    // 方法：「二分查找」
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid]) {
                if(target == nums[left])
                    return left;
                else if (target < nums[left] && nums[left] <= nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (target == nums[right])
                    return right;
                else if (target > nums[right] && nums[right] >= nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
