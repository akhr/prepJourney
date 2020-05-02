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
public class LevelOrderSuccessor {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static TreeNode findSuccessor(TreeNode root, int key) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int levelSize = 0;
		while(!q.isEmpty()){
			levelSize = q.size();
			while(levelSize-- > 0) {
				TreeNode curr = q.poll();
				if (curr.val == key) {
					return q.poll();
				}
				if (curr.left != null) q.add(curr.left);
				if (curr.right != null) q.add(curr.right);
			}
		}
		return null;    
	}

}
