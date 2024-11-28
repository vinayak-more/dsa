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

public class SubTreeOfABinaryTree {
	public boolean isSubTree(TreeNode root, TreeNode subRoot) {
		if(root == null && subRoot == null ) return true;
		if(root == null || subRoot == null ) return false;
		if(root.val == subRoot.val && isSameTree(root, subRoot)) return true;
		return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
	}
	
	private boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null ) return true;
		if( p == null || q == null ) return false;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}