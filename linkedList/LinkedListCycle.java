class ListNode{
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next ) { this.val = val; this.next = next; }
}
public class LinkedListCycle{
	public boolean hasCycle(ListNode head){
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return true;
		}
		return false;
	}
}