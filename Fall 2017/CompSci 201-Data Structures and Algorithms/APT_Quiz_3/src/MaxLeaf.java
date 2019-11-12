
public class MaxLeaf {

	public int max(TreeNode t) {
		if(t == null) {
			return Integer.MIN_VALUE;
		}
		if(t.left == null && t.right == null) {
			return t.info;
		}
		return Math.max(max(t.left), max(t.right));
	}
	
}
