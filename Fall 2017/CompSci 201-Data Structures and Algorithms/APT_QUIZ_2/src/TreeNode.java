import java.util.Arrays;

public class TreeNode {

	int info;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x){
        info = x;
    }
    
    TreeNode(int x, TreeNode lNode, TreeNode rNode){
        info = x;
        left = lNode;
        right = rNode;
    }
    
    public static void main(String[] args) {
    	String[] a = {"1", "2",	"3", "4", "5"};
    	String[] b = a;
    	b[3] = "98";
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(b));
    	
    }
    
}
