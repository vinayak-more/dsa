class ListNode{
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next ) { this.val = val; this.next = next; }
}

public class ReverseLinkedList{
	public ListNode reverseList(ListNode head){
		ListNode prev = null, cur = head, temp;
		while( cur != null ){
			temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}
}
/*
 1 -> 2 -> 3 -> 4 -> null
p = null c = 1 
t = 2 p = 1 c = 2 null <- 1
t = 3 p = 		null <- 1 <- 2



*/