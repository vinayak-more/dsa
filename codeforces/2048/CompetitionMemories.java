import java.util.*;
import java.util.stream.*;

//Problem 2048 D
public class CompetitionMemories{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[][] result = new int[cases][];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[m];
			for(int i = 0; i < n; i++) a[i] = sc.nextInt();
			for(int i = 0; i < m; i++) b[i] = sc.nextInt();
			result[c] = solve(a, b);
		}

		for(int i = 0 ; i < cases; i++){
			Arrays.stream(result[i]).forEach(ele -> System.out.print(ele + " "));
			System.out.println();
		}
	}
	
	public static int[] solve(int[] candidates, int[] problems){
		int n = candidates.length;
		int m = problems.length;
		int kevin = candidates[0];
		int[] rank = new int[m];
		Arrays.sort(candidates);
		for(int i = 0; i < m; i++){
			if(problems[i] <= kevin) rank[i] = 0;
			else rank[i] = n - binarySearch(candidates, problems[i]);
		}
		Arrays.sort(rank);
		int[] result = new int[m];
		for(int i = 1; i <= m; i++){
			int sum = 0;
			for(int k = i - 1; k < m; k+= i){
				sum += rank[k] + 1;
			}
			result[i - 1] = sum;
		}
		return result;
	} 
	
	private static int binarySearch(int[] nums, int target){
		int left = 0, right = nums.length - 1, mid;
		while(left <= right){
			mid = left + (right - left)/2;
			if(nums[mid] == target) return mid;
			if(nums[mid] < target) left = mid + 1;
			else right = mid - 1;
		}
		return left;
	}
}