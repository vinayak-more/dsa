import java.util.*;
import java.util.regex.*;

public class SpreadSheets{

	private static final Pattern RC = Pattern.compile("^R\\d+C\\d+");
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String input;
		String[] result = new String[cases];
		for(int i = 0; i < cases; i++){
			result[i] = convert(sc.next());
		}
		Arrays.stream(result).forEach(System.out::println);
	}

	private static String convert(String line){
		if(RC.matcher(line).find()){
			int row = Integer.parseInt(line.substring(1, line.indexOf("C")));
			int col = Integer.parseInt(line.substring(line.indexOf("C") + 1));
			List<Integer> list = new ArrayList<>();
			while(col > 0){
				if(col  % 26 == 0 ){
					list.add( 26 );
					col /= 26;
					col--;
				} else {
					list.add(col % 26 );
					col = col / 26;
				}
			}
			//System.out.println(list);
			Integer[] nums = list.toArray(new Integer[0]);
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i < list.size(); i++){
				if(nums[i] == 0 && i != list.size() - 1){
					sb.append('Z');
					nums[i+1]--;
				} else if(nums[i] > 0) {
					sb.append((char)(nums[i] + 'A' - 1));
				}
			}
			sb.reverse();
			sb.append(row);
			return sb.toString();
		} else {
			int i = 0;
			StringBuilder sb = new StringBuilder();
			while(!Character.isDigit(line.charAt(i))){
				sb.append(line.charAt(i));
				i++;
			}
			sb.reverse();
			String col = sb.toString();
			long pow = 1;
			long colNum = 0;
			for(int j = 0 ; j < col.length(); j++){
				colNum += (col.charAt(j) - 'A' + 1) * pow;
				pow *= 26;
			}
			return "R" + line.substring(i) + "C" + colNum;
		}
	}
}
