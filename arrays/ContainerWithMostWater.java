///import java.util.*;

public class ContainerWithMostWater{

	public int maxArea(int[] heights) {
        	int start = 0, end = heights.length - 1, max = 0;
		while(start < end ){
			max = Math.max(max, (end - start ) * Math.min(heights[start], heights[end]));
			if(heights[start] < heights[end]) start++;
			else end--;
		}
		return max;
    	}

}
//1 7 2 5 4 7 3 6
//start = 0, end = 7 h = 7 * 1 = 07 m = 07
//start = 1, end = 7 h = 6 * 6 = 36 m = 36
//start = 1, end = 6 h = 5 * 3 = 15 m = 36
//start = 1, end = 5 h = 4 * 7 = 28 m = 36
//start = 2, end = 5 h = 3 * 2 = 06 m = 36
//start = 3, end = 5 h = 2 * 5 = 10 m = 36
//start = 4, end = 5 h = 1 * 4 = 04 m = 36