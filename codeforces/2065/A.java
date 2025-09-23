import java.util.*;

public class A{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String[] result = new String[cases];
		for(int c = 0; c < cases; c++){
			String str = sc.next();
			result[c] = solve(str);
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static String solve(String str){
		String sub = str.substring(0, str.length() - 2 );
		return sub + "i";
	}
}
