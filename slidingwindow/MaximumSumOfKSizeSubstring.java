import java.util.*;

public class MaximumSumOfKSizeSubstring{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0 ; i < n; i++) arr[i] = sc.nextInt();
			result[c] = solve(arr, k);
		}

		Arrays.stream(result).forEach(System.out::println);
	}

	private static int solve(int[] nums, int k){
		int max = 0, sum = 0;
		int start = 0, end = 0;
		for(end = 0; end < k; end++){
			sum += nums[end];
		}
		max = sum;
		while(end < nums.length){
			sum += nums[end];
			sum -= nums[start];
			max = Math.max(max, sum);
			start++;
			end++;
		}
		return max;

	}
}
