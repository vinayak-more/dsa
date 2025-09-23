import java.util.*;

public class LargestRectangleInHistogram{
	public int largestRectangleArea(int[] heights){
		int[] left = smallerElementToLeft(heights);
		int[] right = smallerElementToRight(heights);
		int[] w = new int[heights.length];
		int max = 0;
		for(int i = 0; i < w.length; i++){
			w[i] = right[i] - left[i] - 1;
			max = Math.max(max, w[i] * heights[i]);
		}
		return max;
	}
	
	public int[] smallerElementToLeft(int[] nums){
		Deque<Integer> stack = new LinkedList<>();
		int[] result = new int[nums.length];
		for(int i = 0; i < nums.length; i++){
			while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
			if(stack.isEmpty()) result[i] = -1;
			else result[i] = stack.peek();
			stack.push(i);
		}
		return result;
	}

	public int[] smallerElementToRight(int[] nums){
		int n = nums.length;
		Deque<Integer> stack = new LinkedList<>();
		int[] result = new int[n];
		for(int i = n - 1; i >= 0; i--){
			while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
			if(stack.isEmpty()) result[i] = n;
			else result[i] = stack.peek();
			stack.push(i);
		}
		return result;
	}
}
//    7  1  7 2 2 4
//l = -1 -1 1 1 1 4
//r =  1  6 3 6 6 6
//w =  1  6 1 4 4 1 r - l - 1
//h =  8  6 7 8 8 4