import java.util.*;
import java.util.stream.*;

//problem 2051 C
public class PreparingForExam{
	private static final char PASS = '1';
	private static final char FAIL = '0';

	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String[] result = new String[cases];
		int[] a, q;
		for(int j = 0; j < cases; j++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			a = new int[m];
			q = new int[k];
			for(int i = 0 ; i < m; i++) a[i] = sc.nextInt();
			for(int i = 0 ; i < k; i++) q[i] = sc.nextInt();
			result[j] = prepare(n, a, q);
		}

		Arrays.stream(result).forEach(System.out::println);
	}

	private static String prepare(int n, int[] m, int[] q){
		Set<Integer> set = Arrays.stream(q).boxed().collect(Collectors.toSet());
		if(set.size() == n ) return all(m.length, PASS);
		if(set.size() < n - 1) return all(m.length, FAIL);
		StringBuilder sb = new StringBuilder();
		for(int num : m){
			if(!set.contains(num)) sb.append(PASS);
			else sb.append(FAIL);
		}
		return sb.toString();
	}

	private static String all(int n, char ch){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++){
			sb.append(ch);
		}
		return sb.toString();
	}
	
	
}