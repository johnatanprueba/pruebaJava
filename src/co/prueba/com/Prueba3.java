package co.prueba.com;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

sealed class AUI{
	
}

final class BUI extends AUI{
	
}

public class Prueba3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> listStr = Arrays.asList("a","b","c");
		
		List<List<String>> listOf = List.of(listStr);
		
		var str= """
				                                                                            hola
				                                                                           g""";
		
		System.out.println(str.length());
		
		System.out.println(str.indent(1).length());		
		
		var ia = new int[][]{{1,2},null};
		
		byte h = 127;
		
		List.of(1,2,3).stream().max((x,y)->x-y);
		
		List.of(1,2,3).stream().mapToInt(x->x).max();
		
		int hy;
		hy = 7;
		Supplier<Integer> si= ()->hy;
		
		
		
	}

}
