/**
 * @authour Akhash Ramamurthy
 */
package tree_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 *
 */
public class BinaryTreeLevelOrderTraversal_102 {

	public class Node {
		int val;
		Node left, right;
		Node(int x){
			this.val = x;
		}
	}

	public static List<List<Integer>> traverse(Node root){
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int levelSize;
		while(!q.isEmpty()) {
			levelSize = q.size();
			List<Integer> level = new ArrayList<Integer>(levelSize);
			res.add(level);
			while(levelSize > 0) {
				Node curr = q.remove();
				level.add(curr.val);
				if (curr.left != null) q.add(curr.left);
				if (curr.right != null) q.add(curr.right);
				levelSize--;
			}
		}
		return res;
	}
	
	public static List<List<Integer>> traverse_DFS(Node root){
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		helper(root, 1, res);
		return res;
	}
	
	private static void helper(Node root, int level, List<List<Integer>> res) {
		if (root == null) return;
		if(res.size() == level-1) { //still in prev level
			res.add(new ArrayList<>());
		}
		//visit the node
		res.get(level-1).add(root.val); // arr index starts at 0
		helper(root.left, level+1, res);
		helper(root.right, level+1, res);
	}
	
	@Test
	public void test_01() {
		Node root = new Node(12);
	    root.left = new Node(7);
	    root.right = new Node(1);
	    root.left.left = new Node(9);
	    root.right.left = new Node(10);
	    root.right.right = new Node(5);
	    List<List<Integer>> result = BinaryTreeLevelOrderTraversal_102.traverse(root);
	    System.out.println("BFS Level order traversal: " + result);
	}
	
	@Test
	public void test_02() {
		Node root = new Node(12);
	    root.left = new Node(7);
	    root.right = new Node(1);
	    root.left.left = new Node(9);
	    root.right.left = new Node(10);
	    root.right.right = new Node(5);
	    List<List<Integer>> result = BinaryTreeLevelOrderTraversal_102.traverse_DFS(root);
	    System.out.println("DFS Level order traversal: " + result);
	}

}
