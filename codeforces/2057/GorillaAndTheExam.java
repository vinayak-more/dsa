import java.util.*;

//problem 2057 B

public class GorillaAndTheExam{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];
		int n, k;
		int[] nums;
		for(int c = 0; c < cases; c++){
			n = sc.nextInt();
			k = sc.nextInt();
			nums = new int[n];
			for(int i = 0 ; i < n; i++) nums[i] = sc.nextInt();
			result[c] = solve(nums, k);
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static int solve(int[] nums, int k){
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums){
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		LinkedList<Integer> list = new LinkedList<>(map.values());
		Collections.sort(list);
		while(list.size() > 1 && k >= list.getFirst() ){
			k -= list.getFirst();
			list.removeFirst();
		}
		return list.size();
	}
}
