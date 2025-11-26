import java.util.*;

public class A{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];
		for(int i = 0; i < cases; i++){
			int k = sc.nextInt();
			int x = sc.nextInt();
			result[i] = solve(k, x);
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static int solve(int k, int x){
		while(k-- > 0){
			
				x = x * 2;
			
		}
		return x;
	}

}
