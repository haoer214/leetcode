package graph;

import java.util.HashSet;
import java.util.LinkedList;

// 207. 课程表
// 判断是否为「有向无环图(DAG)」
public class g207 {
    /*
     *【基本数据类型】的值传递,不改变原值,因为调用后就会弹栈,局部变量随之消失
     *【引用数据类型】的值传递,改变原值,因为即使方法弹栈,但是堆内存数组对象还在,可以通过地址继续访问
     */
    // 我的解答
//    private HashSet<Integer> globalSet = new HashSet<>();
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        HashSet<Integer> tmpSet = new HashSet<>();
//        boolean finalAns;
//        for (int courseID = 0; courseID < numCourses; courseID++) {
//            if (!globalSet.contains(courseID)) {
//                finalAns = dfs(tmpSet, prerequisites, courseID);
//                if (!finalAns)
//                    return false;
//            }
//        }
//        return true;
//    }
//    private boolean dfs(HashSet<Integer> tmpSet, int[][] prerequisites, int courseID) {
//        globalSet.add(courseID);
//        if (tmpSet.contains(courseID))
//            return false;
//        tmpSet.add(courseID);
//        boolean ans;
//        for (int[] prerequisite : prerequisites) {
//            if (prerequisite[0] == courseID) {
//                ans = dfs(tmpSet, prerequisites, prerequisite[1]);
//                if (!ans)
//                    return false;
//            }
//        }
//        tmpSet.remove(courseID);
//        return true;
//    }
//    public static void main(String[] args){
//        new g207().canFinish(2, new int[][]{{1, 0}});
//    }

    // ①入度表（广度优先遍历）
    // 时间O(N+M) 空间O(N) N和M分别为节点数量和临边数量
    // 依次删掉入度为0的节点，如果存在有向环，则无法删除全部节点
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int[] rely : prerequisites) {
            indegrees[rely[0]]++;
        }
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offerLast(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.pollFirst();
            numCourses--;
            for (int[] rely : prerequisites) {
                if (rely[1] == pre) {
                    if (--indegrees[rely[0]] == 0) {
                        queue.offerLast(rely[0]);
                    }
                }
            }
        }
        return numCourses == 0;
    }

    // ②邻接矩阵（深度优先遍历）
    // 时间O(N+M) 空间O(N) N和M分别为节点数量和临边数量
    // 借助标志列表【flags】来判断每个节点i的状态：
    // --未被dfs访问：flags[i] == 0
    // --已被其他节点启动的dfs访问：flags[i] == -1
    // --已被当前节点启动的dfs访问：flags[i] == 1

//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[][] adjacency = new int[numCourses][numCourses];
//        int[] flags = new int[numCourses];
//        for (int[] rely : prerequisites) {
//            adjacency[rely[1]][rely[0]] = 1;
//        }
//        for (int i = 0; i < numCourses; i++) {
//            if (!dfs(adjacency, flags, i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//    public boolean dfs(int[][] adjacency, int[] flags, int i) {
//        if (flags[i] == -1) {
//            return true;
//        }
//        if (flags[i] == 1) {
//            return false;
//        }
//        flags[i] = 1;
//        for (int j = 0; j < adjacency.length; j++) {
//            if (adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) {
//                return false;
//            }
//        }
//        flags[i] = -1;
//        return true;
//    }
}
