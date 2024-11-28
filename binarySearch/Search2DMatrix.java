import java.util.*;

public class Search2DMatrix{
	public boolean searchMatrix(int[][] matrix, int target) {
        	int m = matrix.length;
		int n = matrix[0].length;
		int left = 0, right = m * n - 1, mid, x, y;
		while(left <= right) {
			mid = (left + right) / 2;
			x = mid / n;
			y = mid % n;
			if(matrix[x][y] == target) return true;
			if(matrix[x][y] < target) left = mid + 1;
			else right = mid - 1;
		}
		return false;
	}
}
/**
01 02 04 08
10 11 12 13
14 20 30 40
t = 10
m = 3, n = 4,
l = 0, r = 11, m = 5 x = 1 y = 1 m[x][y] = 11 > t = 10
l = 0, r = 4, m = 2  x = 0 y = 2 m[x][y] = 4 < t = 10
l = 3, r = 4, m = 3  x = 0 y = 3 m[x][y] = 8 < t = 10
l = 4, r = 4, m = 4  x = 1 y = 0 m[x][y] = 10 == t = 10 return true


*/