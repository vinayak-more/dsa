# Is Anagram
## Easy 

Given two strings `s` and `t`, return `true` if the two strings are **anagrams** of each other, otherwise return `false`.

An **anagram** is a string that contains the exact same characters as another string, but the order of the characters can be different.

>Example 1:
>
>Input: s = "racecar", t = "carrace"
>
>Output: true

>Example 2:
>
>Input: s = "jar", t = "jam"
>
>Output: false

### Constraints:

`s` and `t` consist of lowercase English letters.

### Code

```java
import static java.util.*;
class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> freq = new HashMap<>();
        for (char character : s.toCharArray()) {
            freq.put(character, freq.getOrDefault(character, 0) + 1);
        }
        for (char character : t.toCharArray()) {
            if (!freq.containsKey(character)) {
                return false;
            }
            freq.compute(character, (key, value) -> value == 1 ? null : value - 1);
        }
        return freq.isEmpty();
    }
}
```