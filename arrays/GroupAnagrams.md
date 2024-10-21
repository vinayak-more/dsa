# Anagram Groups
## Medium 
Given an array of strings `strs`, group all **anagrams** together into sublists. You may return the output in any order.

An **anagram** is a string that contains the exact same characters as another string, but the order of the characters can be different.

>Example 1:
>
>Input: strs = ["act","pots","tops","cat","stop","hat"]
>
>Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

>Example 2:
>
>Input: strs = ["x"]
>
>Output: [["x"]]

>Example 3:
>
>Input: strs = [""]
>
>Output: [[""]]

### Constraints:

`1 <= strs.length <= 1000`

`0 <= strs[i].length <= 100`

`strs[i] is made up of lowercase English letters.`

### Code:
```
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        char[] chars;
        String key;
        for (String str : strs) {
            chars = str.toCharArray();
            Arrays.sort(chars);
            key = new String(chars);
            map.putIfAbsent(key, new LinkedList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
```