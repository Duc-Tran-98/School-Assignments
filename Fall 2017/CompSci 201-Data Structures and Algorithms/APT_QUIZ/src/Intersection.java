import java.util.*;

public class Intersection {

	public String matches(String[] entries) {
		String[] firstWords = entries[0].split(" ");
		Set<String> matches = new TreeSet<>();
		for(String word : firstWords) {
			boolean[] checks = new boolean[entries.length-1];
			for(int i = 1; i < entries.length; i++) {
				String[] temp = entries[i].split(" ");
				ArrayList<String> entryList = new ArrayList<>();
				for(String t : temp) {
					entryList.add(t);
				}
				checks[i-1] = entryList.contains(word);
			}
			int trueCount = 0;
			for(boolean b : checks) {
				if(b) {
					trueCount += 1;
				}
			}
			if(trueCount == checks.length) {
				matches.add(word);
			}
		}
		String[] m = new String[matches.size()];
		int k = 0;
		for(String s : matches) {
			m[k] = s;
			k += 1;
		}
		return String.join(" ", m);
	}
	
	public static void main(String[] args) {
		String[] entries = {"1 2 2", "2 3 2", "3 7 6", "2 7 2"};
		Intersection i = new Intersection();
		System.out.println(i.matches(entries));
	}
	
}
