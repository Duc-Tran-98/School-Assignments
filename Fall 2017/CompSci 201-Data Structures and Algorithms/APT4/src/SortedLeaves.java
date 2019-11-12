import java.util.*;

public class SortedLeaves {

	ArrayList<Integer> arr = new ArrayList<>();
	
	public String[] values(TreeNode tree) {
		valuesHelper(tree);
		Collections.sort(arr);
		String[] values = new String[arr.size()];
		for(int k = 0; k < arr.size(); k++) {
			char c = (char)arr.get(k).intValue();
			values[k] = new Character(c).toString();
		}
		return values;
	}
	
	public void valuesHelper(TreeNode tree) {
		if(tree == null) {
			return;
		}
		if(tree.right == null && tree.left == null) {
			arr.add(tree.info);
		}
		valuesHelper(tree.left); 
		valuesHelper(tree.right);
	}
	
	public static void main(String[] args) {
		SortedLeaves sl = new SortedLeaves();
		TreeNode tree = new TreeNode(3, new TreeNode(73, new TreeNode(68), new TreeNode(85)), new TreeNode(8, new TreeNode(77, new TreeNode(75), new TreeNode(69)), null));
		String[] test = sl.values(tree);
		//System.out.println(Arrays.toString(test));
	}
	
}
