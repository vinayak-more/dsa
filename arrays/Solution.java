import java.util.*;

class Solution{
    public int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longest = 0;
        int length = 0;
        for(int num : nums){
            if(!set.contains(num - 1)){
                length = 1;
                while(set.contains(num + length)){
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        assert solution.longestConsecutive(new int[]{2,20,4,10,3,4,5}) == 4;
        assert solution.longestConsecutive(new int[]{0,3,2,5,4,6,1,1}) == 7;
    }
}