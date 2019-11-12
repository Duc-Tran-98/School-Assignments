import java.util.*;

public class SortedFreqs {

	public int[] freqs(String[] data) {
		TreeSet<String> ts = new TreeSet<>();
		for(String word : data) {
			ts.add(word);
		}
		int[] freqs = new int[ts.size()];
		int k = 0;
		for(String s : ts) {
			freqs[k] = Collections.frequency(Arrays.asList(data), s);
			k++;
		}
		return freqs;
	}
	
}
