import java.util.*;


public class GameOfMathletes{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int[] result = new int[cases];
        for(int c = 0; c < cases; c++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0 ; i < n; i++) nums[i] = sc.nextInt();
            result[c] = solve(n, k, nums);
        }
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int solve(int n, int k, int[] nums){
        Arrays.sort(nums);
        int i = 0, j = n - 1, sum, count = 0;
        while(i < j){
            sum = nums[i] + nums[j];
            if(sum == k){
                count++;
                i++;
                j--;
            } else if(sum > k) j--;
            else i++;
        }
        return count;
    }


}