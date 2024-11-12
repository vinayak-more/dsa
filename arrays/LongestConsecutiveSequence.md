# Longest Consecutive Sequence
## Medium
Given an array of integers `nums`, return the length of the longest consecutive sequence of elements.

A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element.

You must write an algorithm that runs in $$O(n)$$ time.

>Example 1:
>
>Input: nums = [2,20,4,10,3,4,5]
>
>Output: 4
>Explanation: The longest consecutive sequence is [2, 3, 4, 5].

>Example 2:
>
>Input: nums = [0,3,2,5,4,6,1,1]
>
>Output: 7

### Constraints:

`0 <= nums.length <= 1000`

`-10^9 <= nums[i] <= 10^9`

### Code

```java
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
```