import java.util.*;

public class OlympicCandles {

	public int numberOfNights(int[] candles) {
		ArrayList<Integer> al = new ArrayList<>();
		for(int c : candles) {
			al.add(c);
		}
		int n = 0;
		int count = 0;
		while(n < al.size()) {
			n += 1;
			count = n;
			Collections.sort(al, Comparator.reverseOrder());
			//System.out.println("Sorted Array: " + al.toString() + " AL Size: " + al.size() + " Night: " + n);
			for(int i = 0; i < count; i++) {
				al.set(i, al.get(i)-1);
				if(al.get(i) == 0) {
					al.remove(i);
					count--;
					i--;
				}
			}
			
		}
		//System.out.println("End: Sorted Array: " + al.toString() + " AL Size: " + al.size());
		return n;
	}
	
	public static void main(String[] args) {
		int[] candles = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		OlympicCandles oc = new OlympicCandles();
		//System.out.println(oc.numberOfNights(candles));
	}
	
}
