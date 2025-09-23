import java.util.*;

public class BewitchingStargazer{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		long[] result = new long[cases];
		long n, k;
		for(int i = 0 ; i < cases; i++){
			n = sc.nextLong();
			k = sc.nextLong();
			result[i] = solve(1, n, k);
		}
		Arrays.stream(result).forEach(System.out::println);
	}
	
	private static long solve(long l, long r, long k){
		if( k == 1) return (r * (r + 1)) / 2;
		if((r - l + 1) < k ) return 0;
		long m = l + (r - l)/2;
		if((r - l + 1) % 2 == 0 ){
			return solve(l, m , k) + solve(m + 1, r, k);
		}
		else {
			return m + solve(l, m - 1, k) + solve(m + 1, r, k);
		} 
	}
}