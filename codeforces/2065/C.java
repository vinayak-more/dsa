
import java.util.*;

public class C {

    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        String[] result = new String[cases];
        for (int c = 0; c < cases; c++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            m = sc.nextInt();
            result[c] = solve(nums, n, m);
        }
        Arrays.stream(result).forEach(System.out::println);
    }

    private static String solve(int[] nums, int n, int m) {
        if (n == 1) {
            return YES;
        }
        if (nums[0] > m / 2) {
            nums[0] = m - nums[0];
        }
        for (int i = 1; i < n - 1; i++) {
            if(nums[i] == nums[i - 1]) continue;
            if(nums[i] > nums[i - 1]){
                if(m < 2 * nums[i] && m >= nums[i - 1] + nums[i] ) nums[i] = m - nums[i];
            } else {
                if(m >= nums[i - 1] + nums[i]) nums[i] = m - nums[i];
                else return NO;
            }

        }
        if (nums[n - 1] < m / 2) {
            nums[n - 1] = m - nums[n - 1];
        }
        //System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n - 1; i++) {
            if(nums[i] <= nums[i+1]) continue;
            return NO;
        }
        return YES;
    }
}
