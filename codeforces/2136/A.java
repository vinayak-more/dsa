import java.util.*;

public class A{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String[] result = new String[cases];
		for(int c = 0; c < cases; c++){
			result[c] = solve(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static String solve(int a, int b, int c, int d){
		if(isPossible(a, b) && isPossible(c - a, d - b)) return "YES";
		return "NO";
	}

	private static boolean isPossible(int a, int b){
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		if(max % 2 == 0 && ( max/2 - 1 ) <= min) return true;
	       	if(max % 2 == 1 && ((max - 1)/ 2 ) <= min) return true;
		return false;	
	}
}
