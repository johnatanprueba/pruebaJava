package co.prueba.com;

import java.io.BufferedOutputStream;

import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import co.prueba.Pato;



enum CONSTANTES {
	A, B, C {
		public void salir() {
		}
	};
}

record MyRecord(int y, String h) {

	MyRecord {
		y = 9;
		h = "";
	}

	MyRecord(int y, String h, int hi) {
		this(y, h);
		System.out.println();

	}
}

interface Ilionois {
	void probar();
}

class Estado {
	public void probar() {
	}
}

class Country extends Estado implements Ilionois {
}

class Electronica {
	private int id;

	class Inner {
		public void saludar() {
			System.out.println(Electronica.this.id);
		}
	}
}

enum Animal {
	TORTUGA {
	},
	PATO {
		public void decirQuack() {
		}
	};

	public void decirQuack() {
	}
}

public class PatoGris extends Pato {

	int valorPato;

	void nadar(){
		saludar();
		System.out.println(text);
	}

	public static void main(String... args) throws Exception {

		String valorPato = "";

		PatoGris p = new PatoGris();
		p.saludar();

		var ani = Animal.PATO;
		ani.decirQuack();

		byte i = 127;

		Comparator<Integer> com = new Comparator<Integer>() {
			int y = 9;

			public int compare(Integer i1, Integer i2) {
				return 0;
			}
		};

		List<String> list1 = List.of("a", "b");

		list1.stream().spliterator().forEachRemaining(System.out::println);

		List<String> list2 = List.of("a", "b");

		System.out.println(list1.equals(list2));

		Set<String> set = Set.of("a", "b");
		Set<String> set2 = Set.of("b", "a");
		System.out.println(set.equals(set2));

		try (OutputStream fo = new BufferedOutputStream(
				new FileOutputStream("D:\\WorkEclipse3\\PruebaJava\\src\\MiPato.txt"))) {

		}

		int kk = 9;
		int hhh = switch (kk) {
		case 1 -> 5;
		case 2 -> {
			yield 8;
		}
		default -> 4;
		};

		switch (kk) {
		case 5 -> {
			int g = 0;
		}
		}

		record Craneo() {
		}

		Craneo cr = new Craneo();
		new PatoGris().buuble(3);

		boolean pr = true;
		boolean prT = true;
		if (pr)
			if (prT)
				System.out.println("%&%");
			else
				System.out.println("===");

		Stream<Integer> strU = Stream.of(1, 2, 3);
		strU.reduce(0, (x, y) -> x.byteValue() + y, (a1, b1) -> a1 + b1);

		String esc = """
				a\
				b
				""";

		System.out.println(esc.length());
		
		
		System.out.println(List.copyOf(Arrays.asList(3,4,5)));
		
	}

	public void buuble(int y) {
		System.out.println("Simple");
	}

	public void buuble(int... y) {
		System.out.println("Params");
	}
}
