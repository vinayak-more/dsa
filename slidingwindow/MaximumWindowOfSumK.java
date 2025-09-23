import java.util.*;

public class MaximumWindowOfSumK{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] nums = new int[n];
			for(int i = 0 ; i < n; i++) nums[i] = sc.nextInt();
			result[c] = solve(nums, k);
		}

		Arrays.stream(result).forEach(System.out::println);
	}

	private static int solve(int[] nums, int k){
		int start = 0, end = 0, sum = 0, max = 0;
		while(end < nums.length){
			sum += nums[end];
			while(sum > k ){
				sum -= nums[start];
				start++;
			}
			if( sum == k ) max = Math.max(max, (end - start + 1));
			
			end++;
		}
		return max;
	}
	
}
