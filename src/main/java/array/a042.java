package array;

/**
 * 42. 接雨水
 */
public class a042 {
    // 「双指针」
    public int trap(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int len = height.length;
        int maxWater = 0;
        int tmpWater = 0;
        // 从左往右遍历
        int left = 0, i = left+1;
        while (i < len) {
            if (height[i] >= height[left]) {
                maxWater += tmpWater;
                tmpWater = 0;
                left = i++;
            } else {
                tmpWater += height[left] - height[i++];
            }
        }
        // 找到最高的柱子
        int top = left;
        if (height[len-1] < height[top]) {
            tmpWater = 0;
            // 从右往左遍历
            int right = len-1, j = right-1;
            while (j > top) {
                if (height[j] >= height[right]) {
                    maxWater += tmpWater;
                    tmpWater = 0;
                    right = j--;
                } else {
                    tmpWater += height[right] - height[j--];
                }
            }
            maxWater += tmpWater;
        }
        return maxWater;
    }
}
