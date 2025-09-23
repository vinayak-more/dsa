import java.util.*;

public class A{

	private static final String YES = "YES";
	private static final String NO = "NO";

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String[] result = new String[cases];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int[] nums = new int[n-2];
			for(int i = 0; i < n - 2; i++){
				nums[i] = sc.nextInt();
			}
			result[c] = solve(nums);
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static String solve(int[] nums){
		int zeroCount = nums[0] == 0 ? 1 : 0;

		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 0 ){
				zeroCount++;
			} else {
				if(zeroCount == 1 ) return NO;
				else zeroCount = 0;
			}
		}
		return YES;
	}
}
