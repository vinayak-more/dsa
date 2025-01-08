import java.util.*;
import java.util.stream.*;

//problem 2048 C
public class BinaryStrings{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[][] result = new int[cases][];
		for(int k = 0; k < cases; k++){
			result[k] = binaryStrings(sc.next());
		}
		for(int k = 0; k < cases; k++){
			Arrays.stream(result[k]).forEach(i -> System.out.print(i + " "));
			System.out.println();
		}
	}

	private static int[] binaryStrings(String str){
		int n = str.length();
		int k = str.indexOf("0");
		if( k == -1) return new int[] {1, 1, 1, n};
		int w = n - k;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < w - 1; i++){
			sb.append(str.charAt(i));
		}
		String diff = str.substring(k, n);
		String max = "0", temp;
		int[] result = new int[2];
		int i = 0, j = w - 1;
		while( j < n){
			sb.append(str.charAt(j));
			temp = xor(diff, sb.toString());
			if(temp.compareTo(max) > 0){
				max = temp;
				result[0] = i;
				result[1] = j;
			}
			//System.out.println(String.format("temp = %s, max = %s", temp, max));
			sb.deleteCharAt(0);
			i++;
			j++;
			/*while(str.charAt(i) == '0' && j < n){
				sb.deleteCharAt(0);
				sb.append(str.charAt(j));
				i++;
				j++;
			}*/
		}
		return new int[]{1, n, result[0] + 1, result[1] + 1};
	}
	
	private static String xor(String a, String b){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < a.length(); i++){
			if(a.charAt(i) == b.charAt(i)){
				sb.append("0");
			} else {
				sb.append("1");
			}
		}
		return sb.toString();
	} 
}