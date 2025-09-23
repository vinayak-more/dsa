import java.util.*;

public class C{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		long[] result = new long[cases];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			long[] nums = new long[n];
			for(int i = 0; i < n; i++) nums[i] = sc.nextLong(); 
			result[c] = solve(nums, n);
		}
		Arrays.stream(result).forEach(System.out::println);

	}

	private static long solve(long[] nums, int n){
	
		long sum = sum(nums, n);
		while( n > 1 ){
			operate(nums, n);
			sum = Math.max(sum, Math.abs(sum(nums, n - 1)));
			n--;
		}
		return sum;
	}


	private static long sum(long[] nums, int n){
		long sum = 0;
		while( n-- > 0 ){
			sum += nums[n];
		}
		return sum;
	}

	private static void operate(long[] nums, int n){
	
		for(int i = 0; i < n - 1; i++){
			nums[i] = nums[i+1] - nums[i];
		}
	}
}
