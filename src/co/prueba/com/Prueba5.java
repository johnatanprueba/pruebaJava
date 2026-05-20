package co.prueba.com;

import java.io.BufferedWriter;

import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


interface Iprueba {
	void prueba(String a,String b);
}

sealed class ClassSealed permits ClassSub {
}

non-sealed final class ClassSub extends ClassSealed {

}

interface IKK {
}

public class Prueba5 {

	public static void main(String[] args) {

//		BasicFileAttributes bfa=null;
//		
//		bfa.isDirectory();
//		bfa.isRegularFile();
//		bfa.isSymbolicLink();
//		
//		bfa.size();
//		
//		bfa.creationTime();
//		bfa.lastAccessTime();
//		bfa.lastModifiedTime();
//		
//		bfa.fileKey();

		NumberFormat nf = NumberFormat.getCompactNumberInstance(Locale.US, Style.SHORT);

		System.out.println(nf.format(1_500_000));

		System.out.println(Math.round(1.5));

		Integer j = -129;

		Integer i = -129;

		System.out.println(i == j);

		try (BufferedWriter bf = new BufferedWriter(new FileWriter("D:/WorkEclipse3/PruebaJava/src/Yuoo"))) {
			bf.write("xxxxxxxxxxxx");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// books.sort((Book a,Book b)->0);

		long[] longarray = new long[3];

		Long[] parr = new Long[4];

		System.out.println(0 % 4);

		punto6();

		punto7();

		punto9();

		interface Iul {
		}

		String strP = "hola:\n\nsaludos";

		System.out.println(strP);

		String[] arrstr = strP.split("(\n)+");

		System.out.println(arrstr[0]);
		System.out.println(arrstr[1]);

		punto10();

		System.out.println("==========");

		punto12();

		System.out.println("==========");

		punto13();

		System.out.println("==========");

		punto14();

		System.out.println("==========");

		punto15();

		System.out.println("==========");

		punto16();

		System.out.println("==========");

		punt18();

		System.out.println("==========");

		punto19();

		System.out.println("==========");

		punto20();

		System.out.println("==========");
		
		punto21();
		
		System.out.println("==========");

	}

	public static void saludar(long... args) {

	}

	public static void punto5() {

		var counter = 0;
		outer: for (var i = 0; i < 6; ++i) {
			middle: for (var j = 0; j < 6; j++) {
				inner: for (var k = 0; k < 6; k++) {

					System.out.println("Inside Loop - " + ++counter);

					if ((k % 4) == 0) {
						break outer;
					}
				}
			}
		}

	}

	public static void punto6() {

		String[] strs = { "A", "B", "C" };

		for (int x = 0; x < 2; ++x) {
			System.out.println(strs[x]);
		}
	}

	public static void punto7() {

		var num = 0.2;
		if (num == 0.2f) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	public static void punto8() {

		int y = 9;
		double result = switch (y) {
		case 1 -> {

			yield 1.0;
		}
		case 2 -> 2.0;
		default -> throw new IllegalArgumentException("Unexpected value: " + y);
		};

		switch (y) {
		case 1:
		case 2:
			System.out.println("f");
		}
	}

	public static void punto9() {

		String[] array = new String[2];
		for (int i = 0; i < array.length; i++) {

			System.out.println(array[i]);
		}
	}

	public static void punto10() {

		int y = 9;
		Integer j = null;
		int[] arr = new int[2];
		try {
			int h = y / 0;
		} catch (Exception e) {
			// j.toString();
		} finally {
			System.out.println("--->");
			// arr[2]=8;
		}

	}

	public static void punto11() {

		var ins = IntStream.range(1, 4);

		ins.peek(s -> System.out.print(s * 2)).forEach(System.out::print);
	}

	public static void punto12() {

		var list = new ArrayList<>();

		list.add(new Integer(10));
		list.add(new Double(1.2));

		System.out.println(list.get(0) + "" + list.get(1));

	}

	public static void punto13() {

		String[] strArr = { "A", "AA", "B", "1", "11", "b" };

		System.out.println(Arrays.toString(strArr));

	}

	public static void punto14() {

		var ldt = LocalDate.of(2015, 11, 12);

		var duration = Period.ofMonths(3).plusYears(-1);

		System.out.println(duration);

		var durationDos = Period.ofYears(1).ofWeeks(1);

		System.out.println(durationDos);

	}

	public static void punto15() {

		var reloc = new ReentrantLock();

		System.out.println(reloc.tryLock());

		System.out.println(reloc.tryLock());
	}

	public static void punto16() {

		var list = Arrays.asList(2, 8);

		var map = list.parallelStream().collect(Collectors.groupingByConcurrent(i -> i % 2 == 0 ? 0 : 1));

		System.out.println(map.get(0));

	}

	public static void punto17() throws Exception {

		var list = new ArrayList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);

		var stream = Files.readAllLines(null);

	}

	public static void punt18() {

		UnaryOperator<String> opr1 = s -> {
			System.out.print(1);
			return s.toUpperCase();
		};
		UnaryOperator<String> opr2 = s -> {
			System.out.print(2);
			return new StringBuilder(s).reverse().toString();
		};
		UnaryOperator<String> opr3 = s -> {
			System.out.print(3);
			return s.substring(2);
		};

		Function f = opr1.andThen(opr2).compose(opr3); // Line n1
		System.out.println(f.apply("amar")); // Line n2

	}

	public static void punto19() {

		LongStream.iterate(0, i -> i + 2).limit(4).forEach(System.out::print);
	}

	public static void punto20() {

		var cb = new CyclicBarrier(6, () -> System.out.println("HURRAH!"));
		var es = Executors.newFixedThreadPool(5);
		IntStream.rangeClosed(1, 10).parallel().forEach(x -> es.submit(() -> cb.await()));
		es.shutdown();
	}

	public static void punto21() {
		
		List<String> list = Arrays.asList("7 Seven", "Lucky 7", "77", "O7ne");
		list.stream()
		.filter(str -> str.contains("7"))
		.forEach(System.out::println);

	}

}
