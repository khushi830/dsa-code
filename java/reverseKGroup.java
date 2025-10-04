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
class Solution
{
    public ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode temp=head;
        ListNode tempPre=null;
        ListNode tail=head;
        ListNode tailNext=null;
        int count=1;
        boolean first=true;
        while(tail!=null)
        {
            if(count==k)
            {
                tailNext=tail.next;
                if(first)
                {
                    head=reverse(temp,tail);
                    first=false;
                }
                else
                    tempPre.next=reverse(temp,tail);
                
                count=1;
                tempPre=temp;
                temp=temp.next=tail=tailNext;
                continue;
            }

            tail=tail.next;
            count++;
        }

        return head;
    }

    public ListNode reverse(ListNode head, ListNode tail)
    {
        if(head==tail)
            return tail;

        ListNode rest=reverse(head.next, tail);
        head.next.next=head;
        head.next=null;
        return rest;
    }
}
