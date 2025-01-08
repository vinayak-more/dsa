import java.util.*;

//Problem 2050 C
public class UninterestingNumber{
	private static final String YES = "YES";
	private static final String NO = "NO";
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String[] result = new String[cases];
		for(int i = 0; i < cases; i++){
			result[i] = isInteresting(sc.next());
		}
		Arrays.stream(result).forEach(System.out::println);
	}
	
	private static String isInteresting(String str){
		int sum = 0, threes = 0, twos = 0, num;
		for(int i = 0 ; i < str.length(); i++){
			num = (int)(str.charAt(i) - '0');
			sum += num;
			if(num  == 2 ) twos++;
			else if(num == 3) threes++;
		}
		int remainder = sum % 9;
		if(remainder == 0) return YES;
		
		for(int i = 0; i <= twos; i++){
			for(int j = 0; j <= threes; j++){
				if((remainder + i * 2 + j * 6) % 9 == 0) return "YES";
			}
		}
		return "NO";	
		
	}

}