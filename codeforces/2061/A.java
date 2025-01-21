import java.util.*;

public class A{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++) nums[i] = sc.nextInt();
			result[c] = solve(nums);
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static int solve(int[] nums){
		int oddCount = 0, evenCount = 0;
		for(int num : nums){
			if(num % 2 == 0 ) evenCount++;
			else oddCount++;
		}
		if(oddCount == 0 ) return 1;
		if(evenCount == 0 ) return oddCount - 1;
		return 1 + oddCount;
	}
}
