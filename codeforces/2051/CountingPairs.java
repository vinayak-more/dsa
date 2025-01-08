import java.util.*;

//problem 2051 D
public class CountingPairs{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		long[] result = new long[cases];
		int n;
		long x, y;
		long[] a;
		for(int k = 0; k < cases; k++){
			n = sc.nextInt();
			x = sc.nextLong();
			y = sc.nextLong();
			a = new long[n];
			for(int i = 0; i < n; i++) a[i] = sc.nextLong();
			Arrays.sort(a);
			result[k] = (solve(a, y + 1) - solve(a, x));
		}
		Arrays.stream(result).forEach(System.out::println);
		
	}

	private static long solve(long[] nums, long x){
		int n = nums.length;
		long sum = Arrays.stream(nums).sum();
		int j = 0;
		long ans = 0;
		
		for(int i = n - 1; i >= 0; i--){
			while(j < n && sum - nums[i] - nums[j] >= x)
				j++;
			ans += n - j;
		}
		
		for(int i = 0; i < n; i++){
			if(sum - nums[i] - nums[i] < x) 
				ans--;
		}
		
		return ans / 2;
	}
}