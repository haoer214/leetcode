package list;

import java.util.List;

// 23. 合并K个排序链表
public class l023 {
    // ①暴力解法（逐一比较）
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode dummy = new ListNode(-1);
//        ListNode current = dummy;
//        while (true) {
//            int tmp = -1;
//            for (int i = 0; i < lists.length; i++) {
//                if (lists[i] != null) {
//                    if (current.next == null || current.next.val > lists[i].val) {
//                        current.next = lists[i];
//                        tmp = i;
//                    }
//                }
//            }
//            if (tmp < 0) {
//                return dummy.next;
//            } else {
//                lists[tmp] = lists[tmp].next;
//            }
//            current = current.next;
//            current.next = null;
//        }
//    }
//    public static void main(String[] args) {
//        ListNode n1 = new ListNode(1);
//        n1.next = new ListNode(4);
//        n1.next.next = new ListNode(5);
//        ListNode n2 = new ListNode(1);
//        n2.next = new ListNode(3);
//        n2.next.next = new ListNode(4);
//        ListNode n3 = new ListNode(2);
//        n3.next = new ListNode(6);
//        ListNode[] nodes = {n1,n2,n3};
//        new l023().mergeKLists(nodes);
//    }

    // ②分治
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int k = lists.length;
        while (k > 1){
            for (int i = 0; i < k/2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[k-1-i]);
            }
            k = k/2 + k%2;

        }
        return lists[0];
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
