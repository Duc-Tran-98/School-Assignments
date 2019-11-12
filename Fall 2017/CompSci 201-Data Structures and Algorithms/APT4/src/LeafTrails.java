import java.util.*;

public class LeafTrails {
	
	Map<Integer, String> map = new TreeMap<>();
	
	public String[] trails(TreeNode tree) {
		trailsHelper(tree, "");
		int k = 0;
		String[] trails = new String[map.size()];
		for(int i : map.keySet()) {
			trails[k] = map.get(i);
			k++;
		}
		return trails;
	}
	
	public void trailsHelper(TreeNode tree, String path) {
		if(tree == null) {
			return;
		}
		if(tree.left == null && tree.right == null) {
			map.put(tree.info, path);
		}
		trailsHelper(tree.left, path + "0");
		trailsHelper(tree.right, path + "1");
	}
	
	public static void main(String[] args) {
		LeafTrails lt = new LeafTrails();
		TreeNode tree = new TreeNode(3, new TreeNode(73, new TreeNode(68), new TreeNode(85)), new TreeNode(8, new TreeNode(77, new TreeNode(75), new TreeNode(69)), null));
		String[] test = lt.trails(tree);
		//System.out.println(Arrays.toString(test));
	}
	
}
