import java.util.*;

//Problem 2050 A
public class LineBreaks{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];
		int n, m;
		for(int j = 0; j < cases; j++){
			n = sc.nextInt();
			m = sc.nextInt();
			String[] words = new String[n];
			for(int i = 0; i < n; i++){
				words[i] = sc.next();
			}
			result[j] = lineBreaks(words, m);
		}
		for(int i = 0; i < cases; i++){
			System.out.println(result[i]);
		}
	}
	
	private static int lineBreaks(String[] words, int m){
		int count = 0;
		while( count < words.length && m - words[count].length() >= 0 ){
			m -= words[count].length();
			count++;
		}
		return count;
	}
}