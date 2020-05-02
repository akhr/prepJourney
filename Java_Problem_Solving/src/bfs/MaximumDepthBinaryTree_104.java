/**
 * @authour Akhash Ramamurthy
 */
package bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

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
	
	//=================================================================================
	public int maxDepthRecursive_DFS_PostOrder(TreeNode root) {
		return helper_Post(root, 1);
	}
	
	public int helper_Post(TreeNode root, int level) {
		if (root ==  null) return 0;
		if (root.left == null && root.right == null) return 1;
		
		int lHt = 0, rHt = 0;
		if(root.left != null) {
			lHt = helper_Post(root.left, level+1);
		}
		if(root.right != null) {
			rHt = helper_Post(root.right, level+1);
		}
		return Math.max(lHt, rHt) + 1;
	}
	
	//=================================================================================
	public int maxDepthRecursive_DFS_PreOrder(TreeNode root) {
		int[] maxDepth = new int[1];
		helper_Pre(root, 0, maxDepth);
		return maxDepth[0];
	}
	
	public void helper_Pre(TreeNode root, int level, int[] maxDepth) {
		if (root == null) return;
		
		maxDepth[0] = Math.max(maxDepth[0], level+1);
		
		if (root.left == null && root.right == null) return;
		if(root.left != null) {
			helper_Pre(root.left, level+1, maxDepth);
		}
		if(root.right != null) {
			helper_Pre(root.right, level+1, maxDepth);
		}
	}
	
	@Test
	public void test_01(){
	    TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    System.out.println("Tree Maximum Depth: " + maxDepthRecursive_DFS_PreOrder(root));
	    root.left.left = new TreeNode(9);
	    root.right.left.left = new TreeNode(11);
	    System.out.println("Tree Maximum Depth: " + maxDepthRecursive_DFS_PreOrder(root));
	}
}
