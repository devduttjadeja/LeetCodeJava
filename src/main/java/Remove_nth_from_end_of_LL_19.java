public class Remove_nth_from_end_of_LL_19 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null){
            return head;
        }

        ListNode left = head;
        ListNode right = head;
        ListNode prev = null;

        // [1, 2, 3, 4, 5] , n = 2
        while (n > 0){
            right = right.next;
            n--;
        }

        // this is only to handle the edge case when n = size of list
        // in that case remove first element so return head.next
        if(right == null){
            return head.next;
        }

        while(right != null){
            prev = left;
            left = left.next;
            right = right.next;
        }

        prev.next = left.next;

        return head;
    }
}
