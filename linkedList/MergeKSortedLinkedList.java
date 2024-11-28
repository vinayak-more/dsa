class ListNode{
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int val){ this.val = val; }
}

public class MergeKSortedLinkedList{
	// time O(k + nlog(n)) space O(n)
	public ListNode mergeKLists1(ListNode[] lists){
		Queue<ListNode> queue = new PriorityQueue<>((a, b)-> a.val - b.val);
		queue.addAll(Arrays.asList(lists));
		ListNode dummy = new ListNode();
		ListNode curr = dummy, node;
		while(!queue.isEmpty()){
			node = queue.poll();
			curr.next = node;
			curr = curr.next;
			if(node.next != null) queue.offer(node.next);
		}
		return dummy.next;
	}
	
	// time Complexity O( n * k ) space complexity O(1)
	public ListNode mergeKLists(ListNode[] lists){
		ListNode dummy = new ListNode();
		ListNode curr = dummy, minNode, node;
		int minIndex;
	
		do{
			minNode = null;
			minIndex = 0;
			for(int i = 0; i < lists.length; i++){
				node = lists[i];
				if(node == null) continue;
				if(minNode == null || minNode.val > node.val) {
					minNode = node;
					minIndex = i;
				}
			}
			if(minNode != null){
				curr.next = minNode;
				curr = curr.next;
				lists[minIndex] = minNode.next;
			}
		}while(minNode != null);

		return dummy.next;		
	}
}