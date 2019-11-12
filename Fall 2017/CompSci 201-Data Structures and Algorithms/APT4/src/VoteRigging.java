import java.util.*;

public class VoteRigging {

	public int minimumVotes(int[] votes) {
		if(votes.length <= 1) return 0;
		List<Integer> list = new ArrayList<>();
		for(int v : votes) {
			list.add(v);
		}
		int count = 0;
		List<Integer> others = list.subList(1, list.size());
		while(list.get(0) <= Collections.max(others)) {
			Collections.sort(others, Collections.reverseOrder());
			list.set(0, list.get(0)+1);
			list.set(1, list.get(1)-1);
			count += 1;
		}
		return count;
	}
	
}
