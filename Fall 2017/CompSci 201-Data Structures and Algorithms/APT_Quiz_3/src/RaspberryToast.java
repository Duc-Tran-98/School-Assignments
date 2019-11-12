
public class RaspberryToast {

	public int apply(int upper_limit, int layer_count) {
		int swipes = 1;
		int limit = upper_limit;
		while(upper_limit < layer_count) {
			if(layer_count  - limit < 0) {
				limit -= 1;
			}else {
				layer_count -= limit;
				swipes += 1;
			}
		}
		return swipes;
	}
	
}
