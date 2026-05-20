package co.prueba.com;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

class Uj implements Serializable {
	{
		id = 8;
	}
	private int id;

	private int j = 9;
	static int h = 9;
}

interface Oii{
	
	void fg();
}

class Jhh implements Oii{
	
	@Override
	public void fg() {}
}

record Crane() implements Serializable {
}

interface I10v1 {

	public default void saludar() {
	};

	// int hashCode();

	default int hashCodee() {
		return 1;
	}
}

class Perro implements I10v1 {

	public void mimetodo() {
		// super.saludar();
	}
}

class Gato extends Perro {

	public void mimetodoGato() {
		super.saludar();
	}
}

interface I10v2 {
	char val(String a, Integer b);

}

interface I10v3 {
	int val(char a);

}

interface I10v4 {
	int val(int a, int b);

}

interface I10v5 {
	String sub(String h, int a, int b);

}

interface I10v6 {

	void hola();
}

interface I10v7 {
	void hola();
}

interface I10v8 extends I10v6, I10v7 {
}

class MyThrea {

	int i = 0;

	public synchronized void saludar() {
		System.out.println("INICIO....");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception

		}
		System.out.println("FIN....");
	}

	public synchronized void saludardos() {
		System.out.println("INICIO DOS....");
		try {
			// Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("FIN DOS....");

	}
}

class Cat implements AutoCloseable {

	public void close() {
	}
}

class Jhiden{
	
//	public Jhiden(int g) {
//		// TODO Auto-generated constructor stub
//		System.out.println("constrcutor:"+g);
//	}
	
	public static void saludarHr() {}
}

class Hhiden extends Jhiden{
	
	public void saludar() {
		super.saludarHr();
	}
}

public class Prueba10 {

	public static void mimetdo(int... i) {
		System.out.println("Hola int");
	}

	public static void main(String... args) throws Exception{

		Integer i = 2;
		mimetdo(i);

		IntStream in = IntStream.range(0, 3);
		in.summaryStatistics();

		// in.count();

		DoubleStream ds = DoubleStream.empty();
		ds.count();

		Comparator h = Comparator.reverseOrder().reversed();

		List<Integer> list = Arrays.asList(3, 2, 5);

		list.sort(h);

		I10v2 i10v2 = String::charAt;

		System.out.println(i10v2.val("abcdef", 3));

		String hj = "123";
		System.out.println(hj.indexOf('2'));

		I10v3 i10v3 = hj::indexOf;
		System.out.println(i10v3.val('4'));

		I10v4 i10v4 = Integer::compare;

		String pru = "";

		I10v5 i10v5 = String::substring;

		System.out.println(i10v5.sub("0123456", 0, 5));

		MyThrea myThrea = new MyThrea();

		var executeService = Executors.newFixedThreadPool(2);
		executeService.submit(() -> myThrea.saludar());
		executeService.submit(() -> myThrea.saludardos());
		executeService.shutdown();

		// int y = 9;
		Predicate<Integer> p = x -> {
			// y = 8;
			return true;
		};

		String vao = """
				a \s""";

		System.out.println("cantidad:" + vao.length());

		var tt = new Consumer<String>() {

			public void accept(String g) {
				System.out.println("Hola");
			}
		};

		int[][] arr = new int[2][2];
		for (int[] x : arr) {
		}

		int $3$$$$___ = 8;

		// System.out.println(Files.deleteIfExists(Paths.get("D:/WorkEclipse3/PruebaJava/src/Yuoo")));

		System.out.println(DateTimeFormatter.ISO_DATE.format(LocalDateTime.now()));

		System.out.println(NumberFormat.getCompactNumberInstance().format(135_500_000));

		List<Integer> lisI = null;

		List<? extends Integer> litE = lisI;

		var jj = """
				a   /s""";

		System.out.println(jj.length());

		int k, o, pp = 0;

		IntStream is = null;
		// is.count();

		List<String> myLIst = Arrays.asList("1", "2");
		myLIst.stream().reduce(0f, (w, x) -> w.floatValue() + x.length(), (y, z) -> y.floatValue() + z.floatValue());

		NoSuchElementException jje = null;

		Optional jjcc = Optional.empty();
		// jjcc.orElseThrow();// java.util.NoSuchElementException

		System.out.println("abc".indent(0).length());

		try (Cat cat = new Cat()) {
		}
		
		System.out.println(Files.mismatch(Paths.get("a/b"), Paths.get("a/b")));
		
		
		List<String> listStr =  Arrays.asList("aaa","c","bb");
		
		//listStr.sort((x,y)->x.length()-y.length());
		
		//Collections.sort(listStr);
		
		Collections.reverse(listStr);
		
		System.out.println(listStr);
		
		// 
		Path pa = Paths.get("a/b/c");
		Path pb = Paths.get("b/c");
		
		System.out.println("hola path ruta:"+pa.relativize(pb));
		
		System.out.println("hola path:"+pa.relativize(pb).getNameCount());
		
		BiFunction<String,Integer, Character> bifu = String::charAt;
		
		System.out.println("BiFunction:"+bifu.apply("abcde", 3));
		
		String hh = "abcde";
		
		Function<Integer, Character> fun = hh::charAt;
		
		try(var fw = new FileWriter("D:\\WorkEclipse3\\PruebaJava\\src\\YuooInoutStream")){
			fw.write("Holalalalalalalallllllllll");
		}
		
//		var jiden = new Jhiden(8) {
//			public void m() {System.out.println("888888");}
//		} ;

//		jiden.m();
		
		int[] myArray1 = new int[] {1,2,3,4,5,6,7,8};
		
		int[] myArray2 = new int[] {1,2,3};
		
		System.out.println(Arrays.compare(myArray1, myArray2));
		
		byte f = -128;
		
		final int u = 9,po;
		
		po = 8;
		//po = 89;
		
		int[] jf = {1,2};
		for(int ppg:jf) {}
		
		System.out.println();
	}

	public static List<? extends Number> miMetodo(List<? super Integer> list) {
		return null;
	}

	public static <X extends Integer> List<X> miMetodoEstatico(List<X> list) {
		return null;
	}

	public static void muu() {
		NoSuchElementException jje = null;
		Optional jj = null;
		jj.orElseThrow();
		throw jje;
	}

}
