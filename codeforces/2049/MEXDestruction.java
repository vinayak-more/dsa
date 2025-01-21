import java.util.*;

public class MEXDestruction{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++){
				nums[i] = sc.nextInt();
			}
			result[c] = solve(nums);
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	public static int solve(int[] nums){
		int zeroCount = 0;

		for( int num : nums ){
			if(num == 0 ) zeroCount++;
		}
		if(zeroCount == 0 ) return 1;
		if(zeroCount == nums.length) return 0;
		int lead = leadingZeros(nums);
		if(lead == zeroCount) return 1;
		int tail = tailingZeros(nums);
		if(tail == zeroCount) return 1;
		if(lead + tail == zeroCount) return 1;
		return 2;
	}

	private static int leadingZeros(int[] nums){
		int lead = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 0 && lead == i) lead++;
			else break;
		}
		return lead;
	}

	private static int tailingZeros(int[] nums){
		int tail = 0;
		for(int i = nums.length - 1; i >= 0; i--){
			if(nums[i] == 0 && nums.length - 1 - tail == i ) tail++;
			else break;
		}
		return tail;
	}


}



