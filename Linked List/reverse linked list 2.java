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
    
    static ListNode[] reverse(ListNode head, int count) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp;
        while (count > 0 && curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count--;
        }
        return new ListNode[] { prev, curr };
    }

    // Reverse nodes between left and right positions
    static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;
        
        ListNode leftNode = head;
        ListNode beforeLeftNode = null;
        
        for (int i = 1; i < left; ++i) {
            beforeLeftNode = leftNode;
            leftNode = leftNode.next;
        }

        ListNode[] reversed = reverse(leftNode, right - left + 1);
        ListNode rightNode = reversed[0];
        ListNode afterRightNode = reversed[1];
        
        if (beforeLeftNode != null) {
            beforeLeftNode.next = rightNode;
        } else {
            head = rightNode;
        }
        
        leftNode.next = afterRightNode;
        
        return head;
    }
}
