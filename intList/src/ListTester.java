

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import utils.Stopwatch;

public class ListTester {

    // return all instances of tgt in the given collection
    public static int frequency(Object tgt, Collection<?> coll) {
        int result = 0;
        Iterator<?> it = coll.iterator();
        while(it.hasNext()) 
            if(tgt.equals(it.next()))
                result++;
        return result;
    }

    public static void foo() {
        //        GenericList list = new GenericList();
        //        String name = "Olivia";
        //        list.add(name);
        //        System.out.println(list.get(0).charAt(2));
        //        
        //        List314 list;
        //        list = new List314();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(12);
        System.out.println(list.get(15));

    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        IntList list0 = new IntList();
        //        list0.printLengthOfValues();


        IntList list1 = new IntList(1);
        IntList list2 = new IntList(10000);
        // System.out.println(list1.size);
        // System.out.println(list2.values.length);


        // IntList list3 = new IntList(-100); // causes runtime error

        System.out.println(list2.size());

        System.out.println(list1 + " expect []");
        // list1.add(12);
        list1.insert(0, 12);
        System.out.println(list1 + " expect [12] ");
        list1.add(5);
        System.out.println(list1 + " expect [12, 5] ");

        System.out.println(list1.size() + " expected 2");
        System.out.println(list2.size() + " expected 0");

        // testSpeedOfToString();

        list1.insert(1, 17);
        System.out.println(list1 + " expect [12, 17, 5] ");

        //        int n = 1000000;
        //        while(true) {
        //            IntList list = new IntList();
        //            System.out.println(n);
        //            for(int i = 0; i < n; i++)
        //                list.add(i);
        //            n *= 2;
        //        }


        //        list1.remove(1);
        //        System.out.println(list1 + " expect 12 5 ");
        // list2.container[2] = 3;
        //        for(int i = 0; i < 10000000; i++) {
        //            list1.add(i);
        //        }

        // test speed of toString()


        timeInsertAll();
        //
        insertAllSimpleTest();

        // Generic List tests
        // testEquals();
        // showIteratorErrors();

        // testSorted();
    }

    private static void testSpeedOfToString() {
        int n = 20000;
        for(int i = 0; i < 10; i++) {
            System.out.println(n);
            Stopwatch st = new Stopwatch();
            IntList list1 = new IntList();
            st.start();
            for(int j = 0; j < n; j++)
                list1.add(i);
            st.stop();
            System.out.println("time to add: " + st);
            st.start();
            String asString = list1.toString();
            st.stop();
            System.out.println("time for toString: " + st);
            System.out.println();
            char ch = asString.charAt(asString.length() / 2);
            n *= 2;
        }
    }

    public static void testSorted() {
        SortedIntList list1 = new SortedIntList();
        int[] data = {5, 1, -2, 20, 15, 5, 3};
        for(int x : data)
            list1.add(x);
        System.out.println(list1);
        System.out.println(list1.size());
        list1.insert(5, -10);
        System.out.println(list1);
    }

    public static void showIteratorErrors() {
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(12);
        a1.add(12);
        a1.add(13);
        Iterator<Integer> it = a1.iterator();

        // runtime error 1
        //        System.out.println(it.next());
        //        System.out.println(it.next());
        //        it.remove();
        //        it.remove();

        // runtime error 2
        //        System.out.println(it.next());
        //        System.out.println(it.next());
        //        System.out.println(it.next());
        //        System.out.println(it.next());   

        System.out.println(it.next());
        a1.add(13);
        a1.add(15);
        System.out.println("added some"); 
        System.out.println(it.next());
        it = a1.iterator();
        it.next();
    }

    private static void insertAllSimpleTest() {
        int[] data1 = {0, 1, 2, 3, 4};
        int[] data2 = {17, 8, 15};
        IntList list1 = new IntList();
        for(int x : data1)
            list1.add(x);
        IntList list2 = new IntList();
        for(int x : data2)
            list2.add(x);

        list1.insertAll(3, list2);

        System.out.println();
        System.out.println(list1 + " expected [0, 1, 2, 17, 8, 15, 3, 4]");
        System.out.println(list1.size() + " expected 8");
        System.out.println(list2 + " expected [17, 8, 15]");
        System.out.println(list2.size() + " expected 3");

    }

    private static void timeInsertAll() {
        int n = 50000;

        for(int i = 0; i < 10; i++) {
            IntList list1 = new IntList();
            IntList list2 = new IntList();
            for(int j = 0; j <  n; j++) {
                list1.add(i);
                list2.add(i);
            }

            Stopwatch st = new Stopwatch();
            st.start();
            list1.insertAll(0, list2);
            st.stop();
            System.out.println("time for insertAll: " + st);
            n *= 2;
        }
    }

    //    public static void testEquals() {
    //        
    //        GenericList list = new GenericList();
    //        list.add(12);
    //        list.add("Olivia");
    //        list.add(new GenericList());
    //        list.add(new Rectangle(5, 10, 20, 30));
    //        System.out.println(list);
    //        
    //        Property p1 = new Property("Boardwalk", 400);
    //        Property p2 = new Property("Boardwalk", 400);
    //        Property p3 = new Property("Park Place", 350);
    //        Property p4 = new Property("Park Place", 350);
    //        
    //        GenericList list1 = new GenericList();
    //        list1.add(p1);
    //        list1.add(p3);
    //        
    //        GenericList list2 = new GenericList();
    //        list1.add(p2);
    //        list1.add(p4);
    //        
    //        System.out.println("list1.equals(list2): " + list1.equals(list2));
    //        System.out.println("list1: " + list1.toString());
    //        System.out.println("list1: " + list2.toString());
    //    }
    //

    public static<E> int frequency(Collection<E> list, E st) {
        int count = 0;

        for(E s : list)
            if(s.equals(st))
                count++;

        //        Iterator<E> it = list.iterator();
        //        while(it.hasNext()) {
        //            String s = it.next();
        //            if(s.equals(st))
        //                count++;
        //        }

        return count;

    }

    //    public static void foo2(GenericList<?> list) {
    //        
    //    }

    public static void testGen() {
        // GenericList<?> list1 = new GenericList<?>();
        //        GenericList<String> g1 = new GenericList<String>();
        //        g1.add("isabelle");
        //        System.out.println( g1.get(0).charAt(0));
        ////        g1.add(new Integer(12));
        ////        g1.add(17);
        //        GenericList<Integer> g2 = new GenericList<Integer>();
        //        g2.add(12);
        //        System.out.println(g1.equals(g2));
        //    }

        //        public static void testSorted() {
        //            SortedIntList s1 = new SortedIntList();
        //            System.out.println(s1.toString());
        //            final int LIMIT = 10;
        //            for(int i = 0; i < LIMIT; i++) {
        //                s1.add((int) (Math.random() * 200) );
        //                System.out.println(s1);
        //            }
        //            s1.insert(4, -10);
        //            System.out.println(s1);
    }
}