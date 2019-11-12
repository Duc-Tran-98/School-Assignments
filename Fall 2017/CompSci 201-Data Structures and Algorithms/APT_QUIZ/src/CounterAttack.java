
public class CounterAttack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] analyze(String str, String[] words) {
        int[] counts = new int[words.length];
        String[] set = str.split(" ");
        for(int i = 0; i < words.length; i++) {
        	int count = 0;
        	for(String s : set) {
        		if(s.equals(words[i])) {
        			count += 1;
        		}
        	}
        	counts[i] = count;
        }
        return counts;
    }

}
