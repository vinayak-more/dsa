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
class Holder{
	int max = Integer.MIN_VALUE;
}

public class MaxPathSum{
	public int maxPathSum(TreeNode root){
		Holder holder = new Holder();
		int max = solve(root, holder);
		return holder.max;
	}
	
	private int solve(TreeNode root, Holder holder){
		if(root == null) return Integer.MIN_VALUE;
		int left = solve(root.left, holder);
		int right = solve(root.right, holder);
		int rootMax = Math.max(left + root.val, right + root.val);
		rootMax = Math.max(rootMax, root.val);
		holder.max = Math.max(rootMax, (left + right + root.val));
		return rootMax;
	}
}