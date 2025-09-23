import java.util.*;

public class DailyTemperatures{
	public int[] dailyTemperatures(int[] temperatures){
		Deque<Integer> stack = new LinkedList<>();
		int[] result = new int[temperatures.length];
		for(int i = temperatures.length - 1; i >= 0; i--){
			while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop();
			if(stack.isEmpty()) result[i] = 0;
			else result[i] = stack.peek() - i;
			stack.push(i);
		}
		return result;
	}
}
// 30 38 30 36 35 40 28
// i = 6 r = [0] s = 6
// i = 5 r = [0, 0] s = 5
// i = 4 r = [1, 0, 0] s = 4 5
// i = 3 r = [2, 1, 0 , 0] s = 3 5
// i = 2 r = [1, 2, 1, 0, 0] s = 2 3 5
// i = 1 r = [4, 1, 2, 1, 0, 0] s = 1 5
// i = 0 r = [1, 4, 1, 2, 1, 0, 0] 