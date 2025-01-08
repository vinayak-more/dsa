import java.util.*;

public class Football{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String players = sc.next();
		char cur = '2';
		int count = 0;
		for(int i = 0; i < players.length(); i++){
			if(cur == players.charAt(i)){
				count++;
			} else {
				cur = players.charAt(i);
				count = 1;
			}
			if(count == 7){
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}
}