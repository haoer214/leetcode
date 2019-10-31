package list;

// 2、两数相加
public class l002 {
    // 我的提交
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int num = (l1.val + l2.val)%10;
//        int carry = (l1.val + l2.val)/10;
//        ListNode head = new ListNode(num);
//        ListNode tmp = head;
//        while (l1.next!=null && l2.next!=null){
//            num = (l1.next.val +l2.next.val+carry)%10;
//            carry = (l1.next.val +l2.next.val+carry)/10;
//            tmp.next = new ListNode(num);
//            tmp = tmp.next;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        while (l1.next!=null){
//            num = (l1.next.val + carry)%10;
//            carry = (l1.next.val + carry)/10;
//            tmp.next = new ListNode(num);
//            tmp = tmp.next;
//            l1 = l1.next;
//        }
//        while (l2.next!=null){
//            num = (l2.next.val + carry)%10;
//            carry = (l2.next.val + carry)/10;
//            tmp.next = new ListNode(num);
//            tmp = tmp.next;
//            l2 = l2.next;
//        }
//        if (carry!=0){
//            tmp.next = new ListNode(carry);
//        }
//        return head;
//    }

    // 参考答案
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, curr = head;
        int carry = 0;
        while (p!=null || q!=null){
            int x = (p!=null) ? p.val : 0;
            int y = (q!=null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if (p!=null)
                p = p.next;
            if (q!=null)
                q = q.next;

        }
        if (carry!=0){
            curr.next = new ListNode(carry);
        }
        return head.next;
    }
}
