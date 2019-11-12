import java.util.*;

public class MedalTable {

	public String[] generate(String[] results) {
		TreeMap<String,Integer> golds = new TreeMap<>();
		TreeMap<String,Integer> silvers = new TreeMap<>();
		TreeMap<String,Integer> bronzes= new TreeMap<>();
		PriorityQueue<String> names = new PriorityQueue<>();
		for(int k = 0; k < results.length; k++) {
			String[] countries = results[k].split(" ");
			for(String s:countries) {
				names.add(s);
			}
			if(!golds.containsKey(countries[0])) {
				golds.put(countries[0], 0);
			}
			golds.replace(countries[0], golds.get(countries[0]) + 1);
			if(!silvers.containsKey(countries[1])) {
				silvers.put(countries[1], 0);
			}
			silvers.replace(countries[1], silvers.get(countries[1]) + 1);
			if(!bronzes.containsKey(countries[2])) {
				bronzes.put(countries[2], 0);
			}
			bronzes.replace(countries[2], bronzes.get(countries[2]) + 1);
		}
		String[] ret = new String[names.size()];
		while(names.size() > 0) {
			
		}
		return null;
	}
	
}
