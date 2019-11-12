import java.util.*;

public class TreeTighten {

	public TreeNode tighten(TreeNode t) {
		tightenHelper(t);
		return t;
	}
	
	public void tightenHelper(TreeNode t) {
		if(t == null) {
			return;
		}
		if(t.left == null && t.right == null) {
			return;
		}
		tightenHelper(t.left);
		tightenHelper(t.right);
		if(t.left == null || t.right == null) {
			if(t.left == null) {
				//System.out.println("Before: " + t.info);
				t = t.right;
				//System.out.println("After: " + t.info);
				return;
			}else {
				//System.out.println("Before: " + t.info);
				t = t.left;
				//System.out.println("After: " + t.info);
				return;
			}
		}
	}
	
	public void print(TreeNode t) {
		if(t == null) {
			System.out.print("x ");
			return;
		}
		System.out.print(t.info + " ");
		print(t.left);
		print(t.right);
	}
	
	public static void main(String[] args) {
		TreeTighten tt = new TreeTighten();
		TreeNode t = new TreeNode(13, new TreeNode(22, new TreeNode(8, new TreeNode(5), new TreeNode(7)), null), new TreeNode(18, new TreeNode(15, null, new TreeNode(25)), null));
		TreeNode l = tt.tighten(t);
		//tt.print(l);
	}
	
}
