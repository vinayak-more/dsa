public class TrappingRainWaterII{
	public int trapRainWater(int[][] height) {
		int m = height.length, n = height[0].length;
		int[][] left = new int[m][n];
		for(int i = 0; i < m; i++){
			left[i][0] = height[i][0];
			for(int j = 1; j < n; j++){
				left[i][j] = Math.max(left[i][j-1], height[i][j]);
			}
		}
		int[][] right = new int[m][n];
		for(int i = 0; i < m; i++){
			right[i][n-1] = height[i][n-1];
			for(int j = n - 2; j >= 0; j--){
				right[i][j] = Math.max(right[i][j+1], height[i][j]);
			}
		}
		int[][] front = new int[m][n];
		for(int i = 0; i < n; i++){
			front[0][i] = height[0][i];
			for(int j = 1; j < m; j++){
				front[j][i] = Math.max(front[j-1][i], height[j][i]);
			}
		}
		int[][] back = new int[m][n];
		for(int i = 0; i < n; i++){
			back[m-1][i] = height[m-1][i];
			for(int j = m - 2; j >= 0 ; j--){
				back[j][i] = Math.max(back[j+1][i], height[j][i]);
			}
		}
		
		int[][] min = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 1; j < n; j++){
				min[i][j] = Math.min(left[i][j], Math.min(right[i][j], Math.min(front[i][j], back[i][j])));
			}
		}
		int result = 0;
		for(int i = 0; i < m; i++){
			for(int j = 1; j < n; j++){
				result += min[i][j] - height[i][j];
			}
		}
		return result;
    	}
}