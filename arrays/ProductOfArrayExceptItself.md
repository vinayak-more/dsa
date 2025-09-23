# Products of Array Discluding Self
## Medium 
Given an integer array `nums`, return an array `output` where `output[i]` is the product of all the elements of nums except `nums[i]`.

Each product is guaranteed to fit in a 32-bit integer.

Follow-up: Could you solve it in $O(n)$ time without using the division operation?

>Example 1:
>
>Input: nums = [1,2,4,6]
>
>Output: [48,24,12,8]

>Example 2:
>
>Input: nums = [-1,0,1,2,3]
>
>Output: [0,-6,0,0,0]

### Constraints:

`2 <= nums.length <= 1000`

`-20 <= nums[i] <= 20`

### Code
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i] * left[i - 1];
        }

        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i] * right[i + 1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = right[i + 1];
            } else if (i == nums.length - 1) {
                result[i] = left[i - 1];
            } else {
                result[i] = left[i - 1] * right[i + 1];
            }
        }
        return result;
    }
}

```