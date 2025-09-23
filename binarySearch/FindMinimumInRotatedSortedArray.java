public class FindMinimumInRotatedSortedArray{

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
		return nums[left];
    	}
}
/*
3 4 5 6 1 2
l = 0 r = 5 m = 2 nums[m] !< nums[m - 1] 
l = 3 r = 5 m = 4 return nums[4] == 1

1 2 3 4 5 6
l = 0 r = 5 m = 2 nums[m] !< nums[m - 1]
l = 0 r = 1 m = 1 nums[m] !< nums[m - 1]
l = 0 r = 0 return nums[l] = 1

2 3 4 5 6 1
l = 0 r = 5 m = 2 !


*/