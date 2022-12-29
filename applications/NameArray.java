package applications;
import java.util.*;

public class NameArray {
	public static void main(String[] args) {

		ArrayList<String>  names = new ArrayList<String>();
		names.add("桜井");
		names.add("田原");
		names.add("中川");
		names.add("鈴木");
		
		String search = args[0];
		boolean result =false;
		
		for(int i = 0;i< names.size();i++) {
			if(search.equals(names.get(i))) {
				result =true;
			}
		if(result) {
			System.out.println(search +"さんは含まれています");
		}else {
			System.out.println(search+"さんは含まれています");
		}
		}
	}
}
