package array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 */
public class a039 {
    //「回溯算法」
    List<List<Integer>> combinationList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return combinationList;
        }
        // 先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        backTrack(target, 0, candidates, new ArrayDeque<>());
        return combinationList;
    }
    public void backTrack(int residue, int start, int[] candidates, ArrayDeque<Integer> combination){
        if (residue == 0) {
            // Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
            combinationList.add(new ArrayList<>(combination));
            return;
        }
        // residue - candidates[i] 表示下一轮的剩余，如果小于0 ，就没有必要进行后面的循环了
        // 这一点基于原始数组是排序数组(升序)的前提，因为后面肯定没有更小的 candidates[i]
        for (int i = start; i < candidates.length && residue - candidates[i] >= 0; i++) {
            combination.push(candidates[i]);
            backTrack(residue - candidates[i], i, candidates, combination);
            combination.pop();
        }
    }
}
