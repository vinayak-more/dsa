import java.util.*;

public class DigitalStringMaximization{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] result = new String[n];
		for(int i = 0; i < n; i++){
			result[i]= maximize(sc.next());
		}
		Arrays.stream(result).forEach(System.out::println);
	}
	
	private static String maximize(String str){
		char[] chars = str.toCharArray();
		for(int i = 1; i < str.length(); i++){
			for(int j = i; j >= 1; j--){
				if(chars[j] - chars[j-1] > 1){
					char temp = chars[j];
					chars[j] = chars[j - 1];
					chars[j - 1] = (char)(temp - 1);
				} else break;
			}
				
		}
		return new String(chars);
	}
		
	
}

/*
i = 1 51476
i = 2 53176
i = 3 53616 55316
I = 4 55316
i = 5 55351 55431
19


*/
