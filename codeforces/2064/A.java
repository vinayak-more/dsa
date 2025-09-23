import java.util.*;

public class A{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];
		for(int c = 0; c < cases; c++){
            int n = sc.nextInt();
			String str = sc.next();
			result[c] = solve(str);
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static int solve(String str){
		char bit = '0';
        int result = 0;
        for(int i = 0; i < str.length(); i++){
            if(bit != str.charAt(i)){
                bit = str.charAt(i);
                result++;
            }
        }
        return result;
	}
}
