public class FindTheDuplicateInteger{
	public int findDuplicate(int[] nums){
		int slow = nums[0], fast = nums[0];
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
		slow = nums[0];
		while(slow != fast){
			slow = nums[slow];
			fast = nums[fast];
		}

		return nums[slow];
	}
}
/** 
1 2 3 2 2
s = 1 f = 1
s = 2 f = 3
s = 3 f = 3
s = 1 f = 3
s = 2 f = 2
*/