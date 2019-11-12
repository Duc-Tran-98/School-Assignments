import java.util.*;

public class PrefixCode {
	TreeSet<Integer> ts = new TreeSet<>();
	
	public String isOne(String[] words) {
		boolean isOne = true;
		for(int k = 0; k < words.length; k++) {
			for(int i = 0; i < words.length; i++) {
				if(words[k].startsWith(words[i]) && i != k) {
					isOne = false;
					ts.add(i);
				}
			}
		}
		if(!isOne) {
			return "No, " + ts.first();
		}
		return "Yes";
	}
	
}
