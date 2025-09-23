class ListNode{
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next ) { this.val = val; this.next = next; }
}

public class ReorderLinkedList{
	public ListNode reorderList(ListNode head){
		ListNode list1 = head;
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode list2 = slow.next;
		slow.next = null;
		list2 = reverseList(list2);
		ListNode dummy = new ListNode();
		ListNode curr = dummy;
		
		while(list1 != null && list2 != null){
			curr.next = list1;
			list1 = list1.next;
			curr = curr.next;

			curr.next = list2;
			list2 = list2.next;
			curr = curr.next;
		}
		if(list1 != null ) curr.next = list1;
		
		return dummy.next;
	}
	
	private ListNode reverseList(ListNode head){
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
/* 2 4 6 8 9
s = 2 f = 2
s = 4 f = 6
s = 6 f = 9
l2 = 8 9
l1 = 2 4 6
l2 = 9 8
d = 0 
c = 0
c = 0 2 9 l1 = 4 6 l2 = 8
c = 0 2 9 4 8 l1 = 6 l2 = null
c = 0 2 9 4 8 6 



*/