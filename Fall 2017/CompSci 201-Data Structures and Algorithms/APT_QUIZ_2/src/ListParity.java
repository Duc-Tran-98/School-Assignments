
public class ListParity {
	
	public int count (ListNode list){
        // replace statement below with code you write
        return helper(0, list);
    }
	
	private int helper(int count, ListNode list) {
		if(list == null) {
			return 0;
		}
		if(count % 2 == 0) {
			return list.info + helper(count + 1, list.next);
		}
		return helper(count + 1, list.next);
	}

}
