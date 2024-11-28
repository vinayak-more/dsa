public class CarFleet{
	public int carFleet(int target, int[] position, int[] speed) {
		Integer[][] cars = new Integer[position.length][2];
		for(int i = 0; i < position.length; i++){
			cars[i][0] = position[i];
			cars[i][1] = speed[i];
		}
		Arrays.sort(cars, (a, b) -> a[0] - b[0]);
		double[] times = new double[position.length];
		for(int i = 0; i < times.length; i++){
			int distance = target - cars[i][0];
			times[i] = distance / (double) cars[i][1]; 
		}
		int count = 1; double last = times[times.length - 1];
		System.out.println(Arrays.toString(times));
		for(int i = times.length - 1; i >= 0; i--){
			if(times[i] > last){
				last = times[i];
				count++;
			}
		}		
		return count;
	}
}

// p = 4 1 0 7, s= 2 2 1 1 t = 10
// p = 0 1 4 7, s = 1 2 2 1 
// r = 10 5 3 3