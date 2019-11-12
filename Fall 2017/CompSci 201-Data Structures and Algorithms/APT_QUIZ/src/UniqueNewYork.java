import java.util.*;

public class UniqueNewYork {

	public int seen(String[] records) {
		HashSet<String> uniquePlates = new HashSet<>();
		for(String record : records) {
			String[] states = record.split(",");
			for(String state : states) {
				uniquePlates.add(state);
			}
		}
        return uniquePlates.size();
    }
	
	
	public static void main(String[] args) {
		UniqueNewYork u = new UniqueNewYork();
		String[] records = {"Mississippi,Mississippi Mississippi","Mississippi Mississippi Mississippi"};
		int numPlates = u.seen(records);
		System.out.println(numPlates);
	}
	
}
