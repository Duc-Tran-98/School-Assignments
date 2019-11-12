import java.util.*;

public class BruteWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "AWOIDUIWAHCSZNGAIOWIAWEWIUYTIUEAXKLMFCAWMAWVAWUBVA";
		BruteWords b = new BruteWords();
		System.out.println(b.getScore(str));
	}
	
	public int getScore(String str) {
		char[] characters = str.toCharArray();
		HashMap<Character,Integer> map = new HashMap<>();
		for(char ch : characters) {
			if(!map.containsKey(ch)) {
				map.put(ch, 0);
			}
			map.put(ch, map.get(ch)+1);
		}
		int maxOne = 0;
		int maxTwo = 0;
		Character o = null;
		Character t = null;
		for(char key : map.keySet()) {
			if(map.get(key) > maxOne) {
				maxOne = map.get(key);
				o = key;
			}
		}
		for(char key : map.keySet()) {
			if(key != o) {
				if(map.get(key) > maxTwo) {
					maxTwo = map.get(key);
					t = key;
				}
			}
		}
		int score = ((maxOne + maxTwo) * (maxOne + maxTwo));
		for(char key : map.keySet()) {
			if(key != o && key != t) {
				score += (map.get(key) * map.get(key));
			}
		}
		return score;
	}

}
