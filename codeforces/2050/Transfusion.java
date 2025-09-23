import java.util.*;

//Problem 2050 B
public class Transfusion{
	private static final String YES = "YES";
	private static final String NO = "NO";
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int n;
		int[] nums;
		String[] result = new String[cases];
		for(int i = 0; i < cases; i++){
			n = sc.nextInt();
			nums = new int[n];
			for(int j = 0; j < n; j++){
				nums[j] = sc.nextInt();
			}
			result[i] = transfuse(nums);
		}
	
		Arrays.stream(result).forEach(System.out::println);
	}
	
	private static String transfuse(int[] nums){
		int n = nums.length;
		long oddSum = 0, oddCount = 0;
		for(int i = 1; i < n; i+= 2){
			oddSum += nums[i];
			oddCount++;
		}
		if(oddSum % oddCount != 0 ) return NO;
	
		long evenSum = 0, evenCount = 0;
		for(int i = 0; i < n; i+= 2){
			evenSum += nums[i];
			evenCount++;
		}
		if(evenSum % evenCount != 0 ) return NO;
		
		if(evenSum / evenCount == oddSum / oddCount ) return YES;
		else return NO;
	}
}