import java.util.*;

public class BestTimeToBuySellStock{
	public int maxProfit(int[] prices){
		int buyPrice = prices[0], max = 0, profit = 0;
		for(int i = 1; i < prices.length; i++){		
			profit = prices[i] - buyPrice;
			max = Math.max(max, profit);
			buyPrice = Math.min(buyPrice, prices[i]); 
		}
		return max;
	}
}
//10 1 5 6 7 1
// b = 10 m = 0
//i = 1 p = -9 m = 0 b = 1
//i = 2 p = 4 m = 4 b = 1
//i = 3 p = 5 m = 5 b = 1
//i = 4 p = 6 m = 6 b = 1
//i = 5 p = 0 m = 6 b = 1
