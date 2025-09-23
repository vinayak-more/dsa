import java.util.*;

public class D{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[][] result = new int[cases][];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i < n; i++) a[i] = sc.nextInt();
			result[c] = solve(a, n);
		}

		for(int c = 0; c < cases; c++){
			Arrays.stream(result[c]).forEach(i -> System.out.print(i + " "));
			System.out.println();
		}
	}

	public static int[] solve(int[] a, int n){
		int[] result = new int[n];
		int count = 1;
		Set<Integer> set = new HashSet<>();
		Set<Integer> used = new HashSet<>();
		for(int i = 0; i < n; i++){
			used.add(a[i]);
		}
		for(int i = 0; i < n; i++){
			if(!set.contains(a[i])){
				set.add(a[i]);
				result[i] = a[i];
			} else {
				while(used.contains(count)) count++;
				result[i] = count++;
			}
		}
		return result;

	}
}
