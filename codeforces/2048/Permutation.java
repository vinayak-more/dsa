import java.util.*;

//Problem 2048 B
public class Permutation{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int n, k;
		int[][] result = new int[cases][];
		for(int c = 0; c < cases; c++){
			n = sc.nextInt();
			k = sc.nextInt();
			result[c] = permute(n, k);
		}
		for(int i = 0; i < cases; i++){
			Arrays.stream(result[i]).forEach(ele -> System.out.print(ele + " "));
		}
	}
	
	private static int[] permute(int n, int k){
		int[] result = new int[n];
		int count = 1;
		for(int i = k - 1; i < n; i += k){
			result[i] = count++;
		}
		if(count > n) return result;

		for(int i = 0; i < n; i++){
			if(result[i] == 0){
				result[i] = count++;
			}
		}
		return result;
	}
}