import java.util.*;

public class A{

	private static final String YES = "YES";
	private static final String NO = "NO";

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String[] result = new String[cases];
		for(int c = 0; c < cases; c++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			result[c] = solve(x, y);
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static String solve(int x, int y){
		if(y - x == 1 ) return YES;
		if((x - y + 1) / 9 > 0 && (x - y + 1) % 9 == 0 ) return YES;
		return NO;
	}
}
