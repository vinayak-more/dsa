public class KokoEatingBananas{
	public int minEatingSpeed(int[] piles, int h) {
		int left = 1, right = piles[0], mid, hours;
        	for(int pile : piles){
			right = Math.max(right, pile);
		}
		int ans = right;
		while(left <= right){
			mid = (left + right)/2;
			hours = calcHours(piles, mid);
			if(hours <= h){
				ans = Math.min(ans, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}
		
	private int calcHours(int[] piles, int rate){
		int total = 0;
		for(int pile : piles){
			total += pile / rate;
			if(pile % rate != 0) total++;
		}
		return total;
	}
}

/**
1 4 3 2 h = 9
l = 1, r = 4, m = 2, hr = 6 ans = 2
l = 1, r = 1, m = 1, hr = 10 ans = 2


*/