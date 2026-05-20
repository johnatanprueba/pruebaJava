package co.prueba;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.DoubleConsumer;
import java.util.function.IntToLongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.*;
class GE<T> {
	T t;
	
	public T obt(T t) {
		this.t = t;
		return t;
	}
}

interface R {
	public static void saludo() {
	}
}

class CR {
	public static void saludo() {
	}
}

class CRH implements R {

	public void saludo() {
	}
}

interface A1 {
	public default int hola() {
		return 6;
	};
}

interface A2 {
	public default int hola() {
		return 4;
	};
}

interface A3 extends A1, A2 {
	@Override
	public default int hola() {
		return 5;
	}
}

interface B {
	boolean valor(String h);
}

interface MyInterface {
}

sealed class MyClass permits MySubClase {

}

final class MySubClase extends MyClass {
}

class H {
	public int yh;
}

public class Valve {
	private int chambers = -1;
	private transient Double size = null;
	private static String color;
	

	public Valve() {
		this.chambers = 3;
		color = "Blue";
	}

	public void saludar() {
		IntToLongFunction chambers = (x) -> (long) x;
	}

	public static void main(String... args) throws Throwable {

		class F {
			static int y = 8;
		}

		NumberFormat e = NumberFormat.getInstance();
		Number er = e.parse("2,23");

		System.out.println(Locale.getDefault());
		System.out.println(er);

		NumberFormat ecu = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		Number ecuR = ecu.parse("$8");
		System.out.println(ecuR);

		NumberFormat ecom = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), Style.SHORT);

		System.out.println(ecom.format(124_987));

		NumberFormat pri = new DecimalFormat("###.#00");

		String priNum = pri.format(41172.3);

		System.out.println("decimal format:" + priNum);

		IntStream is = IntStream.range(0, 4);

		System.out.println(is.count());

		System.out.println("--");

		List.of(3, 4, 1, 5, 6).stream().sorted().peek(System.out::println).collect(Collectors.toList())
				.forEach(System.out::println);

		Integer u = null;

		String pru = (String) null;

		System.out.println("pru" + pru);

		// Optional<String> opt = Optional.of(null);

		var listNum_2 = List.of(4, 5, 3);

		var listNum_3 = listNum_2.stream().sorted().collect(Collectors.toList());

		System.out.println(listNum_3);

		Stream.iterate(4, i -> i + 1).findFirst().ifPresent(System.out::println);

		String regex = "\\d+";

		String numberT = "1549a";

		System.out.println(numberT.matches(regex));

		Object[] mo = new Object[2];

		String jo = (String) mo[0];

		System.out.println(jo);

		LocalDateTime ldt = LocalDateTime.now();

		System.out.println(ldt);

		System.out.println(DateTimeFormatter.ISO_DATE.format(ldt));

		// System.out.println(String.valueOf(null));

		long num = 10;
		num += 10;
		int numa = 4;
		var numb = num + numa;
		System.out.println(numb);

		ToDoubleFunction<String> x = c -> Double.parseDouble(c);
		LongToDoubleFunction y = v -> v;

		// Consumer<Double> z = s -> System.out.println("Hola Mundo:" + s);
		DoubleConsumer z = s -> System.out.println("Hola Mundo:" + s);
		double d1 = x.applyAsDouble("1");
		double d2 = y.applyAsDouble(1L);
		z.accept(1.0);

		var list = List.of(1, 2);
		// list.add(4);

		final long i = 9, yt = 6;

		int[] myarr_1 = { 1, 2, 3 };
		int[] myarr_2 = { 1, 2, 3, 3 };

		System.out.println("mismacth:" + Arrays.mismatch(myarr_2, myarr_1));
		System.out.println("compare:" + Arrays.compare(myarr_2, myarr_1));

		String hp = "a\nb";
		String hps = """
				        a
					b
				""";
		System.out.println(hp.equals(hps));
		System.out.println(hps.replace(" ", "*"));
		System.out.println(hps.length());
		System.out.println(hps.stripIndent().length());

		class LocalHola {
			static void hola() {
			}
		}

		var a = new A1() {
			static void ttt() {
				System.out.println("SALTA MONTES");
			}
		};

		a.ttt();

		Path opo = Paths.get("hola/ey");
		System.out.println(opo.toAbsolutePath());
		Files.createDirectories(Paths.get("hola/ey"));

		String[][] arr = { { "%", "$$" }, { "***", "@@@", "#####" } };
		for (String[] str : arr) {
			for (String s : str) {
				System.out.println(s);
				if (s.length() == 4)
					break;
			}
			break;
		}

		StringBuilder se = new StringBuilder("e");
		StringBuilder se1 = new StringBuilder("e");
		System.out.println(se.equals(se1));

		GE<String> ge = new GE<>();
		ge.obt("Hola");

		System.out.println(ge.t);

		String text = null;
		// System.out.println(text.repeat(3));
		// System.out.println(null+null+null);
		System.out.println(null + "null" + null);
		// System.out.println(text*=3);
		System.out.println(text += "null".repeat(2));
		// System.out.println(text+text+text);
		// text+=null;System.out.println(text.concat(null));
		// System.out.println(text + = "null".repeat(2));

		String ho = "f".repeat(8);
		System.out.println(ho);

		System.out.println(Paths.get("/t").getParent());

		Stream<Integer> ss = Stream.of(2, 4, 6);

		System.out.println(ss.noneMatch(ioo -> ioo % 2 != 0));

		MyClass mm = new MyClass();

		if (mm instanceof MyInterface) {

		}

	}

	void ff(H h) {
		h.yh = 9;
		H he = h;
	}

	static void ff1() {
	}

}

class D extends H {

	private abstract class KK {
		abstract void f();
	}
}

record Hola() implements A1, A2 {
	static int v;
	static {

	}

	public int hola() {
		return 8;
	}

	public static void h(String j, int g) {
	}
}
