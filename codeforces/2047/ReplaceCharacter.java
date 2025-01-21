import java.util.*;

public class ReplaceCharacter{
	private static final int[] freq = new int[26];
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String[] result = new String[cases];
		for(int c = 0 ; c < cases; c++){
			int n = sc.nextInt();
			String str = sc.next();
			result[c] = solve(str.toCharArray(), n);
		}
		Arrays.stream(result).forEach(System.out::println);
	}


	private static String solve(char[] chars, int n){
		Arrays.fill(freq, 0);
		for(int i = 0 ; i < n; i++){
			freq[chars[i] - 'a']++;
		}
		int ch = 0, max = 0;
		for(int i = 0; i < 26; i++){
			if(max < freq[i]){
				max = freq[i];
				ch = i;
			}
		}
		for(int i = 0; i < n; i++){
			if(chars[i] != (ch + 'a') ){
				chars[i] = (char) (ch + 'a');
				break;
			}
		}
		return new String(chars);
	}
}
