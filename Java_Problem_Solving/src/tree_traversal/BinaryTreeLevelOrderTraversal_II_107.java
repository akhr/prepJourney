/**
 * @authour Akhash Ramamurthy
 */
package tree_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Akhash Ramamurthy
 *
 */
public class BinaryTreeLevelOrderTraversal_II_107 {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int levelSize;
		while(!q.isEmpty()) {
			levelSize = q.size();
			List<Integer> level = new ArrayList<Integer>(levelSize);
			res.add(0, level);
			while(levelSize > 0) {
				TreeNode curr = q.remove();
				level.add(curr.val);
				if (curr.left != null) q.add(curr.left);
				if (curr.right != null) q.add(curr.right);
				levelSize--;
			}
		}
		return res;   
	}

}
