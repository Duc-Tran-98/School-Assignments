import java.util.*;

public class AddSome {

	public ListNode splice(ListNode list, int size) {
		ListNode first = list;
		int[] numbers = new int[size];
		int k = 0;
		for(; k < size-1; k++) {
			numbers[k] = list.info;
			list = list.next;
		}
		numbers[k] = list.info;
		for(int i = 0; i < numbers.length; i++) {
			list.next = new ListNode(numbers[i], list.next);
			list = list.next;
		}
		return first;
	}
	
	public static void main(String[] args) {
		AddSome as = new AddSome();
		ListNode list = new ListNode(1, null);
		ListNode first = list;
		for(int k = 2; k < 11; k++) {
			list.next = new ListNode(k, null);
			list = list.next;
		}
		ListNode temp = as.splice(first, 5);
		while(temp != null) {
			System.out.print(temp.info + ", ");
			temp = temp.next;
		}
	}
	
}
