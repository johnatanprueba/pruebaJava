package co.prueba.com;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.plaf.synth.SynthScrollPaneUI;

interface Ok {
	private void ff() {
	};

	private static void main() {
	}
}

class Ax {
	int y;

	public void ff() {
	}

	Ax(String t, LocalDate y) {

	}

	class Bx extends Ax {
		Bx() {
			super("", LocalDate.now());
		}

		Bx(int d) {
			super("", LocalDate.now());
		}

		public void g() {

			this.ff();
			super.ff();

			this.y = 9;
			super.y = 10;
		}
	}
}

class Ki {
	{
		this.r = 9;
	}
	int r;
}



public class Prueba8 {

	int i = 9;

	public synchronized void saludar() {

		try {
			System.out.println("ENTRA A SALUDAR");
			i++;
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("FINALIZA A SALUDAR");
	}

	public void saludarDos() {
		System.out.println("dos----");
		System.out.println(i);
		System.out.println("fin dos----");
	}

	public static void main(String... args) throws Exception {
		
		Stream.generate(()->5).filter(x->x<5).limit(3).forEach(System.out::println);
		
		System.out.println("==================");

		Arrays.asList(1, 2, 3, 4, 5, 6).stream().skip(2).limit(4).forEach(System.out::println);

		Optional<Integer> optdd = Optional.ofNullable(null);
		optdd.get();

		// optdd.orElseThrow();

		final int kk;

		kk = 9;

		Prueba8 prueba8 = new Prueba8();

		ExecutorService es = Executors.newFixedThreadPool(10);
		es.submit(() -> prueba8.saludar());
		es.submit(() -> prueba8.saludarDos());

		es.shutdown();

		try (FileWriter fw = new FileWriter("D:\\WorkEclipse3\\PruebaJava\\Holaaa")) {

			fw.write("rrr");

			System.out.println("Hollalala");
		} catch (IllegalAccessError | ClassCastException | NumberFormatException e) {

		}

		Stream<Integer> s1 = Stream.of(3, 4).parallel();

		Stream<Integer> s2 = Stream.of(3, 5);

		System.out.println(s1.isParallel());

		System.out.println(s2.isParallel());

		System.out.println("concat mantiene paralel?" + Stream.concat(s1, s2).isParallel());

		// Visabuela f = new Persona();
		// System.out.println(f.i);

		Integer j = 3;

		a(j);

		Connection c = null;

		 //c.prepareStatement("", 1,2);

		// c.prepareCall("",1);

		System.out.println(Duration.between(LocalTime.of(9, 25), LocalTime.of(10, 25)));

		Object h = null;

		Integer i = (Integer) h;

		System.out.println("con null->" + i);

		int start = 7;
		int end = 4;
		end += ++start;
		start = (byte) (Byte.MAX_VALUE + 1);

		var t = 9;
		t = 8;

		OptionalInt opt = OptionalInt.of(3);

		opt.getAsInt();

		int gg = 9;
		String hii = switch (gg) {
		case 2 -> "ey";
		case 3 -> {
			yield "rr";
		}
		default -> {
			yield "#";
		}
		};

	}

//	static void a(Integer i) {
//		System.out.println("Integer");
//	}

	static void a(int i) {
		System.out.println("int");
	}

	static void pruebaException() throws IOException {

	}

	static void pruebaExcx() {
		try {
			pruebaException();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
