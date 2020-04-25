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
public class MinimumDepthBinaryTree_111 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public int minDepth(TreeNode root) {
		if (root == null) return 0;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int minDepth = Integer.MAX_VALUE;
		int level = 1;
		int levelSize = 0;

		while(!q.isEmpty()) {
			levelSize = q.size();
			while(levelSize > 0) {
				TreeNode curr = q.remove();
				if (curr.left == null && curr.right == null) {
					minDepth = Math.min(minDepth, level);
				}else {
					if (curr.left != null) q.add(curr.left);
					if (curr.right != null) q.add(curr.right);
				}
				levelSize--;
			}
			level++;
		}
		return minDepth;
	}
}
