import java.util.*;


public class SubtractMinSort{

    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        String[] result = new String[cases];
        for(int c = 0 ; c < cases; c++){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0 ; i < n; i++) nums[i] = sc.nextInt(); 
            result[c] = solve(nums);
        } 
        Arrays.stream(result).forEach(System.out::println);
    }

    private static String solve(int[] nums){
        
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]) return NO;
            int min = Math.min(nums[i], nums[i]+1);
            nums[i] -= min;
            nums[i+1] -= min;
        }
        return YES;
    }
}