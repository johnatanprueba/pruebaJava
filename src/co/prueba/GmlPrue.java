package co.prueba;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

interface I111{
	
	default void saludo() {}
	
}

interface I2222{
	
	default void saludo() {}
	
}

interface I3 extends I111,I2222{
	default void saludo() {}
	
	static void ff() {}
	
	private static void gt() {}
	
	private void gtt() {}
	
	
}


public class GmlPrue {

	static int[] myArray = {1,2,1,3,3,1,2,1,5,1}; 
	static int n=3;
	
	static int[] myArrayDos = {1,1,1,2,2,2,3,3,3};

	public static void main(String args[]) throws Exception{
		
		//2024-07-15 23:59:59.999
		
		String sDate1="2024-07-15 23:59:59.999";  
	    Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(sDate1);  
	    System.out.println(sDate1+"\t"+date1);  
		
		List<Integer> list =  new ArrayList<>();
		for(int i:myArray) {
			list.add(i);
		}
		
		Map<Integer,Long> map =list
		.stream()
		.collect(Collectors.groupingBy(x->x,TreeMap::new,Collectors.counting()));
		
		
		for(int i = 1;i<=5;i++) {
			
			Long val = map.get(i);
			
			String re = "";
			if(val!=null) {
				re = "*".repeat(val.intValue());
			}
			
			System.out.println(i+" : "+re);
			
		}
		
		int[][] temp = new int[3][3];
		
		int renglo = -1;
		
		for(int i = 0;i<myArrayDos.length;i++) {
		
			if(i%3==0) {
				renglo++;
			}
			
			temp[renglo][i%3] = myArrayDos[i];
		}
		
		for(int i=0;i<temp.length;i++) {
			
			for(int j=0;j<temp[i].length;j++) {
				System.out.print(" "+temp[i][j]);
			}
			System.out.println();
		}
		
	}

}
