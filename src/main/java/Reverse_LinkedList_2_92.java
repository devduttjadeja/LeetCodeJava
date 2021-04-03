public class Reverse_LinkedList_2_92 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(reverseBetween(head, 2, 4));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null) {
            return head;
        }
        // 1, [2, 3, 4], 5
        ListNode current = head;
        ListNode prev = null;
        int steps = right - left + 1;

        // after this while loop
        // prev to 1
        // current to 2
        while (left > 1) {
            prev = current;
            current = current.next;
            left--;
        }

        ListNode leftConnect = prev; // to connect 1 --> 4 we maintain reference leftConnect
        ListNode rightConnect = current; // to connect 2 --> 5 we maintain reference rightConnect

        // after this while loop
        // prev = 4
        // current = 5
        while (steps > 0) {
            ListNode next_node = current.next;
            current.next = prev;
            prev = current;
            current = next_node;
            steps--;
        }

        // if leftConnect is null meaning left = 1 or left is head
        if(leftConnect != null){
            leftConnect.next = prev;
        }else {
            head = prev;
        }

        rightConnect.next = current;
        return head;
    }
}
