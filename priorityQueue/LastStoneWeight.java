import java.util.*;

public class LastStoneWeight{
	public int lastStoneWeight(int[] stones) {
       		Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
       		for(int stone : stones){
            		queue.offer(stone);
       		}
       		while(queue.size() > 1){
            		queue.offer(Math.abs(queue.poll() - queue.poll()));
       		}
       	return queue.poll();
    	}
}