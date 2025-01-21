import java.util.*;


public class B{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[][] result = new int[cases][];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++) nums[i] = sc.nextInt();
			result[c] = solve(nums);
		}
		for(int i = 0; i < cases; i++){
			Arrays.stream(result[i]).forEach(ele -> System.out.print(ele + " "));
			System.out.println();
		}
	}

	private static int[] solve(int[] nums){
	
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums ){
			map.compute(num, (key, value) -> value == null ? 1 : value + 1);
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((a, b)-> b.getValue() - a.getValue());

		if(list.get(0).getValue() == 1 ) return new int[]{-1};
		if(list.get(0).getValue() >= 4 ) return new int[]{list.get(0).getKey(), list.get(0).getKey(), list.get(0).getKey(), list.get(0).getKey()};
		if(list.get(0).getValue() >= 2 && list.get(1).getValue() >= 2 ) return new int[]{list.get(0).getKey(), list.get(0).getKey(), list.get(1).getKey(), list.get(1).getKey()};
		Arrays.sort(nums);
		int a = list.get(0).getKey();
		int index = Arrays.binarySearch(nums, a);
		nums[index] = 0;
		Arrays.sort(nums);
		index = Arrays.binarySearch(nums, a);
		nums[index] = 0;
		Arrays.sort(nums);
		for(int i = 2; i < nums.length - 1; i++){
			if(nums[i] + 2 * a > nums[i+1]) return new int[]{a, a, nums[i], nums[i+1]};
		}
		return new int[]{-1};
	}
}
