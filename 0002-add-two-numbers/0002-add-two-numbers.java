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
    
    public ListNode add(ListNode l1, ListNode l2, int carry){
        
        if(l1 == null && l2 == null && carry == 0)
            return null;
        
        if(l1 == null && l2 == null && carry != 0)
            return new ListNode(carry);
        
        int value = 0;
        ListNode temp;
        
        if(l1 == null && l2 != null){
            value = l2.val + carry;
            carry = value/10;
            temp = add(null, l2.next, carry);
        }
        else if(l1 != null && l2 == null){
            value = l1.val + carry;
            carry = value/10;
            temp = add(l1.next, null, carry);
        }else{
            value = l1.val + l2.val + carry;
            carry = value/10;
            temp = add(l1.next, l2.next, carry);
        }
                
        value = value%10;
        ListNode curr = new ListNode(value);
        if(temp != null)
            curr.next = temp;
        
        return curr;
            
    }
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
        return add(l1,l2,0);
    }
}