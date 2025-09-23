import java.util.*;

class ListNode{
	int val;
	ListNode next;
	ListNode random;
	ListNode(){}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next ) { this.val = val; this.next = next; }
	ListNode(int val, ListNode next, ListNode random) { this.val = val; this.next = next; this.random = random; }
}

public class CopyLinkedListwithRandomPointer{
	public ListNode copyRandomList(ListNode head){
		ListNode dummy = new ListNode();
		ListNode cur = dummy;
		Map<ListNode, ListNode> map = new HashMap<>();
		ListNode temp = head;
		while(temp != null ){
			cur.next = new ListNode(temp.val);
			cur = cur.next;
			map.put(temp, cur);
			temp = temp.next;
		}
		temp = head;
		cur = dummy.next;
		while(temp != null){
			cur.random = map.get(temp);
			cur = cur.next;
			temp = temp.next;
		}
		return dummy.next;
	}
}