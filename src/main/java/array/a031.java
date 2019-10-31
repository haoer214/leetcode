package array;

/**
 * 31. 下一个排列
 */
public class a031 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int k = nums.length-2;
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }
        if (k >= 0) {
            for (int l = nums.length - 1; l > k; l--) {
                if (nums[l] > nums[k]) {
                    swap(nums, k, l);
                    break;
                }
            }
        }
        reverse(nums, k + 1);
    }
    // 交换元素
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    // 反序
    public void reverse(int[] nums, int start){
        int i = start, j = nums.length-1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
