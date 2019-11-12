
public class LevelSum {

	public int sum(TreeNode tree) {
		return sumHelper(tree, 1);
	}
	
	private int sumHelper(TreeNode tree, int level) {
		if(tree == null) {
			return 0;
		}
		return level + sumHelper(tree.left, level + 1) + sumHelper(tree.right, level + 1);
	}
	
}
