/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null ){
            return head;
        }
        ListNode even = head;
        ListNode odd = head.next;
        ListNode oddhead = head.next;

        while(even != null && odd != null && even.next != null && odd.next != null){
            even.next = even.next.next;
            odd.next = odd.next.next;

            even = even.next;
            odd = odd.next;
        }
        even.next = oddhead;
        return head;
        
    }
}