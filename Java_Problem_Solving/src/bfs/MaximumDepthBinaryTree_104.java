/**
 * @authour Akhash Ramamurthy
 */
package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Akhash Ramamurthy
 *
 */
public class MaximumDepthBinaryTree_104 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int maxDepthRecursive_BFS(TreeNode root) {
		if (root ==  null) return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int levelSize = 0, level = 1, maxDepth = Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			levelSize = q.size();
			while(levelSize > 0) {
				TreeNode curr = q.poll();
				if (curr.left == null && curr.right == null) 
					maxDepth = Math.max(maxDepth, level);
				if(root.left != null) q.add(curr.left);
				if(root.right != null) q.add(curr.right);
				levelSize--;
			}
			level++;
		}
		return maxDepth;
	}
	
	public int maxDepthRecursive_DFS_PreOrder(TreeNode root) {
		return helper(root, 1);
	}
	
	public int helper(TreeNode root, int level) {
		if (root ==  null) return 0;
		if (root.left == null && root.right == null) return 1;
		
		int lHt = 0, rHt = 0;
		if(root.left != null) {
			lHt = helper(root.left, level+1);
		}
		if(root.right != null) {
			rHt = helper(root.right, level+1);
		}
		return Math.max(lHt, rHt) + 1;
	}
}
