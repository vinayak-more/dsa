import java.util.*;

public class B{
	private static final String YES = "YES";
	private static final String NO = "NO";

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String[] result = new String[cases];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int[] nums = new int[n];
			for(int i = 0 ; i < n; i++) nums[i] = sc.nextInt();
			result[c] = solve(nums);
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static String solve(int[] nums){
		for(int i = 0; i < nums.length; i++){
			if(Math.max(i, nums.length - 1 - i ) >= nums[i]/(double)2) return NO;
		}

		return YES;
	}
}
