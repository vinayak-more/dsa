import java.util.*;

public class A{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		long[] result = new long[cases];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int[][] a = new int[2][n];
			for(int i = 0; i < n; i++) a[0][i] = sc.nextInt();
			for(int i = 0; i < n; i++) a[1][i] = sc.nextInt();
			result[c] = solve(a, n);

		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static long solve(int[][] a, int n){
		long maxSum = 0;
		long sum = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++){
			maxSum += Math.max(a[0][i], a[1][i]);
		}
		for(int i = 0; i < n; i++){
			sum = Math.max(sum, maxSum + Math.min(a[0][i], a[1][i]));
		}
		return sum;
	}
}
