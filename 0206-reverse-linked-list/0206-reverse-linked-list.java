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
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode back = null;
        ListNode front;

        while(cur!=null){
            front = cur.next;
            cur.next = back;
            back = cur;
            cur = front;
        }
        return back;

        
    }
}