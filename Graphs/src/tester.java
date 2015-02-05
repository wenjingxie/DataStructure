
public class tester {

	public static void main(String[] args) {
		int[] list = {44,37,38,59};
		for(int i = 0; i < list.length; i++) {
			int min = i;
		    for(int j = i + 1; j < list.length; j++){
		        if( list[j] < list[min] ){
		        	min = j;
		            int temp = list[i]; 
		            list[i] = list[min];
		            list[min] = temp;
		           // System.out.println(min);
		            System.out.println(list[0] + " " + list[1] + " " +list[2] +" " + list[3]);
		        }
	         }
		}
		int x = 6/3;
		System.out.println(x);
		
		
		String s;
		int[] ss;
		
}
}