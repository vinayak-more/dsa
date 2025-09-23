import java.util.*;
import java.util.stream.*;

public class A{

	private static final String YES = "YES";
	private static final String NO = "NO";
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String[] result = new String[cases];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			for(int i = 0; i < n; i++) a[i] = sc.nextInt();
			for(int i = 0; i < n; i++) b[i] = sc.nextInt();
			result[c] = solve(a, b);
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static String solve(int[] a, int[] b){
		Set<Integer> setA = Arrays.stream(a).boxed().collect(Collectors.toSet());
		Set<Integer> setB = Arrays.stream(b).boxed().collect(Collectors.toSet());
		return setA.size() + setB.size() > 3 ? YES : NO;
	}


}
class Pair implements Comparable<Pair>{

	int a, b;

	Pair(int a, int b){
		this.a = Math.min(a, b);
		this.b = Math.max(a, b);
	}

	public int compareTo(Pair o){
		return this.a == o.a ? this.b - o.b : this.a - o.a; 
	}
}
