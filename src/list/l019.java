package list;

// 19. 删除链表的倒数第N个节点
// <要求>：一趟扫描实现
// 「双指针」
public class l019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 设置哑节点作为辅助
        ListNode zero = new ListNode(0);
        zero.next = head;
        ListNode right = zero;
        while (n-- > 0) {
            right = right.next;
        }
        ListNode left = zero;
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return zero.next;
    }
}
