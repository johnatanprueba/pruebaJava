package co.prueba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleFunction;
import java.util.stream.Collectors;

interface PruInter{}
class MyClassPru implements PruInter{}

interface Iok {
	public default void saludar() {
	};
}

class Uij implements Iok {
	public void m() {

	}
}

class Kjj extends Uij {
	public void n() {
		super.saludar();
	}
}

class Uj {
	int s = 0;

	Uj(int h) {
		System.out.println("h:" + h);
	}
}

record myRecord(String val) implements Serializable {
	public void mimetodo() {
		System.out.println("val" + val);
	}
}

class Ukks extends Uj {

	Ukks(int h) {
		super(h);
		System.out.println("HOL");
	}
}

class Ser implements AutoCloseable {

	int y;

	public void close() {
	}
}

class Names {
	private List<String> list;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void printName() {
		System.out.println(getList());
	}
}

 class Pr{}

public class Pragma2 {
	
	public static void m(int...i) {
		System.out.println("int...i");
	}
	
//	public static void m(Integer i) {
//		System.out.println("Integer");
//	}
	
	static int contador;
	
	interface Ikk_1{
		void saludar();
	}
	interface Ikk_2{
		void saludar();
	}
	
	interface Ikk_3 extends Ikk_1,Ikk_2{}

	public static void main(String... args) throws ClassNotFoundException, IOException {
		
		//PruInter pruInter = new MyClassPru();

//		new Ukks(34);
//
//		Integer i = null;
//		if (i == 9) {
//			System.out.println("HOla");
//		}
//
//		List<Integer> list = new ArrayList<Integer>();
//
//		for (Integer jj : list) {
//		}

		int[][][] arr = { { { 1, 3, 4 }, { 2 }, { 78 }, { 89 } }, { { 3 } } };

		// System.out.println(Arrays.toString(arr));

		System.out.println(arr.length);
		System.out.println(arr[0].length);
		System.out.println(arr[0][0].length);

		long a = 0;

		byte k = 0;

		try (ObjectInputStream f = new ObjectInputStream(new FileInputStream(""))) {

		} catch (IOException e) {
			// TODO: handle exception
		}

		DoubleFunction<String> df = x -> new String("");

		List<String> list = Arrays.asList("a", "b", "c");
		list.set(0, "z");

		System.out.println(list);

		List<String> listAux = List.of("x", "y", "z");
		// listAux.set(0, "t");

		Ser ser_1 = new Ser();
		ser_1.y = 1;

		Ser ser_2 = new Ser();
		ser_2.y = 2;

		List<Ser> listSer = List.of(ser_1, ser_2);
		ser_1.y = 78;

		String str = """
				a\n
				b
				""";
		System.out.println(str);

		Map<Integer, Integer> map = Map.of();

		try {
			// var t = new FileInputStream(new File("12"));
			var t = new FileOutputStream("D:\\WorkEclipse3\\PruebaJava\\src\\Text3");
		} catch (Exception e) {
			e.printStackTrace();
		}

		int h = 9;
		int g = switch (h) {
		case 2 -> 4;
		case 3 -> {
			yield 6;
		}
		default -> 0;
		};

		LocalDateTime lct = LocalDateTime.of(2025, 8, 22, 23, 38);

		System.out.println(DateTimeFormatter.ISO_DATE.format(lct));

		NumberFormat num = NumberFormat.getCompactNumberInstance();
		String val = num.format(7_123_456);
		System.out.println(val);

		List<? super IOException> listSu = new ArrayList<Exception>();
		
		Pragma2 paPragma2 = new Pragma2();
		Integer kk =9;
		m(kk);
	
		var miarray = Arrays.asList("1",null);
		System.out.println(miarray);
		
		
	};
}
