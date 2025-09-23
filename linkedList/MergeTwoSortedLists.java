class ListNode{
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next ) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLists{

	public ListNode mergeTwoLists(ListNode list1, ListNode list2){
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		
		ListNode dummy = new ListNode();
		ListNode curr = dummy;

		while(list1 != null || list2 != null){
			if(list1 == null){
				curr.next = list2;
				curr = curr.next;
				list2 = list2.next;
				continue;
			}
			if(list2 == null){
				curr.next = list1;
				curr = curr.next;
				list1 = list1.next;
				continue;
			}
			if(list1.val < list2.val ){
				curr.next = list1;
				curr = curr.next;
				list1 = list1.next;
				continue;
			} else {
				curr.next = list2;
				curr = curr.next;
				list2 = list2.next;
				continue;
			}

		}
		return dummy.next;
	}
}
/*
1 2 4  1 3 5
c = d l1 = 1 l2 = 1
c = d - > 1 l1 = 2 -> 4 l2 = 1 -> 3 -> 5 d = 0 -> 1



*/