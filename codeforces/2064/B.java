import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class B{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[][] result = new int[cases][];
		for(int c = 0; c < cases; c++){
            int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			result[c] = solve(nums);
		}
		for(int[] r : result){
			Arrays.stream(r).forEach(i -> System.out.print(i + " "));
			System.out.println();
		}

	}

	private static int[] solve(int[] nums){
		Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		int uniq = map.size();
		int n = nums.length;
		int score = n - uniq;
		int window = 0;
		int i = 0, j = 0;
		int x = 0, y = 0;
		int curScore, curWindow;
		while(j < nums.length){
			map.put(nums[j], map.get(nums[j]) - 1);
			if(map.get(nums[j]) == 0) uniq--;
			curWindow = j - i + 1;
			curScore = (n - curWindow) - uniq;

			if(curScore >= score && curWindow > window){
				window = curWindow;
				score = curScore;
				x = i + 1;
				y = j + 1;
			}
			if(curScore < score){
				if(map.get(nums[i]) == 0) uniq++;
				map.put(nums[i], map.get(nums[i]) + 1);
				i++;
			}
			j++;
		}
		return x == 0 ? new int[]{0} : new int[]{x, y};
		
	}
}
