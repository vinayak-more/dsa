# Top K Elements in List
## Medium 
Given an integer array `nums` and an integer `k`, return the `k` most frequent elements within the array.

The test cases are generated such that the answer is always unique.

You may return the output in any order.

>Example 1:
>
>Input: nums = [1,2,2,3,3,3], k = 2
>
>Output: [2,3]

>Example 2:
>
>Input: nums = [7,7], k = 1
>
>Output: [7]
### Constraints:

`1 <= nums.length <= 10^4.`

`-1000 <= nums[i] <= 1000`

`1 <= k <= number of distinct elements in nums.`


### Code:
```java
import java.util.Collection;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Item> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, new Item(num, 0));
            map.get(num).freq += 1;
        }
        Collection<Item> items = map.values();
        Queue<Item> queue = new PriorityQueue<>();
        for (Item item : items) {
            queue.offer(item);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        int counter = 0;
        while (!queue.isEmpty()) {
            result[counter++] = queue.poll().value;
        }
        return result;
    }
}

class Item implements Comparable<Item> {
    int freq;
    int value;

    Item(int value, int freq) {
        this.value = value;
        this.freq = freq;
    }

    public int compareTo(Item other) {
        return this.freq - other.freq;
    }
}
```