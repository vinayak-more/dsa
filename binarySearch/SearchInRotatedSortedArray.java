public class SearchInRotatedSortedArray{
	public int search(int[] nums, int target) {
		if( nums.length == 0 ) return -1;
        	int left = findMin(nums);
System.out.println(left);
		if(nums[left] == target ) return left;
		if(target < nums[0]) return binarySearch(nums, left + 1, nums.length - 1, target);
		else return binarySearch(nums, 0, left - 1, target);
    	}
public int findMin(int[] nums) {
       		if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.min(nums[0], nums[1]);

      int left = 0, right = nums.length - 1, mid;
		while(left < right){
			mid = (left + right)/2;
			if(mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
			else {
				if(nums[mid] < nums[0] ) right = mid - 1;
				else{
					if(nums[mid] > nums[right] ) left = mid + 1;
					else right = mid - 1;
				}
			}
		}
		return left;
    	}

	
	private int binarySearch(int[] nums, int left, int right, int target){
		int mid;
		while(left <= right){
			mid = (left + right)/2;
			if(nums[mid] == target) return mid;
			if(nums[mid] < target ) left = mid + 1;
			else right = mid - 1;
		}
		return -1;
	}
}
/*
3 4 5 6 1 2
l = 0 r = 5 m = 2
l = 3 r = 5 m = 4

*/