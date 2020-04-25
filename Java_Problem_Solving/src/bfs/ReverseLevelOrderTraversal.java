/**
 * @authour Akhash Ramamurthy
 */
package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

import bfs.BinaryTreeLevelOrderTraversal_102.Node;

/**
 * @author Akhash Ramamurthy
 *
 */
public class ReverseLevelOrderTraversal {
	
	public class Node {
		int val;
		Node left, right;
		Node(int x){
			this.val = x;
		}
	}
	
	public static List<List<Integer>> traverse(Node root){
		List<List<Integer>> res = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int levelSize = 0;
		
		while(!q.isEmpty()) {
			levelSize = q.size();
			List<Integer> levelList = new ArrayList<Integer>(levelSize);
			res.add(levelList);
			while(levelSize > 0) {
				Node curr = q.remove();
				if(curr.right != null) q.add(curr.right);
				if(curr.left != null) q.add(curr.left);
				levelList.add(curr.val);
				levelSize--;
			}
		}
		return res;
	}
	
	@Test
	public void test_01() {
	    Node root = new Node(12);
	    root.left = new Node(7);
	    root.right = new Node(1);
	    root.left.left = new Node(9);
	    root.right.left = new Node(10);
	    root.right.right = new Node(5);
	    List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
	    System.out.println("Level order traversal: " + result);
	}

}
