/**
 * @authour Akhash Ramamurthy
 */
package tree_traversal;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 *
 */
public class BoundaryBinaryTree_545 {

	public class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x){
			this.val = x;
		}
		TreeNode(int x, TreeNode left, TreeNode right){
			this.val = x;
			this.left = left;
			this.right = right;
		}
	}
	
	public List<Integer> boundaryOfBinaryTree_DFS(TreeNode root) {
		if (root == null) return new ArrayList<>();
		
		List<Integer> res = new ArrayList<>();
		res.add(root.val);
		helper(root.left, res, true, false);
		helper(root.right, res, false, true);
		return res;
	}
	
	private void helper(TreeNode root, List<Integer> res, boolean isLeftBoundary, boolean isRightBoundary) {
		if (root == null) return;
		if (root.left == null && root.right ==  null) { res.add(root.val); return; }
		
		if(isLeftBoundary) res.add(root.val);
		helper(root.left, res, isLeftBoundary && root.left!=null, isRightBoundary && root.right==null);
		helper(root.right, res, isLeftBoundary && root.left==null, isRightBoundary && root.right!=null);
		if(isRightBoundary) res.add(root.val);
	}

	public List<Integer> boundaryOfBinaryTree_BFS_Wont_Work(TreeNode root) {
		if (root == null) return new ArrayList<Integer>();

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int levelSize = 0;
		boolean isLeftMost = false;
		boolean isRightMost = false;

		//Result
		List<Integer> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();

		while(!q.isEmpty()) {
			levelSize = q.size();
			isLeftMost = true;
			
			while(levelSize > 0) {
				TreeNode curr = q.poll();
				if(curr.left == null && curr.right == null) { //leaf
					res.add(curr.val);
				}else {
					isRightMost = levelSize == 1;
					if (isLeftMost) {
						res.add(curr.val);
						isLeftMost = false;
					} else if (isRightMost)
						temp.add(curr.val);
					else {} // do nothing - sandwiched nodes

					if(curr.right != null) q.add(curr.right);
					if(curr.left != null) q.add(curr.left);
				}
				levelSize--;
			}
		}

		for(int i=temp.size()-1; i>=0; i--) {
			res.add(temp.get(i));
		}
		return res;
	}

	@Test
	public void test_01() {
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), new TreeNode(4)));
		List<Integer> expecteds = Arrays.asList(1,3,4,2);
		assertArrayEquals(boundaryOfBinaryTree_DFS(root).toArray(), expecteds.toArray());
		System.out.println("Boundary :: "+Arrays.toString(boundaryOfBinaryTree_DFS(root).toArray()));
	}
	
	@Test
	public void test_02() {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8))), new TreeNode(3, new TreeNode(6, new TreeNode(9), new TreeNode(10)), null));
		List<Integer> expecteds = Arrays.asList(1,2,4,7,8,9,10,6,3);
		assertArrayEquals(boundaryOfBinaryTree_DFS(root).toArray(), expecteds.toArray());
		System.out.println("Boundary :: "+Arrays.toString(boundaryOfBinaryTree_DFS(root).toArray()));
	}


}
