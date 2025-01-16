import java.util.*;

public class TwoFrogs{

	private static final String YES = "YES";
	private static final String NO = "NO";

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String[] result = new String[cases];
		int n, a, b;
		for(int c = 0; c < cases; c++){
			n = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			result[c] = Math.abs(a-b)%2 == 0 ? YES : NO;
		}
		Arrays.stream(result).forEach(System.out::println);
	}
}