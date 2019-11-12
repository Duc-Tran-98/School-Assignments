
public class DoubleBack {

	public ListNode move2Front(ListNode list) {
		if(list == null) {
			return list;
		}
		ListNode last = list;
		ListNode prev = null;
		while(last.next != null) {
			prev = last;
			last = last.next;
		}
		last.next = new ListNode(last.info, null);
		last.next.next = list;
		prev.next = null;
		return last;
	}
	
}
