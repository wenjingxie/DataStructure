import java.util.ArrayList;
import java.util.Arrays;


public class tester {

	public static void main(String[] args) {
		ArrayList<String> as = new ArrayList<String> ();
		//test(as);
		//System.out.println(as);
		as.add("asd");
		
		AnagramSolver k = new AnagramSolver(as);
		//System.out.println(k.getAnagrams("asd", 1));
		k.getAnagrams("asd", 1);
		
	}
	
	private void test(ArrayList<String> result) {
		
		result.add("sdas");
	}

}
