import java.util.Iterator;


public class Tester {

	public static void main(String[] args) {
		System.out.println("" + "f".compareTo("b"));
		
		
		LinkedList<Integer> test = new LinkedList<Integer> ();
		//test.add(2);
		LinkedList<Integer> test1 = new LinkedList<Integer> ();
		test1.add(1);
		System.out.println("" + test.equals(test1));
		//test.add(-1);
		//test.add(-3);
		//test.insert(2, 2);
		//test.addFirst(-1);
		//test.addFirst(-2);
		//test.addFirst(-5);
		//test.removeFirst();
		//test.removeFirst();
		Iterator<Integer> it = test.iterator();
		while (it.hasNext()) {
			System.out.println("" + it.next() );
		}
		System.out.println("size: " + test.size());
		
//		IList<Integer> sublist = test.getSubList(5, 7);
//		test.remove(1);
//		Iterator<Integer> itt = sublist.iterator();
//		while (itt.hasNext()) {
//			System.out.println("" + itt.next() );
//		}
//        
//		System.out.println("size: " + sublist.size());
		
		Integer num = -1;
        
		//System.out.println("" + test.remove(num));
		//test.removeRange(6,7);
		Iterator<Integer> itt = test.iterator();
		while (itt.hasNext()) {
			System.out.println("" + itt.next() );
		}
		System.out.println("size: " + test.size());
		System.out.println(test.toString());
	}

}
