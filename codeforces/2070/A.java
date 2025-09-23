import java.util.*;

public class A{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];
		for(int c = 0; c < cases; c++){
			result[c] = solve(sc.nextInt());
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static int solve(int n){
		int result = 3 * (n / 15);
		n = n % 15;
		for(int i = 0; i < n + 1; i++){
			if(i % 3 == i % 5 ) result++;
		}
		return result;
	}
}
