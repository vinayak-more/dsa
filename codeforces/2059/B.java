import java.util.*;

public class B{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n];
			for(int i =0; i < n; i++) a[i] = sc.nextInt();
			result[c] = solve(n, k, a);
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static int solve(int n , int k, int[] a){
//		Arrays.sort(a);
		int i = n - k + 1;
		int count = 1;
		while(i < n ){
			if(a[i] != count ) return count;
		       	i+= 2;
			count++;
		}
		return count;
	}
}
