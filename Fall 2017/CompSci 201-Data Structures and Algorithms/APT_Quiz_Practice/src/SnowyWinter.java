import java.util.*;

public class SnowyWinter {

	public int snowyHighwayLength(int[] startPoints, int[] endPoints) {
		PriorityQueue<Segment> segments = new PriorityQueue<>();
		for(int k = 0; k < startPoints.length; k++) {
			segments.add(new Segment(startPoints[k], endPoints[k]));
		}
		Segment current = segments.poll();
		//System.out.println("Start: " + current.start + " End: " + current.end);		
		int total = 0;
		while(segments.size() > 0) {
			Segment next = segments.poll();
	//		System.out.println(current.overlap(next));
			if(current.overlap(next)) {
				current = current.merge(next);
	//			System.out.println("Start: " + current.start + " End: " + current.end);
			}else {
				total += current.length();
//				System.out.println("Total: " + total);
				current = next;
			}
		}
		//System.out.println("Start: " + current.start + " End: " + current.end);
		total += current.length();
		//System.out.println("Total: " + total);
		return total;
	}
	
	private class Segment implements Comparable<Segment>{
		
		private int start;
		private int end;
		
		public Segment(int s, int e) {
			start = s;
			end = e;
		}
		
		private int length() {
			return end-start;
		}
		
		private boolean overlap(Segment b) {
			if((this.start >= b.start && this.start <= b.end) || (this.end <= b.end && this.end >= b.start)) {
				return true;
			}
			if((b.start >= this.start && b.start <= this.end) || (b.end <= this.end && b.end >= this.start)) {
				return true;
			}
			return false;
		}
		
		private Segment merge(Segment b) {
			int s = Math.min(this.start, b.start);
			int e = Math.max(this.end, b.end);
			return new Segment(s,e);
		}

		/*@Override
		public int compare(Segment a, Segment b) {
			// TODO Auto-generated method stub
			;
		}*/

		@Override
		public int compareTo(Segment b) {
			// TODO Auto-generated method stub
			if(this.start == b.start) {
				return this.end-b.end;
			}
			return this.start-b.end;
		}
		
	}
	
	public static void main(String[] args) {
		int[] startPoints = {6334,5723};
		int[] endPoints = {6498,9168};
		SnowyWinter sw = new SnowyWinter();
		int covered = sw.snowyHighwayLength(startPoints, endPoints);
		System.out.println(covered);
	}
	
}
