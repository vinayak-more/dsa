import java.util.*;

public class SlidingWindowMaximum{
	public int[] maxSlidingWindow(int[] nums, int k) {
        	Deque<Integer> queue = new LinkedList<>();
		int i = 0;
		for(i = 0; i < k; i++){
			while(!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) queue.removeLast();
			queue.addLast(i);
		}

		int[] max = new int[nums.length - k + 1];
		max[0] = nums[queue.getFirst()];
		int counter = 1;
		
		while(i < nums.length){
			//remove indexes that are out of window
			while(!queue.isEmpty() && queue.getFirst() <= i - k ) queue.removeFirst();

			//update monotonic max queue
			while(!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) queue.removeLast();
			queue.addLast(i);

			max[counter] = nums[queue.getFirst()];
			i++;
			counter++;
		}
		return max;
	}

}

//1 2 1 0 4 2 6 
//i = 0 [0]
//i = 1 [1]
//i = 2 [1, 2] 		max = [2]
//i = 3 [1, 2, 3] 	max = [2, 2]
//i = 4 [4] 		max = [2, 2, 4]
//i = 5 [4, 5] 		max = [2, 2, 4, 4]
//i = 6 [6]		max = [2, 2, 4, 4, 6]