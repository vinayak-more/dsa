import java.util.*;
import java.util.stream.*;

public class B{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		long[] result = new long[cases];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i < n; i++) a[i] = sc.nextInt();
			result[c] = solve(n, l, r, a );
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static long solve(int n, int l, int r, int[] a){
		int w = r - l + 1;
		long result = 0;
		if(n == w ){
			for(int i = 0; i < n; i++) result += a[i];
			return result;
		}
		long left = sumOfKMins(a, 0, r - 1, w );
		long right = sumOfKMins(a, l - 1, n - 1, w );
		return Math.min(left, right);
	}

	private static long sumOfKMins(int[] a, int l, int r, int k){ //l and r inclusive
		Queue<Integer> pq = new PriorityQueue<Integer>((x, y) -> y - x);
		long result = 0;
		for(int i = l; i <= r; i++){
			pq.offer(a[i]);
			if(pq.size() > k ) pq.poll();
		}
		while(!pq.isEmpty()){
			result += pq.poll();
		}
		return result;
	}
}
