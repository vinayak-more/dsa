import java.util.*;

//Problem 2051 B
public class Journey{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];
		int n;
		int[] a = new int[3];
		for(int k = 0; k < cases; k++){
			n = sc.nextInt();
			for(int i = 0 ; i < a.length; i++) a[i] = sc.nextInt();
			result[k] = journey(n, a);
		}
		Arrays.stream(result).forEach(System.out::println);
	}
	
	private static int journey(int n, int[] nums){
		int sum = Arrays.stream(nums).sum();
		int days = (n / sum) * 3;
		int remain = n % sum;
		int count = 0;
		while(remain > 0){
			remain -= nums[count++];
			days++;
		}
		return days;
	}
}