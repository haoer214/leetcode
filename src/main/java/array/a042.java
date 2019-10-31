package array;

/**
 * 42. 接雨水
 */
public class a042 {
    // 「双指针」
    public int trap(int[] height) {
        int len = height.length;
        int maxWater = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (height[j] >= height[i]) {
                    i = j;
                    break;
                }
                maxWater += height[i] - height[j];
            }
        }
        return maxWater;
    }
}
