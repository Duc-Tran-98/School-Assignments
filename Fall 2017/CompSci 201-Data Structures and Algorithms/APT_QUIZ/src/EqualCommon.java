import java.util.*;

public class EqualCommon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EqualCommon ec = new EqualCommon();
		String[] a1 = {"to", "be", "or", "not", "to", "be", "hamlet"};
		String[] a2 = {"to", "be", "or", "not", "to", "be", "to", "be", "hamlet"};
		String[] matches = ec.matches(a1, a2);
		for(String s : matches) {
			//System.out.print(s + " ");
		}
	}
	
	public String[] matches(String[] a1, String[] a2) {
        Map<String,Integer> aMap = fillMap(a1);
        Map<String,Integer> bMap = fillMap(a2);
        ArrayList<String> helper = new ArrayList<>();
        for(String aKey : aMap.keySet()) {
        	for(String bKey : bMap.keySet()) {
        		if(aKey.equals(bKey)) {
        			if(aMap.get(aKey).intValue() == bMap.get(bKey).intValue()) {
        				helper.add(aKey);
        			}
        		}
        	}
        }
        String[] matches = new String[helper.size()];
        for(int i = 0; i < matches.length; i++) {
        	matches[i] = helper.get(i);
        }
        Arrays.sort(matches);
        return matches;
    }
	
	public Map<String,Integer> fillMap(String[] words){
		Map<String,Integer> map = new HashMap<>();
		for(int k = 0; k < words.length; k++	) {
			if(!map.containsKey(words[k])) {
				map.put(words[k], 0);
			}
			map.replace(words[k], map.get(words[k]) + 1);
		}
		return map;
	}

}
