package array;

// 11. 盛最多水的容器
// 「双指针」
public class a011 {
    // ①暴力法 时间O(n2),空间O(1)
//    public int maxArea(int[] height) {
//        int maxCapacity = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                maxCapacity = Math.max(maxCapacity, (j - i) * Math.min(height[i], height[j]));
//            }
//        }
//        return maxCapacity;
//    }
    // ②双指针，一次扫描  时间O(n),空间O(1)
    public int maxArea(int[] height) {
        int maxCapacity = 0;
        int i = 0, j = height.length-1;
        while (i < j) {
            maxCapacity = Math.max(maxCapacity, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxCapacity;
    }
}
