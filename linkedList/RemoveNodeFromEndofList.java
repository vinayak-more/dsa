class ListNode{
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next ) { this.val = val; this.next = next; }
}

public class RemoveNodeFromEndofList{
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p = head;
		while( n-- > 0){
			p = p.next;
		}
		ListNode q = head;
		ListNode prev = null;
		while(p.next != null){
			p = p.next;
			prev = q;
			q = q.next;
		}
		prev.next = q.next;
		q.next = null;
		return head;
	}
}

/**
2 4 6 8 10 n = 3
p = 2 n = 3
n = 2 p = 4
n = 1 p = 6
n = 0 ------
p = 6 q = 2 prev = null
p = 8 q = 4 prev = 2
p = 10 q = 6 prev = 4
2 4 8 10


*/