import java.util.*;

public class LongestRepeatingSubstringWithReplacement{
	public int characterReplacement(String s, int k) {
        	int[] freq = new int[26];
		int start = 0, end = start, max = 0;
		while(end < s.length()){
			freq[s.charAt(end) - 'A']++;
			while(!validWindow(freq, k)){
				freq[s.charAt(start) - 'A']--;
				start++;
			}
			max = Math.max(max, end - start + 1);
			end++;
		}
		return max;
	}

	private boolean validWindow(int[] freq, int k){
		int max = 0, sum = 0;
		for(int i = 0; i < freq.length; i++){
			sum += freq[i];
			max = Math.max(max, freq[i]);
		}
		return (sum - max) <= k;
	}
}
//AAABABB k = 1
// start = 0 , end = 0  A = 1
// start = 0, end = 1 A = 2
//start = 0, end = 2 A = 3
//start = 0, end = 3 A = 3, B = 1
// start = 0, end = 4 A = 4, B = 1 window = 5
// start = 0, end = 5 A = 4, B = 2 	
// start = 1, end = 5 A = 3, B = 2
// start = 2, end = 5, A = 2, B = 2
// start = 3, end = 5, A = 1, B = 2 window = 3
// start = 3, end = 6, A = 1, B = 3 window = 4