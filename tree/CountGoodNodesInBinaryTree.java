import java.util.*;

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

public class CountGoodNodesInBinaryTree{
	public int goodNodes(TreeNode root){
		if(root == null) return 0;
		Holder holder = new Holder();
		solve(root, root.left, holder);
		solve(root, root.right, holder);
		return holder.count + 1;
	}
	
	private void solve(TreeNode root, TreeNode node, Holder holder){
		if(node == null ) return;
		if(node.val >= root.val){
			holder.count++;
			root = node;
		}
		solve(root, node.left, holder);
		solve(root, node.right, holder);
	}
}
public class Holder{
	int count = 0;
}

		3
	3
4		2