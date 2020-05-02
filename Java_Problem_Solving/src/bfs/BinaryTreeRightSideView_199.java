/**
 * @authour Akhash Ramamurthy
 */
package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 *
 */
public class BinaryTreeRightSideView_199 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<Integer> rightSideView_bfs(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) return res;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int levelSize = 0;
		while(!q.isEmpty()) {
			levelSize = q.size();
			while(levelSize > 0) {
				TreeNode curr = q.poll();
				if (levelSize == 1) res.add(curr.val); // add only rightmost node
				if (curr.left != null) q.add(curr.left);
				if (curr.right != null) q.add(curr.right);
				levelSize--;
			}
		}
		return res;
	}

	public List<Integer> rightSideView_dfs_pre(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) return res;
		helper(root, 1, res);
		return res;
	}

	private void helper(TreeNode root, int level, List<Integer> res) {
		if(root == null) return;
		if(res.size() == level-1){
			res.add(root.val);
		}
		helper(root.right, level+1, res);
		helper(root.left, level+1, res);
	}

	@Test
	public void test_01() {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.left.left.left = new TreeNode(3);
		List<Integer> result = rightSideView_dfs_pre(root);
		for (int nodeVal : result) {
			System.out.print(nodeVal + " ");
		}
		System.out.println();
	}
	
	@Test
	public void test_02() {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.left.left.left = new TreeNode(3);
		List<Integer> result = rightSideView_bfs(root);
		for (int nodeVal : result) {
			System.out.print(nodeVal + " ");
		}
		System.out.println();
	}
}
