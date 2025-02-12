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

public class BalancedBinaryTree{
	public boolean isBalanced(TreeNode root){
		if( root == null ) return true;
		int left = height(root.left);
		int right = height(root.right);
		return Math.abs(left - right ) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	private int height(TreeNode root) {
		if(root == null ) return 0;
		return Math.max(height(root.left), height(root.right)) + 1; 
	}
}