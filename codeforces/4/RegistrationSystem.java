import java.util.*;

//Problem 4 C
public class RegistrationSystem{
	private static final String OK = "OK";

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] input = new String[n];
		for(int i = 0; i < n; i++){
			input[i] = sc.next();
		}
		String[] result = register(input);
		Arrays.stream(result).forEach(System.out::println);
	}

	private static final String[] register(String[] names){
		Map<String, Integer> map = new HashMap<>();
		String[] result = new String[names.length];
		int counter;
		for(int i = 0; i < names.length; i++){
			if(map.containsKey(names[i])){
				counter = map.get(names[i]);
				result[i] = names[i] + counter;
				map.put(names[i], counter + 1);
			} else {
				result[i] = OK;
				map.put(names[i], 1);
			}
		}
		return result;
	}
}