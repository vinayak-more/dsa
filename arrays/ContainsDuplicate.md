# Duplicate Integer

<h2 style="color: green">Easy</h2>

Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

> Example 1:
> 
> Input: nums = [1, 2, 3, 3]
>
> Output: true

>Example 2:
>
>Input: nums = [1, 2, 3, 4]
>
>Output: false


```
class Solution {
    public boolean hasDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for(int num : array){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
```