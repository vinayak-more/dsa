class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class KthSmallestInBST{
	public int kthSmallest(TreeNode root, int k){
		Holder holder = new Holder();
		solve(root, k, holder);
		return holder.ans;
	}
	
	private void solve(TreeNode root, int k, Holder holder){
		if(root == null ) return;
		if(holder.count >= k) return;
		solve(root.left, k, holder);
		holder.count++;
		if(k == holder.count){
			holder.ans = root.value;
			return;
		}
		solve(root.right, k, holder);
	}

}

class Holder {
	int count = 0;
	int ans;
}