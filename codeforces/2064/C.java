
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int[] result = new int[cases];
        for (int c = 0; c < cases; c++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            result[c] = solve(nums);
        }
        Arrays.stream(result).forEach(System.out::println);

    }

    private static int solve(int[] nums) {
        int n = nums.length;
        int cost = 0;
        Queue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                pq.offer(new Pair(nums[i], i, cost));
            }
            cost += Math.abs(nums[i]);
        }
        cost = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < 0) {
                pq.offer(new Pair(nums[i], i, cost));
            }
            cost += Math.abs(nums[i]);
        }
        int left = -1, right = n;
        int score = 0;
        //System.out.println(pq);
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if (left < pair.index && pair.index < right) {
                score += Math.abs(pair.element);
                if (pair.element < 0) {
                    right = pair.index;
                } else {
                    left = pair.index;
                }
            }
        }
        return score;
    }
}

class Pair implements Comparable<Pair> {

    int element;
    int index;
    int cost;

    Pair(int e, int i, int c) {
        this.element = e;
        this.index = i;
        this.cost = c;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.cost == o.cost) {
            if (this.element > 0 && o.element > 0) {
                return this.index - o.index;
            } else if (this.element < 0 && o.element < 0) {
                return o.index - this.index;
            }
        }
        return this.cost - o.cost;
    }

    public String toString() {
        return String.format("{element:%d, index: %d, cost:%d}", element, index, cost);
    }

}
