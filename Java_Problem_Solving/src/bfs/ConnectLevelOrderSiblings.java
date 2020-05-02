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
public class ConnectLevelOrderSiblings {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;

		TreeNode(int x) {
			val = x;
			left = right = next = null;
		}
	}
	public static void connect(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		int levelSize = 0;
		q.add(root);
		while(!q.isEmpty()){
			levelSize = q.size();
			while(levelSize > 0) {
				TreeNode curr = q.poll();
				if (levelSize == 1) { // rightmost node in the level
					curr.next = null;
				}else {
					curr.next = q.peek();
				}
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
				levelSize--;
			}
		}
	}
}
