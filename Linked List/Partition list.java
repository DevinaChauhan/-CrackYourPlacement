class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead=null;
        ListNode smallerTail=null;
        ListNode biggerHead=null;
        ListNode biggerTail=null;
        
        while(head!=null)
        { 
            int y=head.val;
        ListNode current=new ListNode(y);
            if(y<x)
            { 
                if(smallerHead==null)
                {
                    smallerHead=current;
                    smallerTail=smallerHead;
                }
                else
                {
                    smallerTail.next = current;
                    smallerTail = smallerTail.next;

                }
                

            }
            else
            {
              if(biggerHead==null)
              {
                biggerHead=current;
                biggerTail=biggerHead;
              }  
              else
              {
               biggerTail.next = current;
               biggerTail = biggerTail.next;
              }
              
            }
            head=head.next;
        }

        if (smallerTail != null) {
            smallerTail.next = biggerHead;
        } else {
            smallerHead = biggerHead;
        }

        if (biggerTail != null) {
            biggerTail.next = null;
        }

        return smallerHead;
    }
}
