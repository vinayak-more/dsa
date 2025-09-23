import java.util.*;

public class B{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];
		for(int c = 0; c < cases; c++){
			String str = sc.next();
			result[c] = solve(str);
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static int solve(String str){
		for (int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i+ 1)) return 1;
        }
        return str.length();
	}
}
