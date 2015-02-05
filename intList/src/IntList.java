

public class IntList {
    
    private static final int DEFAULT_CAP = 10;

    // instance variables, aka fields
    // values may be bigger than the list we are representing
    private int[] values;
    private int size;
    
    // constructors
    // create an empty list
    public IntList() {
        this(DEFAULT_CAP); // call single int constructor
    }
    
    // pre: 0 <= pos <= size, other != null
    // post: insert all elements of other starting 
    // at given position
    // size() = old size() + other.size()
    public void insertAllSlowRunning(int pos, IntList other) {
        // check precon
        
        for(int i = 0; i < other.size; i++)
            this.insert(pos + i, other.values[i]);
    }
    
    public void insertAll(int pos, IntList other) {
        // make sure enough space
        int newSize = this.size + other.size;
        if(newSize > this.values.length)
            resizeArray(newSize * 2);
    }
    
    
    // pre: 0 <= pos <= size()
    // post: get(pos) returns newValue,
    // size() = old Size() + 1
    // elements at old positions greater than or
    // equal to pos are shifted one position to
    // the right
    public void insert(int pos, int newValue) {
        // check precondition
        
        if(size == values.length)
            resizeArray();
        
        // shift elements at index pos and greater 1 to the right
        for(int i = size; i > pos; i--) {
            values[i] = values[i - 1];
        }
        values[pos] = newValue;
        size++;
    }
    
    // pre: pos <= 0 < size()
    // post: get(pos) returns newValue, 
    // return old element at pos
    public int set(int pos, int newValue) {
        // check precon
        int oldElement = values[pos];
        values[pos] = newValue;
        return oldElement;
    }
    
    // pre: 0 <= pos < size()
    // remove and return element at given
    // position. old elements at position 
    // greater than pos shifted one element to the
    // left
    public int remove(int pos) {
        return -1;
    }
 
    // precondition: initialCap > 0
    // create an empty list with given capacity
    public IntList(int initialCap) {
        // check precondition
        if(initialCap <= 0)
            throw new IllegalArgumentException("Violation of precondition. " +
            		"Initial capacity must be greater than 0. value sent: " 
                    + initialCap);
        
        values = new int[initialCap];
        size = 0;
    }
    
    // pre: none
    // post: returns the size of this IntList
    public int size() {
        return size;
    }
    
    // default add method
    // pre: none
    // post: add newValue to the end of this IntList
    // post condition in more formal terms:
    // size() = old size() + 1, get(size() - 1) returns newValue
    public void add(int newValue) {
        if(values.length == size)
            resizeArray();
        // general case, capacity available
        values[size] = newValue;
        size++;
        // assert get(size() - 1) == newValue;
    }
    
    // pre: 0 <= pos < size()
    // post: return element in list at given position
    public int get(int pos) {
        if(pos < 0 || pos >= size())
            throw new IllegalArgumentException("violation of precondition. " +
            		"position out of bounds. pos: " + pos + ", size of list: " + size);
        return values[pos]; // O(1)
    }
    
    public String toStringSlow() {
        String result = "[";
        final int LIMIT = size() - 1;
        for(int i = 0; i < LIMIT; i++)
            result += get(i) + ", ";
        if(size() > 0)
            result += get(size() - 1);
        result += "]";
        return result;
     }
    
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        final int LIMIT = size() - 1;
        for(int i = 0; i < LIMIT; i++) {
            sb.append(get(i));
            sb.append(", ");
            // sb.append(get(i) + ", ");
        }
        
        if(size() > 0)
            sb.append(get(size() - 1));
        sb.append("]");
        return sb.toString();
     }
    
    private void resizeArray() {
        resizeArray(values.length * 2);
    }

    private void resizeArray(int newCap) {
        // int[] temp = new int[values.length + DEFAULT_CAP]; // increase cap by fixed amount
        int[] temp = new int[newCap]; // increase capacity by fixed percentage, 100% in this case
        System.arraycopy(values, 0, temp, 0, size);
        values = temp;
    }
    
    
    
//    public void printLengthOfValues() {
//        System.out.println(values.length);
//    }
}
