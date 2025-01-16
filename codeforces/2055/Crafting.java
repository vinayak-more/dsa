import java.util.*;

public class Crafting{

	private static final String YES = "YES";
	private static final String NO = "NO";

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String[] result = new String[cases];
		int n;
		int[] a, b;
		for(int c = 0; c < cases; c++){
			n = sc.nextInt();
			a = new int[n];
			b = new int[n];
			for(int i = 0; i < n; i++) a[i] = sc.nextInt();
			for(int i = 0; i < n; i++) b[i] = sc.nextInt();
			result[c] = solve(a, b);
		}
		Arrays.stream(result).forEach(System.out::println);

	}
	
	private static String solve(int[] a, int[] b){
		int n = a.length;
		int[] diff = new int[n];
		int negCount = 0;
		int negValue = 0;
		for(int i = 0 ; i < n; i++){
			diff[i] = a[i] - b[i];
			if(diff[i] < 0 ) { 
				negCount++;
				negValue = diff[i];
			}
			if(negCount > 1 ) return NO;
		}
		if(negCount == 0 ) return YES;
		for(int i = 0 ; i < n; i++){
			if(diff[i] >= 0 && negValue + diff[i] < 0 ) return NO;
		}
		return YES;


	}
}