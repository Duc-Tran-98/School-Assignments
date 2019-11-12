import java.util.Arrays;

public class TeamSplit {

	public int difference(int[] strengths) {
		int teamOne = 0;
		int teamTwo = 0;
		boolean add = true;
		Arrays.sort(strengths);
		for(int i = strengths.length-1; i >=0; i--) {
			if(add) {
				teamOne += strengths[i];
			}else {
				teamTwo += strengths[i];
			}
			add = !add;
		}
		return Math.abs(teamTwo-teamOne);
	}
	
}
