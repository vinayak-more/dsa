import java.util.*;

public class D{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String[] result = new String[cases];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[m];
			for(int i = 0 ; i < n; i++) a[i] = sc.nextInt();
			for(int i = 0 ; i < m; i++) b[i] = sc.nextInt();
			result[c]= solve(a, b);
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static String solve(int[] a, int[] b){
		Map<Integer, Integer> map = new HashMap<>();

		for(int num : a ) map.put(num, map.getOrDefault(num, 0) + 1 );
		for(int num : b ){
			if(!had(num, map)) return "No";
		}
		return map.isEmpty() ? "Yes" : "No";
	}

	private static boolean had(int num, Map<Integer, Integer> map){
		if( map.containsKey(num)){
			map.compute(num, (key, value) -> value == 1 ? null : value - 1);
			return true;
		}
		if(num <2){
			if(map.containsKey(num)){
				map.compute(num, (key, value) -> value == 1 ? null : value - 1);
			return true;
			}else{
				return false;
			}
		}
		if(num == 2){
			if(map.getOrDefault(1, 0) >= 2){
				map.compute(1, (k, v) -> v == 2 ? null : v - 2);
				return true;
			}
			else return false;
		}
		if(num % 2 == 0 ){
			return had(num / 2, map) && had(num / 2, map);
		}
		else return had(num / 2, map) && had(num / 2 + 1, map);
	}
}
