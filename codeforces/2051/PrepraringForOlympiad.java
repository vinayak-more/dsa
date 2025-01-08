import java.util.*;

//Problem 2051 A
public class PrepraringForOlympiad{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int n;
		int[] a, b;
		int[] result = new int[cases];
		for(int k = 0; k < cases; k++){
			n = sc.nextInt();
			a = new int[n];
			b = new int[n];
			for(int i = 0; i < n; i++) a[i] = sc.nextInt();
			for(int i = 0; i < n; i++) b[i] = sc.nextInt();
			result[k] = olympiad(a, b);
		}
		Arrays.stream(result).forEach(System.out::println);
	}
	
	private static int olympiad(int[] a, int[] b){
		int n = a.length;
		int sum = a[n - 1];
		for(int i = 0; i < n - 1; i++){
			sum += Math.max(0, a[i] - b[i+1]);
		}
		return sum;
	}
}